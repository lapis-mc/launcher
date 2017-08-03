package com.lapismc.lapis.launcher.core

import java.nio.file.spi.FileSystemProvider

/**
 * File and directory layout for multiple Minecraft versions that can share resources.
 * @param fileSystemProvider Provides access to where the instances are stored to and retrieved from.
 */
class SharedInstanceStore(fileSystemProvider: FileSystemProvider) : InstanceStore(fileSystemProvider) {
}