package com.seraphim.core.logger

import io.github.aakira.napier.Napier

object Logger {
    fun v(message: String) = Napier.v(message, tag = callerTag())
    fun d(message: String) = Napier.d(message, tag = callerTag())
    fun i(message: String) = Napier.i(message, tag = callerTag())
    fun w(message: String) = Napier.w(message, tag = callerTag())
    fun e(message: String) = Napier.e(message, tag = callerTag())

    @PublishedApi
    internal fun callerTag(): String {
        val stack = Throwable().stackTrace
        // 0: callerTag, 1: Logger.xxx, 2: 调用Logger的地方
        if (stack.size > 2) {
            val element = stack[2]
            val className = element.className.substringAfterLast('.')
            return "$className.${element.methodName}"
        }
        return "Logger"
    }
}