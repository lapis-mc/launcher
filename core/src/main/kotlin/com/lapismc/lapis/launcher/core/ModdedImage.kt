package com.lapismc.lapis.launcher.core

/**
 * References a single image of modded Minecraft.
 * @param minecraftVersionId Version ID string of Minecraft.
 */
abstract class ModdedImage(minecraftVersionId: String)
    : Image(minecraftVersionId) {
    /**
     * Indicates whether the image uses mods.
     */
    override val isModded = true
}