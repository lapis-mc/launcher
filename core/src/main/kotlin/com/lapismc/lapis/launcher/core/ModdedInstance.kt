package com.lapismc.lapis.launcher.core

/**
 * References a single installation of modded Minecraft.
 * @param minecraftVersionId Version ID string of Minecraft.
 * @param javaConfiguration Java configuration used to launch the game.
 */
abstract class ModdedInstance(minecraftVersionId: String, javaConfiguration: JavaConfiguration)
    : Instance(minecraftVersionId, javaConfiguration) {
    /**
     * Indicates whether the instance uses mods.
     */
    override val isModded = true
}