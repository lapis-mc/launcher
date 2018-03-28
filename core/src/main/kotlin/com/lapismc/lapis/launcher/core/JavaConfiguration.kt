package com.lapismc.lapis.launcher.core

/**
 * Information about how to configure and run Java for the game.
 * @param java Locally installed Java version to use for the game.
 * @param minimumMemory Minimum amount of memory to allocate to Java, in megabytes.
 * @param maximumMemory Maximum amount of memory to allocate to Java, in megabytes.
 * @param additionalArguments Set of extra command-line arguments to pass to Java.
 */
data class JavaConfiguration(val java: SystemJava, val minimumMemory: Int, val maximumMemory: Int, val additionalArguments: List<String>)