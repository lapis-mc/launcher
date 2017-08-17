package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.MetaService

/**
 * Asset resource needed for the instance - generally a type of media.
 * @param name Relative path (file name) of the asset.
 * @param size Size of the file in bytes.
 * @param hash SHA-256 digest of the raw content.
 */
internal class AssetContent(name: String, size: Int, hash: String) : Content(name, size, hash) {
    /**
     * Writes the content to an instance store.
     * @param metaService Service to retrieve the file data from.
     * @param instanceStore Storage to write the file to.
     */
    override fun apply(metaService: MetaService, instanceStore: InstanceStore) = TODO()

    /**
     * Verifies that the content in the storage for this transferred file is correct.
     * @param instanceStore Storage to check in.
     */
    override fun verify(instanceStore: InstanceStore) = TODO()
}