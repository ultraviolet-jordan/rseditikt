package rseditikt.cache.ui

import com.google.inject.Inject
import com.google.inject.Singleton
import io.netty.buffer.ByteBuf
import org.openrs2.cache.Cache
import rseditikt.cache.EntryTypeProvider

/**
 * @author Jordan Abraham
 */
@Singleton
class InterfaceEntryTypeProvider @Inject constructor(
    private val interfaces: Interfaces
) : EntryTypeProvider<InterfaceEntryType, Interfaces> {
    override fun cache(cache: Cache) {
        cache.list(3).asSequence().flatMap { group ->
            cache.list(3, group.id).asSequence().map { file ->
                read(cache.read(3, group.id, file.id), InterfaceEntryType(group.id shl 16 or file.id))
            }
        }.associateBy(InterfaceEntryType::id).let(interfaces::putAll)
    }

    override fun read(buffer: ByteBuf, entry: InterfaceEntryType): InterfaceEntryType {
        return entry
    }

    override fun write(entry: InterfaceEntryType): ByteBuf {
        TODO("Not yet implemented")
    }

    override fun clear() {
        interfaces.clear()
    }
}
