package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.MetaService

/**
 * Base class for all files that can be stored (downloaded) for an install.
 * This class does not contain the actual data, it contains information about it.
 * @param name Display name of the content.
 * @param size Size of the file in bytes.
 * @param hash SHA-256 digest of the raw content.
 */
internal abstract class Resource(val name: String, val size: Int, val hash: String) {
    /**
     * Writes the content to an instance store.
     * @param metaService Service to retrieve the file data from.
     * @param store Storage to write the file to.
     */
    abstract fun apply(metaService: MetaService, store: InstanceStore)

    /**
     * Verifies that the content in the storage for this transferred file is correct.
     * @param store Storage to check in.
     */
    abstract fun verify(store: InstanceStore)
}