package com.lapismc.lapis.launcher.core

/**
 * Capable of installing a vanilla version of Minecraft.
 * @param instance Instance to install.
 */
class VanillaInstaller(instance: Instance) : Installer(instance) {
    /**
     * Performs the installation of an instance to a store.
     * @param store Instance storage to install to.
     */
    override fun install(store: InstanceStore) {
        installAssets(store)
    }
}