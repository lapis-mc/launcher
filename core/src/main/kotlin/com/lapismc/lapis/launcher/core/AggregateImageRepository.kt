package com.lapismc.lapis.launcher.core

import com.github.kittinunf.result.Result

/**
 * Merges images found in multiple repositories into a single output.
 * @param repositories Collection of repositories to search from.
 */
class AggregateImageRepository(private val repositories: Collection<ImageRepository>)
    : ImageRepository {
    /**
     * Retrieves all known images.
     */
    override fun getImages(): Result<ImageCollection, Exception> = TODO()
}