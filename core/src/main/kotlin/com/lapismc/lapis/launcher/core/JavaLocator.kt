package com.lapismc.lapis.launcher.core

/**
 * Finds Java installations on the current system.
 */
class JavaLocator {
    companion object {
        /**
         * Retrieves the running Java version.
         * @return Information about the Java running this program.
         */
        private fun current(): SystemJava {
            val version = System.getProperty("java.runtime.version")
            val path    = System.getProperty("java.home")
            val is64bit = System.getProperty("os.arch").endsWith("64")
            return SystemJava(version, path, is64bit)
        }
    }

    /**
     * Attempt to find all Java versions installed on the local system.
     * @return Set of known Java versions.
     */
    fun discover(): List<SystemJava> {
        return listOf(current())
        // TODO: Find other versions of Java installed on the system.
    }
}