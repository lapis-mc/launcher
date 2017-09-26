package com.lapismc.lapis.launcher.core

import com.github.kittinunf.result.Result
import com.github.kittinunf.result.Validation
import com.lapismc.minecraft.versioning.MetaService

/**
 * Base class for all types of game installers.
 * Sub-classes are responsible for details of installing their type of Minecraft.
 * @param metaService Service used to retrieve file content.
 */
abstract class Installer internal constructor(protected val metaService: MetaService) {
    /**
     * Performs the installation of an instance to a store.
     * @param store Instance storage to install to.
     * @return Result of the installation.
     *  Upon success, an instance is returned.
     */
    abstract fun install(store: InstanceStore): Result<InstalledInstance, Exception>

    /**
     * Checks that the package is properly installed to the instance storage.
     * @param store Instance storage to install to.
     * @return Result of the verification.
     *  If any problems were found, the result will be a failure.
     */
    abstract fun verify(store: InstanceStore): Result<InstalledInstance, Exception>

    /**
     * Utility method for installing all content in a package to an instance store.
     * @param bundle Package to install.
     * @param store Instance storage to install to.
     * @return Installation results.
     */
    internal fun installPackageToStore(bundle: Bundle, store: InstanceStore): Validation<Exception> {
        val results = bundle.map {
            Result.of {
                it.apply(metaService, store)
                true // Placeholder value to store in Result instance.
            }
        }.toTypedArray()
        return Validation(*results)
    }

    /**
     * Utility method for verifying all content in a package is correct in an instance store.
     * @param bundle Package to verify.
     * @param store Instance storage to verify against.
     * @return Verification results.
     */
    internal fun verifyPackageInStore(bundle: Bundle, store: InstanceStore): Validation<Exception> {
        val results = bundle.map {
            Result.of {
                it.verify(store)
                true // Placeholder value to use for Result instance.
            }
        }.toTypedArray()
        return Validation(*results)
    }
}