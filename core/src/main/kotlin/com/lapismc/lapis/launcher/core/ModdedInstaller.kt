package com.lapismc.lapis.launcher.core

/**
 * Capable of installing a modded version of Minecraft.
 * @param instance Instance to install.
 */
class ModdedInstaller(instance: Instance) : Installer(instance) {
    /**
     * Performs the installation of an instance to a store.
     * @param store Instance storage to install to.
     */
    override fun install(store: InstanceStore) = TODO()
}