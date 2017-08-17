package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.MetaService
import com.lapismc.minecraft.versioning.Version

/**
 * Builds packages with content needed to install a vanilla version of Minecraft.
 * @param metaService Service used to retrieve the content.
 */
internal class VanillaContentPackageFactory(private val metaService: MetaService) {
    /**
     * Creates a content package for the specified version.
     * @param versionId Version to generate the package for.
     * @return Package containing the content needed to run the game.
     */
    fun build(versionId: String): ContentPackage {
        val builder  = ContentPackage.Builder()
        val manifest = metaService.getVersionManifest().get() // TODO: Can throw
        val stub     = manifest.get(versionId)!! // TODO: Can throw
        val version  = metaService.getVersion(stub).get() // TODO: Can throw
        addAssets(version, builder)
        return builder.build()
    }

    /**
     * Adds assets needed for the version of the game this instance uses.
     * @param version Minecraft version to get assets for.
     * @param builder Content package builder to add assets to.
     */
    private fun addAssets(version: Version, builder: ContentPackage.Builder) {
        val assetIndex = version.assetIndex
        val assets = metaService.getAssetList(assetIndex).get() // TODO: Can throw
        assets.forEach { builder.addAsset(it.path, it.size, it.hash) }
    }
}