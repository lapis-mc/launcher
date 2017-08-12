package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.*

/**
 * Base class for all types of game installers.
 * Sub-classes are responsible for details of installing their type of Minecraft.
 * @param instance Instance to install.
 */
abstract class Installer(protected val instance: Instance) {
    /**
     * Access to official assets, libraries, and other resources.
     */
    protected val metaService: MetaService by lazy {
        CachedMetaService(WebMetaService.official())
    }

    /**
     * Access to the version information for the instance.
     */
    protected val version by lazy {
        // TODO: Clean this up.
        val manifest = metaService.getVersionManifest().get() // Can throw.
        val stub     = manifest.get(instance.minecraftVersionId)!! // Can throw.
        metaService.getVersion(stub).get() // Can throw.
    }

    /**
     * Performs the installation of an instance to a store.
     * @param store Instance storage to install to.
     */
    abstract fun install(store: InstanceStore)

    /**
     * Installs the assets needed for the version of the instance.
     * @param store Instance storage to install to.
     * @note This is an optional utility method.
     *  Sub-classes aren't required to call this,
     *  but it's common to perform this step during installation.
     */
    protected fun installAssets(store: InstanceStore) {
        // TODO: Clean this up.
        val assetIndex = version.assetIndex
        val assetList  = metaService.getAssetList(assetIndex).get() // Can throw.
        assetList.forEach {
            val content = metaService.getAssetContent(it).get() // Can throw.
            val arg = AssetArg(it, assetIndex, content)
            store.addAsset(arg)
        }
    }
}