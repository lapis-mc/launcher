package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.MetaService

/**
 * Base class for all types of game installers.
 * Sub-classes are responsible for details of installing their type of Minecraft.
 * @param metaService Service used to retrieve file content.
 * @param contentPackage Package to install.
 */
abstract class Installer(protected val metaService: MetaService, protected val contentPackage: ContentPackage) {
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
}