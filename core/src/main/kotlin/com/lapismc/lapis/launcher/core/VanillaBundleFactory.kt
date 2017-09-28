package com.lapismc.lapis.launcher.core

import com.github.kittinunf.result.Result
import com.github.kittinunf.result.flatMap
import com.github.kittinunf.result.map
import com.lapismc.minecraft.versioning.MetaService
import com.lapismc.minecraft.versioning.Version
import com.lapismc.minecraft.versioning.VersionManifest
import com.lapismc.minecraft.versioning.VersionStub

/**
 * Builds packages with content needed to install a vanilla version of Minecraft.
 * @param metaService Service used to retrieve the content.
 */
internal class VanillaBundleFactory(private val metaService: MetaService) {
    /**
     * Creates a content package for the specified version.
     * @param versionId Version to generate the package for.
     * @return Package containing the content needed to run the game.
     */
    fun build(versionId: String): Result<Bundle, Exception> {
        val builder = Bundle.Builder()
        return metaService.getVersionManifest()
                .flatMap { manifest -> getVersionStub(manifest, versionId) }
                .flatMap { stub -> metaService.getVersion(stub) }
                .flatMap { version -> addAssets(version, builder) }
                .map     { it.build() }
    }

    /**
     * Wraps retrieving a version stub in a result.
     * @param manifest Version manifest to retrieve the stub from.
     * @param versionId Unique ID of the version to retrieve a stub for.
     * @return Result of the stub retrieval.
     */
    private fun getVersionStub(manifest: VersionManifest, versionId: String): Result<VersionStub, Exception> {
        val stub = manifest.get(versionId)
        return if(stub == null)
            Result.Failure(IllegalArgumentException("Version $versionId does not exist"))
        else
            Result.Success(stub)
    }

    /**
     * Adds assets needed for the version of the game this instance uses.
     * @param version Minecraft version to get assets for.
     * @param builder Content package builder to add assets to.
     * @return Result of the operation, with the same [builder] passed in.
     */
    private fun addAssets(version: Version, builder: Bundle.Builder): Result<Bundle.Builder, Exception> {
        return metaService.getAssetList(version.assetIndex)
                .map {
                    assets ->
                    assets.forEach { builder.addAsset(it) }
                    builder
                }
    }
}