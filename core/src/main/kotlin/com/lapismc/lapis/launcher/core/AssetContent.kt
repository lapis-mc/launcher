package com.lapismc.lapis.launcher.core

/**
 * Asset resource needed for the instance - generally a type of media.
 * @param source Location of where to get the content (URL).
 * @param size Size of the file in bytes.
 * @param hash SHA-256 digest of the raw content.
 */
abstract class AssetContent(val source: String, val size: Int, val hash: String) {
    /**
     * Writes the content to an instance store.
     * @param instanceStore Storage to write the file to.
     */
    abstract fun apply(instanceStore: InstanceStore)

    /**
     * Verifies that the content in the storage for this transferred file is correct.
     * @param instanceStore Storage to check in.
     */
    abstract fun verify(instanceStore: InstanceStore)
}