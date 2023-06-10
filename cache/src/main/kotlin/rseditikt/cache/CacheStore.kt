package rseditikt.cache

import org.openrs2.cache.Cache
import java.nio.file.Path

/**
 * @author Jordan Abraham
 */
class CacheStore(
    private val providers: Array<EntryTypeProvider<*, *>>
) {
    private var cache: Cache? = null

    fun open(root: Path) {
        cache = Cache.open(root).also {
            providers.forEach { provider -> provider.cache(it) }
        }
    }

    fun close() {
        cache?.close()
        cache = null
        providers.forEach(EntryTypeProvider<*, *>::clear)
    }
}
