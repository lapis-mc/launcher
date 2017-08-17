package com.lapismc.lapis.launcher.core

/**
 * Outcome of installing an instance.
 * @param errors List of problems encountered during the installation.
 */
class InstallResult(val errors: List<Exception>) {
    /**
     * Indicates whether the install was successful.
     */
    val success = errors.isEmpty()
}