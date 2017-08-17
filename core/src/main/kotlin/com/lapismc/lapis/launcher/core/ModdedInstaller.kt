package com.lapismc.lapis.launcher.core

/**
 * Capable of installing a modded version of Minecraft.
 * @param contentPackage Package to install.
 */
class ModdedInstaller(contentPackage: ContentPackage) : Installer(contentPackage) {
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