package com.lapismc.lapis.launcher.core

import java.nio.file.spi.FileSystemProvider

/**
 * File and directory layout for a single instance of Minecraft.
 * Resources are stored so that other instances should not expect to access them.
 * @param fileSystemProvider Provides access to where the instances are stored to and retrieved from.
 */
class StandaloneInstanceStore(fileSystemProvider: FileSystemProvider) : InstanceStore(fileSystemProvider) {
    /**
     * Adds an asset to the storage.
     * @param assetArg Asset information and content.
     */
    override fun addAsset(assetArg: AssetArg) = TODO()
}