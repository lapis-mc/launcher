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
    override fun getInstaller(metaService: MetaService) = VanillaInstaller(metaService, generatePackage(metaService))

    /**
     * Constructs the package for the installer.
     * @param metaService Service used to retrieve files.
     * @return Package to install the instance.
     */
    private fun generatePackage(metaService: MetaService): ContentPackage {
        val builder = ContentPackage.Builder()
        addAssets(builder, metaService)
        return builder.build()
    }

    /**
     * Adds assets needed for the version of the game this instance uses.
     * @param builder Content package builder to add assets to.
     * @param metaService Service used to retrieve information about the assets.
     */
    private fun addAssets(builder: ContentPackage.Builder, metaService: MetaService) {
        val manifest = metaService.getVersionManifest().get() // TODO: Can throw
        val stub = manifest.get(minecraftVersionId)!! // TODO: Can throw
        val version = metaService.getVersion(stub).get() // TODO: Can throw
        val assetIndex = version.assetIndex
        val assets = metaService.getAssetList(assetIndex).get() // TODO: Can throw
        assets.forEach { builder.addAsset(it.path, it.size, it.hash) }
    }
}