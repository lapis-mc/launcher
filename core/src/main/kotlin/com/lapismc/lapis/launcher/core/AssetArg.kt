package com.lapismc.lapis.launcher.core

import com.lapismc.minecraft.versioning.Asset
import com.lapismc.minecraft.versioning.AssetIndex

/**
 * Wraps argument data for everything needed to represent an asset.
 * @param asset Information about the asset.
 * @param index Index the asset belongs to.
 * @param content Raw data for the asset.
 */
class AssetArg(val asset: Asset, val index: AssetIndex, val content: ByteArray)