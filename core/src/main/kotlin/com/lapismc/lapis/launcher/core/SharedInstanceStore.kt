package com.lapismc.lapis.launcher.core

import java.nio.file.spi.FileSystemProvider

/**
 * File and directory layout for multiple Minecraft versions that can share resources.
 * @param fileSystemProvider Provides access to where the instances are stored to and retrieved from.
 */
class SharedInstanceStore(fileSystemProvider: FileSystemProvider) : InstanceStore(fileSystemProvider) {
    /**
     * Adds an asset to the storage.
     * @param asset Information about the asset.
     * @param data Contents of the asset to store in the file.
     */
    override fun addAsset(asset: AssetContent, data: ByteArray) = TODO()

    /**
     * Verifies the contents of an asset are correct.
     * @param asset Information about the asset.
     */
    override fun verifyAsset(asset: AssetContent) = TODO()
}