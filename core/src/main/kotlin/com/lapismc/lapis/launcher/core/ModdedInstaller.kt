package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.MetaService

/**
 * Capable of installing a modded version of Minecraft.
 * @param metaService Service used to retrieve file content.
 * @param contentPackage Package to install.
 */
internal class ModdedInstaller(metaService: MetaService, private val contentPackage: ContentPackage) : Installer(metaService) {
    /**
     * Performs the installation of an instance to a store.
     * @param store Instance storage to install to.
     */
    override fun install(store: InstanceStore): InstallResult = TODO()

    /**
     * Checks that the package is properly installed to the instance storage.
     * @param store Instance storage to install to.
     */
    override fun verify(store: InstanceStore): InstallResult = TODO()
}