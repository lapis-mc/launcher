package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.MetaService

/**
 * Base class for all types of game installers.
 * Sub-classes are responsible for details of installing their type of Minecraft.
 * @param metaService Service used to retrieve file content.
 * @param contentPackage Package to install.
 */
class VanillaInstaller(metaService: MetaService, contentPackage: ContentPackage) : Installer(metaService, contentPackage) {
    /**
     * Performs the installation of an instance to a store.
     * @param store Instance storage to install to.
     */
    override fun install(store: InstanceStore) = TODO()

    /**
     * Checks that the package is properly installed to the instance storage.
     * @param store Instance storage to install to.
     */
    override fun verify(store: InstanceStore) = TODO()
}