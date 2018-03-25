package com.lapismc.lapis.launcher.core

import java.nio.file.Path
import java.nio.file.spi.FileSystemProvider

/**
 * File and directory layout for multiple Minecraft versions that can share resources.
 * @param fileSystemProvider Provides access to where the instances are stored to and retrieved from.
 * @param rootPath Path in the file system to use as a root.
 */
class SharedInstanceStore(fileSystemProvider: FileSystemProvider, rootPath: Path)
    : InstanceStore(fileSystemProvider, rootPath) {
    /**
     * Adds an asset to the storage.
     * @param asset Information about the asset.
     * @param data Contents of the asset to store in the file.
     */
    override fun addAsset(asset: AssetResource, data: ByteArray) = TODO()

    /**
     * Verifies the contents of an asset are correct.
     * @param asset Information about the asset.
     */
    override fun verifyAsset(asset: AssetResource) = TODO()
}