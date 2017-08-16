package com.lapismc.lapis.launcher.core

/**
 * Collection of content that is needed for an instance to run.
 */
class ContentPackage : Collection<Content> {
    /**
     * Number of items in the package.
     */
    override val size: Int = TODO()

    /**
     * Checks if the specified content is contained in this package.
     * @param element Content to look for.
     * @return True if the package contains the specified content, false otherwise.
     */
    override fun contains(element: Content): Boolean = TODO()

    /**
     * Checks if all content in the specified collection are contained in this package.
     * @param elements Content to look for.
     * @return True if the package contains everything from [elements],
     *  or false if at least one is missing.
     */
    override fun containsAll(elements: Collection<Content>): Boolean = TODO()

    /**
     * Checks whether the package has content in it.
     * @return True if the package doesn't have any content in it,
     *  or false if it does have content.
     */
    override fun isEmpty(): Boolean = TODO()

    /**
     * Creates an iterator that can be used to retrieve each piece of content.
     * @return Content iterator.
     */
    override fun iterator(): Iterator<Content> = TODO()

    /**
     * Helps build a content package.
     */
    class Builder {
        /**
         * Creates the package.
         * @return Constructed content package.
         */
        fun build() : ContentPackage = TODO()
    }
}