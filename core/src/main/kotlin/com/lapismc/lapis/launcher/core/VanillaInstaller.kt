package com.lapismc.lapis.launcher.core

import com.github.kittinunf.result.Result
import com.lapismc.minecraft.versioning.MetaService

/**
 * Base class for all types of game installers.
 * Sub-classes are responsible for details of installing their type of Minecraft.
 * @param metaService Service used to retrieve file content.
 * @param bundle Package containing the vanilla content.
 */
internal class VanillaInstaller(metaService: MetaService, private val bundle: Bundle)
    : Installer(metaService) {
    /**
     * Performs the installation of an instance to a store.
     * @param store Instance storage to install to.
     * @return Result of the installation.
     *  Upon success, an instance is returned.
     */
    override fun install(store: InstanceStore): Result<InstalledInstance, Exception> {
        val validation = installPackageToStore(bundle, store)
        return if(validation.hasFailure)
            Result.Failure(validation.failures.first())
        else
        {
            // TODO: Get Java and instance information.
            val java = JavaConfiguration(JavaLocator.current(), 0, 0, listOf())
            val instance = VanillaInstance("TODO", java)
            Result.Success(InstalledInstance(instance, store))
        }
    }

    /**
     * Checks that the package is properly installed to the instance storage.
     * @param store Instance storage to install to.
     * @return Result of the verification.
     *  If any problems were found, the result will be a failure.
     */
    override fun verify(store: InstanceStore): Result<InstalledInstance, Exception> = TODO()
}