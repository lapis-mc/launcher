package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.Asset
import com.lapismc.minecraft.versioning.MetaService

/**
 * Asset resource needed for the instance - generally a type of media.
 * @param name Relative path (file name) of the asset.
 * @param size Size of the file in bytes.
 * @param hash SHA-256 digest of the raw content.
 */
internal class AssetContent(name: String, size: Int, hash: String)
    : Content(name, size, hash) {
    /**
     * Writes the content to an instance store.
     * @param metaService Service to retrieve the file data from.
     * @param store Storage to write the file to.
     */
    override fun apply(metaService: MetaService, store: InstanceStore) {
        val asset = Asset(name, hash, size)
        val data  = metaService.getAssetContent(asset).get() // TODO: Can throw
        store.addAsset(this, data)
    }

    /**
     * Verifies that the content in the storage for this transferred file is correct.
     * @param store Storage to check in.
     */
    override fun verify(store: InstanceStore) {
        store.verifyAsset(this)
    }
}