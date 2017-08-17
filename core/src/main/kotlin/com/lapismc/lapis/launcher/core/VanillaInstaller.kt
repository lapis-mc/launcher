package com.lapismc.lapis.launcher.core

/**
 * Base class for all types of game installers.
 * Sub-classes are responsible for details of installing their type of Minecraft.
 * @param contentPackage Package to install.
 */
abstract class VanillaInstaller(contentPackage: ContentPackage) : Installer(contentPackage) {
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