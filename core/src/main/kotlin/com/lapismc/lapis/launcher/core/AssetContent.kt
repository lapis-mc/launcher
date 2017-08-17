package com.lapismc.lapis.launcher.core

/**
 * Asset resource needed for the instance - generally a type of media.
 * @param name Relative path (file name) of the asset.
 * @param size Size of the file in bytes.
 * @param hash SHA-256 digest of the raw content.
 */
class AssetContent(name: String, size: Int, hash: String) : Content(name, size, hash) {
    /**
     * Writes the content to an instance store.
     * @param instanceStore Storage to write the file to.
     */
    override fun apply(instanceStore: InstanceStore) = TODO()

    /**
     * Verifies that the content in the storage for this transferred file is correct.
     * @param instanceStore Storage to check in.
     */
    override fun verify(instanceStore: InstanceStore) = TODO()
}