package com.kaizensoftware.visitstory.common.util

import org.springframework.stereotype.Component
import java.util.Arrays

@Component
class ObjectUtil {

    fun merge(fromObject: Any, toObject: Any) {

        Arrays.stream(fromObject.javaClass.methods).forEach { fromMethod ->

            if (!fromMethod.name.toLowerCase().contains("class")) {

                val startsWithGet = fromMethod.name.startsWith("get")
                val startsWithIs = fromMethod.name.startsWith("is")

                if (startsWithGet || startsWithIs) {

                    val fromMethodName = fromMethod.name
                    val toMethodName = fromMethodName.replace(if (startsWithGet) "get" else if (startsWithIs) "is" else "get", "set")

                    try {

                        val toMethod = toObject.javaClass.getMethod(toMethodName, fromMethod.returnType)
                        val value = fromMethod.invoke(fromObject, null as Array<Any>?)

                        if (value != null) {

                            if (value is Long) {
                                if (value != 0L) {
                                    toMethod.invoke(toObject, value)
                                }
                            } else {
                                if (value is String) {
                                    toMethod.invoke(toObject, value)
                                } else {
                                    if (value is Boolean) {
                                        toMethod.invoke(toObject, value)
                                    }
                                }
                            }
                        }
                    } catch (ignored: Exception) {
                    }

                }

            }

        }

    }

}