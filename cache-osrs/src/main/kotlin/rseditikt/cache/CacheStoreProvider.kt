package rseditikt.cache

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import rseditikt.cache.ui.InterfaceEntryTypeProvider

/**
 * @author Jordan Abraham
 */
@Singleton
class CacheStoreProvider @Inject constructor(
    private val interfaceEntryTypeProvider: InterfaceEntryTypeProvider
) : Provider<CacheStore> {
    override fun get(): CacheStore {
        val providers = arrayOf<EntryTypeProvider<*, *>>(
            interfaceEntryTypeProvider
        )
        return CacheStore(providers)
    }
}
