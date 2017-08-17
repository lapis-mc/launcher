package com.lapismc.lapis.launcher.core

/**
 * Collection of content that is needed for an instance to run.
 * @param contents List of content in the package.
 */
internal class ContentPackage(private val contents: List<Content>) : Collection<Content> {
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
        fun build() = ContentPackage(contents.toList())

        /**
         * Adds an asset to the package.
         * @param source Location of where to get the content (URL).
         * @param size Size of the file in bytes.
         * @param hash SHA-256 digest of the raw content.
         */
        fun addAsset(source: String, size: Int, hash: String) {
            val asset = AssetContent(source, size, hash)
            contents.add(asset)
        }
    }
}