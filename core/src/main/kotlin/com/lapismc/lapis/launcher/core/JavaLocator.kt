package com.lapismc.lapis.launcher.core

class JavaLocator {
    /**
     * Attempt to find all Java versions installed on the local system.
     * @return Set of known Java versions.
     */
    fun discover(): List<SystemJava> {
        return listOf(SystemJava.current())
        // TODO: Find other versions of Java installed on the system.
    }
}