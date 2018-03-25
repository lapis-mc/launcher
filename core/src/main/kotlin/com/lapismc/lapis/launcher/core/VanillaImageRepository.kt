package com.lapismc.lapis.launcher.core

import com.github.kittinunf.result.Result
import com.github.kittinunf.result.map
import com.lapismc.minecraft.versioning.MetaService

/**
 * Provides access to purely vanilla Minecraft versions.
 * @param metaService Service used to retrieve Minecraft versions.
 */
class VanillaImageRepository(private val metaService: MetaService)
    : ImageRepository {
    /**
     * Retrieves all known images.
     */
    override fun getImages(): Result<ImageCollection, Exception> =
        metaService.getVersionManifest().map {
            val builder = ImageCollection.Builder()
            it.forEach {
                val image = VanillaImage(it.id)
                builder.addImage(image)
            }
            builder.build()
        }
}