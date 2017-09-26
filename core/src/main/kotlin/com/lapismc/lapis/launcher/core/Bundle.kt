package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.Asset

/**
 * Collection of content that is needed for an instance to run.
 * @param contents List of content in the package.
 */
internal class Bundle(private val contents: List<Content>) : Collection<Content> {
    /**
     * Number of items in the package.
     */
    override val size = contents.size

    /**
     * Checks if the specified content is contained in this package.
     * @param element Content to look for.
     * @return True if the package contains the specified content, false otherwise.
     */
    override fun contains(element: Content) = contents.contains(element)

    /**
     * Checks if all content in the specified collection are contained in this package.
     * @param elements Content to look for.
     * @return True if the package contains everything from [elements],
     *  or false if at least one is missing.
     */
    override fun containsAll(elements: Collection<Content>) = contents.containsAll(elements)

    /**
     * Checks whether the package has content in it.
     * @return True if the package doesn't have any content in it,
     *  or false if it does have content.
     */
    override fun isEmpty() = contents.isEmpty()

    /**
     * Creates an iterator that can be used to retrieve each piece of content.
     * @return Content iterator.
     */
    override fun iterator(): Iterator<Content> = contents.stream().iterator()

    /**
     * Helps build a content package.
     */
    class Builder {
        private val contents = ArrayList<Content>()

        /**
         * Creates the package.
         * @return Constructed content package.
         */
        fun build() = Bundle(contents.toList())

        /**
         * Adds an asset to the package.
         * @param asset Information about the asset to add.
         */
        fun addAsset(asset: Asset) {
            val content = AssetContent(asset.path, asset.size, asset.hash)
            contents.add(content)
        }
    }
}