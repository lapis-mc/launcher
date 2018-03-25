package com.lapismc.lapis.launcher.core

class ImageCollection(private val contents: List<Image>)
    : Collection<Image> {
    /**
     * Number of items in the package.
     */
    override val size = contents.size

    /**
     * Checks if the specified image is contained in this collection.
     * @param element Image to look for.
     * @return True if the collection contains the specified image, false otherwise.
     */
    override fun contains(element: Image) = contents.contains(element)

    /**
     * Checks if all images in the specified collection are contained in this collection.
     * @param elements Images to look for.
     * @return True if the collections contains everything from [elements],
     *  or false if at least one is image is missing.
     */
    override fun containsAll(elements: Collection<Image>) = contents.containsAll(elements)

    /**
     * Checks whether the package has any images in it.
     * @return True if the package doesn't have any images in it,
     *  or false if it does have at least one image.
     */
    override fun isEmpty() = contents.isEmpty()

    /**
     * Creates an iterator that can be used to retrieve each image.
     * @return Image iterator.
     */
    override fun iterator(): Iterator<Image> = contents.stream().iterator()

    /**
     * Helps build an image collection.
     */
    internal class Builder {
        private val contents = ArrayList<Image>()

        /**
         * Creates the collection.
         * @return Constructed image collection
         */
        fun build() = ImageCollection(contents.toList())

        /**
         * Adds an image to the collection.
         * @param image Image to add.
         */
        fun addImage(image: Image) {
            contents.add(image)
        }
    }
}