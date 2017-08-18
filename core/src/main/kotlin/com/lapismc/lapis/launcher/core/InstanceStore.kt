package com.lapismc.lapis.launcher.core

import java.nio.file.Path
import java.nio.file.spi.FileSystemProvider

/**
 * Access to file and directory layout for Minecraft instances.
 * @param fileSystemProvider Provides access to where the instances are stored to and retrieved from.
 * @param rootPath Path in the file system to use as a root.
 */
abstract class InstanceStore(protected val fileSystemProvider: FileSystemProvider, protected val rootPath: Path) {
    /**
     * Adds an asset to the storage.
     * @param asset Information about the asset.
     * @param data Contents of the asset to store in the file.
     */
    internal abstract fun addAsset(asset: AssetContent, data: ByteArray)

    /**
     * Verifies the contents of an asset are correct.
     * @param asset Information about the asset.
     */
    internal abstract fun verifyAsset(asset: AssetContent)
}