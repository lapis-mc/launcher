package com.lapismc.lapis.launcher.core

/**
 * Information about how to configure and run Java for the game.
 * @param java Locally installed Java version to use for the game.
 * @param minimumMemory Minimum amount of memory to allocate to Java, in bytes.
 * @param maximumMemory Maximum amount of memory to allocate to Java, in bytes.
 * @param additionalArguments Set of extra command-line arguments to pass to Java.
 */
data class JavaConfiguration(val java: SystemJava, val minimumMemory: Long, val maximumMemory: Long, val additionalArguments: List<String>)