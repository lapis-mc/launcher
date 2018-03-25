package com.lapismc.lapis.launcher.core

import com.github.kittinunf.result.Result
import com.lapismc.minecraft.versioning.MetaService

/**
 * Capable of installing a modded version of Minecraft.
 * @param metaService Service used to retrieve file content.
 * @param bundle Package to install.
 */
internal class ModdedInstaller(metaService: MetaService, private val bundle: Bundle)
    : Installer(metaService) {
    /**
     * Performs the installation of an instance to a store.
     * @param store Instance storage to install to.
     * @return Result of the installation.
     *  Upon success, an instance is returned.
     */
    override fun install(store: InstanceStore): Result<InstalledInstance, Exception> = TODO()

    /**
     * Checks that the package is properly installed to the instance storage.
     * @param store Instance storage to install to.
     * @return Result of the verification.
     *  If any problems were found, the result will be a failure.
     */
    override fun verify(store: InstanceStore): Result<InstalledInstance, Exception> = TODO()
}