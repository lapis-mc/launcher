package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.MetaService

/**
 * Capable of installing a modded version of Minecraft.
 * @param metaService Service used to retrieve file content.
 * @param bundle Package to install.
 */
internal abstract class ModdedInstaller(metaService: MetaService, private val bundle: Bundle)
    : Installer(metaService)