package rseditikt.cache.sprite

import com.google.inject.Inject
import com.google.inject.Singleton
import io.netty.buffer.ByteBuf
import org.openrs2.cache.Cache
import rseditikt.cache.EntryTypeProvider

/**
 * @author Jordan Abraham
 */
@Singleton
class SpriteEntryTypeProvider @Inject constructor(
    private val sprites: Sprites
) : EntryTypeProvider<SpriteEntryType, Sprites> {
    override fun cache(cache: Cache) {
        cache.list(8)
            .asSequence()
            .map { cache.read(8, it.id, 0).read(SpriteEntryType(it.id)) }
            .associateBy(SpriteEntryType::id)
            .let(sprites::putAll)
    }

    override fun ByteBuf.read(entry: SpriteEntryType): SpriteEntryType {
        readerIndex(capacity() - 2)
        val spriteCount = readUnsignedShort()

        entry.sheetOffsetsX = IntArray(spriteCount)
        entry.sheetOffsetsY = IntArray(spriteCount)
        entry.sheetWidths = IntArray(spriteCount)
        entry.sheetHeights = IntArray(spriteCount)
        entry.sheetPixels = arrayOfNulls<ByteArray?>(spriteCount)

        readerIndex(capacity() - 7 - spriteCount * 8)
        entry.sheetWidth = readUnsignedShort()
        entry.sheetHeight = readUnsignedShort()
        val paletteLength = (readUnsignedByte().toInt() and 0xff) + 1

        repeat(spriteCount) {
            entry.sheetOffsetsX!![it] = readUnsignedShort()
        }
        repeat(spriteCount) {
            entry.sheetOffsetsY!![it] = readUnsignedShort()
        }
        repeat(spriteCount) {
            entry.sheetWidths!![it] = readUnsignedShort()
        }
        repeat(spriteCount) {
            entry.sheetHeights!![it] = readUnsignedShort()
        }

        readerIndex(capacity() - 7 - spriteCount * 8 - (paletteLength - 1) * 3)
        entry.palette = IntArray(paletteLength)

        for (index in 1 until paletteLength) {
            entry.palette!![index] = readUnsignedMedium().let { if (it == 0) 1 else it }
        }

        readerIndex(0)

        repeat(spriteCount) {
            val width = entry.sheetWidths!![it]
            val height = entry.sheetHeights!![it]
            val dimensions = width * height
            val pixels = ByteArray(dimensions)
            entry.sheetPixels!![it] = pixels
            val type = readUnsignedByte().toInt()

            if (type == 0) {
                repeat(dimensions) { px ->
                    pixels[px] = readByte()
                }
            } else if (type == 1) {
                repeat(width) { x ->
                    repeat(height) { y ->
                        pixels[x + y * width] = readByte()
                    }
                }
            }
        }

        release()
        return entry
    }

    override fun write(entry: SpriteEntryType): ByteBuf {
        TODO("Not yet implemented")
    }

    override fun clear() {
        sprites.clear()
    }
}
