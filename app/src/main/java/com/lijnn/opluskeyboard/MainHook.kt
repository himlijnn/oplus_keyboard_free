package com.lijnn.opluskeyboard

import com.github.kyuubiran.ezxhelper.init.EzXHelperInit
import com.lijnn.opluskeyboard.hook.BaseHook
import com.lijnn.opluskeyboard.hook.KeyHook
import com.lijnn.opluskeyboard.hook.KeyInterceptHook
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.callbacks.XC_LoadPackage

class MainHook : IXposedHookLoadPackage {

    private val hooks: List<BaseHook> =
            listOf(
                    KeyInterceptHook(),
                    KeyHook(),
            )

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName != "android") return

        EzXHelperInit.initHandleLoadPackage(lpparam)

        hooks.forEach { hook ->
            if (hook.initialized) return@forEach
            hook.init()
            hook.initialized = true
        }
    }
}
