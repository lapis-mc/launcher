package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.MetaService

/**
 * References a single installation of Minecraft.
 * @param minecraftVersionId Version ID string of Minecraft.
 * @param java Java configuration used to launch the game.
 */
abstract class Instance(val minecraftVersionId: String, val java: JavaConfiguration) {
    /**
     * Indicates whether the instance uses mods.
     */
    abstract val isModded: Boolean

    /**
     * Creates an installer that can install the instance to a file system.
     * @param metaService Service used to retrieve files.
     * @return Installer to create the instance.
     */
    abstract fun getInstaller(metaService: MetaService): Installer

    /**
     * Retrieves a set of worlds (save files) in the instance.
     * @param store File storage to inspect for save files.
     * @return Set of saved worlds.
     * @todo To be implemented in a later version.
     */
    fun getSavedWorlds(store: InstanceStore): Unit = TODO("To be implemented in a later version")

    /**
     * Retrieves a set of screenshots in the instance.
     * @param store File storage to inspect for screenshots.
     * @return Set of screenshots.
     * @todo To be implemented in a later version.
     */
    fun getScreenshots(store: InstanceStore): Unit = TODO("To be implemented in a later version")
}