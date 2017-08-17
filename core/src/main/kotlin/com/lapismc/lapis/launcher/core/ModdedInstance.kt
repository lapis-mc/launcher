package com.lapismc.lapis.launcher.core

import com.github.kittinunf.result.Result
import com.lapismc.minecraft.versioning.MetaService

/**
 * References a single installation of modded Minecraft.
 * @param minecraftVersionId Version ID string of Minecraft.
 * @param java Java configuration used to launch the game.
 */
class ModdedInstance(minecraftVersionId: String, java: JavaConfiguration) : Instance(minecraftVersionId, java) {
    /**
     * Indicates whether the instance uses mods.
     */
    override val isModded = true

    /**
     * Creates an installer that can install the instance to a file system.
     * @param metaService Service used to retrieve files.
     * @return Installer to create the instance.
     */
    override fun createInstaller(metaService: MetaService): Result<Installer, Exception> = Result.Success(ModdedInstaller(metaService, generatePackage(metaService)))

    /**
     * Constructs the package for the installer.
     * @param metaService Service used to retrieve files.
     * @return Package to install the instance.
     */
    private fun generatePackage(metaService: MetaService): ContentPackage {
        val builder = ContentPackage.Builder()
        return builder.build()
    }
}