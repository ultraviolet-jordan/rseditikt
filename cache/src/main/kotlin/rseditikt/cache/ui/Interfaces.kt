package rseditikt.cache.ui

import com.google.inject.Singleton

/**
 * @author Jordan Abraham
 */
@Singleton
class Interfaces : MutableMap<Int, InterfaceEntryType?> by HashMap()
