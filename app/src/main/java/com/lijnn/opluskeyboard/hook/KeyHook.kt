package com.lijnn.opluskeyboard.hook

import com.github.kyuubiran.ezxhelper.utils.findMethod
import com.github.kyuubiran.ezxhelper.utils.hookReturnConstant

class KeyHook : BaseHook() {

    private data class Candidate(val clazz: String, val method: String, val ret: Any?)

    override fun init() {
        val list =
                listOf(
                        Candidate(
                                "com.android.server.policy.PhoneWindowManagerExtImpl",
                                "interceptKeyEventToLauncherIfNeed",
                                false
                        ),
                        Candidate(
                                "com.android.server.policy.OplusModifierShortcutManager",
                                "interceptKey",
                                false
                        ),
                )

        for (c in list) {
            try {
                findMethod(c.clazz) { name == c.method }.hookReturnConstant(c.ret)
            } catch (_: Exception) {}
        }
    }
}
