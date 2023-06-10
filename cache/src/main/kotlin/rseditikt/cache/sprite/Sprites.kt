package rseditikt.cache.sprite

import com.google.inject.Singleton

/**
 * @author Jordan Abraham
 */
@Singleton
class Sprites : MutableMap<Int, SpriteEntryType?> by HashMap()
