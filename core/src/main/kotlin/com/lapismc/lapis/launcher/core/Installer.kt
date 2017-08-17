package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.MetaService

/**
 * Base class for all types of game installers.
 * Sub-classes are responsible for details of installing their type of Minecraft.
 * @param metaService Service used to retrieve file content.
 */
abstract class Installer internal constructor(protected val metaService: MetaService) {
    /**
     * Performs the installation of an instance to a store.
     * @param store Instance storage to install to.
     */
    abstract fun install(store: InstanceStore)

    /**
     * Checks that the package is properly installed to the instance storage.
     * @param store Instance storage to install to.
     */
    abstract fun verify(store: InstanceStore)

    /**
     * Utility method for installing all content in a package to an instance store.
     * @param contentPackage Package to install.
     * @param store Instance storage to install to.
     */
    internal fun installPackageToStore(contentPackage: ContentPackage, store: InstanceStore) {
        contentPackage.forEach { it.apply(metaService, store) }
    }

    /**
     * Utility method for verifying all content in a package is correct in an instance store.
     * @param contentPackage Package to verify.
     * @param store Instance storage to verify against.
     */
    internal fun verifyPackageInStore(contentPackage: ContentPackage, store: InstanceStore) {
        contentPackage.forEach { it.verify(store) }
    }
}