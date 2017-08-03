package com.lapismc.lapis.launcher.core

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
     * @return Installer to create the instance.
     */
    override fun getInstaller(): Installer = TODO()
}