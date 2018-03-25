package com.lapismc.lapis.launcher.core

/**
 * Reference to an image that has been installed.
 * @param image Image that is installed.
 * @param store Storage where the instance is installed.
 * @param javaConfiguration Java configuration used to launch the game.
 */
class Instance(val image: Image, val store: InstanceStore, val javaConfiguration: JavaConfiguration) {
    /**
     * Retrieves a set of worlds (save files) in the instance.
     * @return Set of saved worlds.
     * @todo To be implemented in a later version.
     */
    val savedWorlds: Unit = TODO("To be implemented in a later version")

    /**
     * Retrieves a set of screenshots in the instance.
     * @return Set of screenshots.
     * @todo To be implemented in a later version.
     */
    val screenshots: Unit = TODO("To be implemented in a later version")
}