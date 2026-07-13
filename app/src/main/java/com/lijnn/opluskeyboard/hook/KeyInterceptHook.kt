package com.lijnn.opluskeyboard.hook

import android.view.KeyEvent
import com.github.kyuubiran.ezxhelper.utils.findMethod
import com.github.kyuubiran.ezxhelper.utils.hookBefore

class KeyInterceptHook : BaseHook() {

    override fun init() {

        findMethod("com.android.server.policy.PhoneWindowManager") {
            name == "interceptKeyBeforeQueueing"
        }
                .hookBefore { param ->
                    val e = param.args[0] as? KeyEvent ?: return@hookBefore
                    if (shouldPass(e)) param.result = 1
                }

        findMethod("com.android.server.policy.PhoneWindowManager") {
            name == "interceptKeyBeforeDispatching"
        }
                .hookBefore { param ->
                    val e = param.args[1] as? KeyEvent ?: return@hookBefore
                    if (shouldPass(e)) param.result = 0L
                }
    }

    private fun shouldPass(e: KeyEvent): Boolean {

        if (e.keyCode == KeyEvent.KEYCODE_META_LEFT || e.keyCode == KeyEvent.KEYCODE_META_RIGHT)
                return true

        if (e.isMetaPressed) return true

        if (e.isAltPressed && e.keyCode == KeyEvent.KEYCODE_TAB) return true
        return false
    }
}
