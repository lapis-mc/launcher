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
         * Gets the name of the Java executable for an operating system.
         * @param osType Type of operating system to get the executable name for.
         * @return Java program name.
         */
        private fun javaProgramName(osType: OSType = OSType.current) = when(osType) {
            OSType.WINDOWS -> "java.exe"
            else -> "java"
        }

        /**
         * Recommended maximum heap memory Java should use for a 32-bit environment.
         * @param osType Type of operating system to get the memory for.
         * @return Memory size in bytes.
         */
        private fun osMaxHeap(osType: OSType = OSType.current) = when(osType) {
            OSType.LINUX   -> 3 * GB
            OSType.OSX     -> 4 * GB
            OSType.WINDOWS -> 2 * GB
        }

        /**
         * Bytes in a gigabyte, used for syntactical conversion.
         */
        private const val GB = (1024L * 1024L * 1024L)
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
}