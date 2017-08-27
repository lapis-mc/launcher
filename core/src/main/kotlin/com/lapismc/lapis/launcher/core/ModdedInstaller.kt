package com.lapismc.lapis.launcher.core

import com.github.kittinunf.result.Result
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
     * @return Result of the installation.
     *  If the install is successful, then information about it is returned.
     *  If the install failed, then the problems are returned.
     */
    override fun install(store: InstanceStore): Result<InstalledInstance, Exception> = TODO()

    /**
     * Checks that the package is properly installed to the instance storage.
     * @param store Instance storage to install to.
     */
    override fun verify(store: InstanceStore): Result<InstalledInstance, Exception> = TODO()
}