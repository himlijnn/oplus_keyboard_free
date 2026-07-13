package com.lijnn.opluskeyboard.hook

abstract class BaseHook {

    var initialized: Boolean = false
        internal set

    open val name: String = this::class.java.simpleName

    abstract fun init()
}
