package com.lapismc.lapis.launcher.core

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
     * @return Installer to create the instance.
     */
    override fun getInstaller() = VanillaInstaller(generatePackage())

    /**
     * Constructs the package for the installer.
     * @return Package to install the instance.
     */
    private fun generatePackage(): ContentPackage {
        val builder = ContentPackage.Builder()
        return builder.build()
    }
}