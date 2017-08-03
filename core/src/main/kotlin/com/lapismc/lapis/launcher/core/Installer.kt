package com.lapismc.lapis.launcher.core

/**
 * Base class for all types of game installers.
 * Sub-classes are responsible for details of installing their type of Minecraft.
 * @param instance Instance to install.
 */
abstract class Installer(protected val instance: Instance) {
}