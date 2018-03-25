package com.lapismc.lapis.launcher.core

import com.github.kittinunf.result.Result
import com.lapismc.minecraft.versioning.MetaService

/**
 * References a single installation of Minecraft.
 * @param minecraftVersionId Version ID string of Minecraft.
 */
abstract class Image(val minecraftVersionId: String) {
    /**
     * Indicates whether the image uses mods.
     */
    abstract val isModded: Boolean

    /**
     * Creates an installer that can install the image to a file system.
     * @param metaService Service used to retrieve files.
     * @return Result of the installer creation.
     */
    abstract fun createInstaller(metaService: MetaService): Result<Installer, Exception>
}