package rseditikt.cache

import io.netty.buffer.ByteBuf
import org.openrs2.cache.Cache

/**
 * @author Jordan Abraham
 */
interface EntryTypeProvider<T : EntryType, M : MutableMap<Int, T?>> {
    fun cache(cache: Cache)
    fun ByteBuf.read(entry: T): T
    fun write(entry: T): ByteBuf
    fun clear()
}
