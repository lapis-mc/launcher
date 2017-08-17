package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.OSType
import oshi.SystemInfo
import java.nio.file.Paths

/**
 * Information about a version of Java installed on the system.
 * @param version Java version string (e.g. 1.8.0_144).
 * @param path Absolute path to the Java installation.
 * @param is64bit Flag indicating whether Java is 64-bit.
 */
data class SystemJava(val version: String, val path: String, val is64bit: Boolean) {
    companion object {
        /**
         * Retrieves the running Java version.
         * @return Information about the Java running this program.
         */
        fun current(): SystemJava {
            val version = System.getProperty("java.runtime.version")
            val path    = System.getProperty("java.home")
            val is64bit = System.getProperty("os.arch").endsWith("64")
            return SystemJava(version, path, is64bit)
        }

        /**
         * Gets the name of the Java executable for the current operating system.
         * @return Java program name.
         */
        private fun javaProgramName() = when(OSType.current) {
            OSType.WINDOWS -> "java.exe"
            else -> "java"
        }

        /**
         * Bytes in a gigabyte, used to syntactical conversion.
         */
        private val GB = (1024L * 1024L * 1024L)
    }

    /**
     * Path to the executable to run Java.
     */
    val executable = Paths.get(path, "bin", javaProgramName()).toString()

    /**
     * Calculates the maximum amount of memory this installation of Java can use.
     * @return Memory size in bytes.
     */
    fun maximumPossibleMemory(): Long {
        val sysInfo = SystemInfo()
        val totalSysMemory = sysInfo.hardware.memory.total
        return if(is64bit && sysInfo.hardware.processor.isCpu64bit)
            totalSysMemory
        else
            Math.min(totalSysMemory, osMaxHeap())
    }

    /**
     * Recommended maximum memory Java should use for a 32-bit environment.
     * @return Memory size in bytes.
     */
    private fun osMaxHeap() = when(OSType.current) {
        OSType.LINUX   -> 3 * GB
        OSType.OSX     -> 4 * GB
        OSType.WINDOWS -> 2 * GB
    }
}