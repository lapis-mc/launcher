package com.lapismc.lapis.launcher.core

import com.github.kittinunf.result.Result
import com.github.kittinunf.result.map
import com.lapismc.minecraft.versioning.MetaService

/**
 * References a single installation of plain, unmodified Minecraft.
 * @param minecraftVersionId Version ID string of Minecraft.
 * @param javaConfiguration Java configuration used to launch the game.
 */
class VanillaInstance(minecraftVersionId: String, javaConfiguration: JavaConfiguration)
    : Instance(minecraftVersionId, javaConfiguration) {
    /**
     * Indicates whether the instance uses mods.
     */
    override val isModded = false

    /**
     * Creates an installer that can install the instance to a file system.
     * @param metaService Service used to retrieve files.
     * @return Installer to create the instance.
     */
    override fun createInstaller(metaService: MetaService): Result<Installer, Exception> {
        val factory = VanillaBundleFactory(metaService)
        return factory.build(minecraftVersionId).map { VanillaInstaller(metaService, it) }
    }
}