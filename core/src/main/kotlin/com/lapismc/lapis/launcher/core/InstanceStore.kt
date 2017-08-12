package com.lapismc.lapis.launcher.core

import java.nio.file.spi.FileSystemProvider

/**
 * Access to file and directory layout for Minecraft instances.
 * @param fileSystemProvider Provides access to where the instances are stored to and retrieved from.
 */
abstract class InstanceStore(protected val fileSystemProvider: FileSystemProvider) {
    /**
     * Adds an asset to the storage.
     * @param assetArg Asset information and content.
     */
    abstract fun addAsset(assetArg: AssetArg)
}