package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.MetaService

/**
 * References a single installation of plain, unmodified Minecraft.
 * @param minecraftVersionId Version ID string of Minecraft.
 * @param java Java configuration used to launch the game.
 */
class VanillaInstance(minecraftVersionId: String, java: JavaConfiguration) : Instance(minecraftVersionId, java) {
    /**
     * Indicates whether the instance uses mods.
     */
    override val isModded = false

    /**
     * Creates an installer that can install the instance to a file system.
     * @param metaService Service used to retrieve files.
     * @return Installer to create the instance.
     */
    override fun getInstaller(metaService: MetaService): Installer {
        val factory = VanillaContentPackageFactory(metaService)
        val contentPackage = factory.build(minecraftVersionId)
        return VanillaInstaller(metaService, contentPackage)
    }
}