package com.lapismc.lapis.launcher.core

import com.github.kittinunf.result.Result

/**
 * Provides access to images that the client can install.
 */
interface ImageRepository {
    /**
     * Retrieves all known images.
     */
    fun getImages(): Result<ImageCollection, Exception>
}