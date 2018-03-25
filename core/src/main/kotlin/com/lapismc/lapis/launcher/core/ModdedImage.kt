package com.lapismc.lapis.launcher.core

/**
 * References a single image of modded Minecraft.
 * @param minecraftVersionId Version ID string of Minecraft.
 * @param javaConfiguration Java configuration used to launch the game.
 */
abstract class ModdedImage(minecraftVersionId: String, javaConfiguration: JavaConfiguration)
    : Image(minecraftVersionId, javaConfiguration) {
    /**
     * Indicates whether the image uses mods.
     */
    override val isModded = true
}