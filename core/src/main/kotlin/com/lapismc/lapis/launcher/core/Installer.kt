package com.lapismc.lapis.launcher.core

/**
 * Base class for all types of game installers.
 * Sub-classes are responsible for details of installing their type of Minecraft.
 * @param contentPackage Package to install.
 */
abstract class Installer(protected val contentPackage: ContentPackage) {
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