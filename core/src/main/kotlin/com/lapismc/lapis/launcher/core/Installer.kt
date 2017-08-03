package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.CachedMetaService
import com.lapismc.minecraft.versioning.MetaService
import com.lapismc.minecraft.versioning.WebMetaService

/**
 * Base class for all types of game installers.
 * Sub-classes are responsible for details of installing their type of Minecraft.
 * @param instance Instance to install.
 */
abstract class Installer(protected val instance: Instance) {
    /**
     * Access to official assets, libraries, and other resources.
     */
    protected val metaService: MetaService by lazy {
        CachedMetaService(WebMetaService.official())
    }

    /**
     * Performs the installation of an instance to a store.
     * @param store Instance storage to install to.
     */
    abstract fun install(store: InstanceStore)
}