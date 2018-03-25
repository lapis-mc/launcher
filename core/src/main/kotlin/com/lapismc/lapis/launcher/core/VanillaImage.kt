package com.lapismc.lapis.launcher.core

import com.github.kittinunf.result.Result
import com.github.kittinunf.result.map
import com.lapismc.minecraft.versioning.MetaService

/**
 * References a single image of plain, unmodified Minecraft.
 * @param minecraftVersionId Version ID string of Minecraft.
 */
class VanillaImage(minecraftVersionId: String)
    : Image(minecraftVersionId) {
    /**
     * Indicates whether the image uses mods.
     */
    override val isModded = false

    /**
     * Creates an installer that can install the image to a file system.
     * @param metaService Service used to retrieve files.
     * @return Installer to create the image.
     */
    override fun createInstaller(metaService: MetaService): Result<Installer, Exception> {
        val factory = VanillaBundleFactory(metaService)
        return factory.build(minecraftVersionId).map { VanillaInstaller(metaService, it) }
    }
}