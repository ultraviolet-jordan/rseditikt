package rseditikt.cache.ui

import com.google.inject.Inject
import com.google.inject.Singleton
import io.netty.buffer.ByteBuf
import org.openrs2.cache.Cache
import rseditikt.cache.EntryTypeProvider
import java.nio.charset.Charset

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
                cache.read(3, group.id, file.id).read(InterfaceEntryType(group.id shl 16 or file.id))
            }
        }.associateBy(InterfaceEntryType::id).let(interfaces::putAll)
    }

    override fun ByteBuf.read(entry: InterfaceEntryType): InterfaceEntryType {
        entry.isIf3 = getByte(0).toInt() == -1
        return if (entry.isIf3) readIf3(entry) else readIf1(entry)
    }

    override fun write(entry: InterfaceEntryType): ByteBuf {
        return if (entry.isIf3) writeIf3(entry) else writeIf1(entry)
    }

    override fun clear() {
        interfaces.clear()
    }

    private fun ByteBuf.readIf3(entry: InterfaceEntryType): InterfaceEntryType {
        skipBytes(1)
        entry.type = readUnsignedByte().toInt()
        entry.contentType = readUnsignedShort()
        entry.rawX = readShort().toInt()
        entry.rawY = readShort().toInt()
        entry.rawWidth = readUnsignedShort()
        entry.rawHeight = if (entry.type == 9) readShort().toInt() else readUnsignedShort()
        entry.widthAlignment = readByte().toInt()
        entry.heightAlignment = readByte().toInt()
        entry.xAlignment = readByte().toInt()
        entry.yAlignment = readByte().toInt()
        entry.parentId = readUnsignedShort().let { if (it == 65535) -1 else it + (entry.id and -65536) }
        entry.hidden = readBoolean()
        when (entry.type) {
            0 -> {
                entry.scrollWidth = readUnsignedShort()
                entry.scrollHeight = readUnsignedShort()
                entry.noClickThrough = readBoolean()
            }
            3 -> {
                entry.color = readInt()
                entry.fill = readBoolean()
                entry.transparencyTop = readUnsignedByte().toInt()
            }
            4 -> {
                entry.fontId = readUnsignedShort().let { if (it == 65535) -1 else it }
                entry.text = readStringCp1252NullTerminated()
                entry.textLineHeight = readUnsignedByte().toInt()
                entry.textXAlignment = readUnsignedByte().toInt()
                entry.textYAlignment = readUnsignedByte().toInt()
                entry.textShadowed = readBoolean()
                entry.color = readInt()
            }
            5 -> {
                entry.spriteId2 = readInt()
                entry.spriteAngle = readUnsignedShort()
                entry.spriteTiling = readBoolean()
                entry.transparencyTop = readUnsignedByte().toInt()
                entry.outline = readUnsignedByte().toInt()
                entry.spriteShadow = readInt()
                entry.spriteFlipV = readBoolean()
                entry.spriteFlipH = readBoolean()
            }
            6 -> {
                entry.modelType = 1 // 1 is default but client does this, so I will too.
                entry.modelId = readUnsignedShort().let { if (it == 65535) -1 else it }
                entry.modelOffsetX = readShort().toInt()
                entry.modelOffsetY = readShort().toInt()
                entry.modelAngleX = readUnsignedShort()
                entry.modelAngleY = readUnsignedShort()
                entry.modelAngleZ = readUnsignedShort()
                entry.modelZoom = readUnsignedShort()
                entry.sequenceId = readUnsignedShort().let { if (it == 65535) -1 else it }
                entry.modelOrthog = readBoolean()
                skipBytes(2) // Unknown.
                if (entry.widthAlignment != 0) {
                    entry.modelRotation = readUnsignedShort()
                }
                if (entry.heightAlignment != 0) {
                    skipBytes(2) // Unknown
                }
            }
            9 -> {
                entry.lineWid = readUnsignedByte().toInt()
                entry.color = readInt()
                entry.field2913 = readBoolean()
            }
        }
        entry.flags = readUnsignedMedium()
        entry.dataText = readStringCp1252NullTerminated()
        val actionsLength = readUnsignedByte().toInt()
        if (actionsLength > 0) {
            entry.actions = Array(actionsLength) { readStringCp1252NullTerminated() }
        }
        entry.dragZoneSize = readUnsignedByte().toInt()
        entry.dragThreshold = readUnsignedByte().toInt()
        entry.isScrollBar = readBoolean()
        entry.spellActionName = readStringCp1252NullTerminated()
        entry.onLoad = readClientScript2Hook()
        entry.onMouseOver = readClientScript2Hook()
        entry.onMouseLeave = readClientScript2Hook()
        entry.onTargetLeave = readClientScript2Hook()
        entry.onTargetEnter = readClientScript2Hook()
        entry.onVarTransmit = readClientScript2Hook()
        entry.onInvTransmit = readClientScript2Hook()
        entry.onStatTransmit = readClientScript2Hook()
        entry.onTimer = readClientScript2Hook()
        entry.onOp = readClientScript2Hook()
        entry.onMouseRepeat = readClientScript2Hook()
        entry.onClick = readClientScript2Hook()
        entry.onClickRepeat = readClientScript2Hook()
        entry.onRelease = readClientScript2Hook()
        entry.onHold = readClientScript2Hook()
        entry.onDrag = readClientScript2Hook()
        entry.onDragComplete = readClientScript2Hook()
        entry.onScroll = readClientScript2Hook()
        entry.varTransmitTriggers = readClientScript2HookTriggers()
        entry.invTransmitTriggers = readClientScript2HookTriggers()
        entry.statTransmitTriggers = readClientScript2HookTriggers()
        return entry
    }

    private fun writeIf3(entry: InterfaceEntryType): ByteBuf {
        TODO("Not yet implemented")
    }

    private fun ByteBuf.readIf1(entry: InterfaceEntryType): InterfaceEntryType {
        return entry
    }

    private fun writeIf1(entry: InterfaceEntryType): ByteBuf {
        TODO("Not yet implemented")
    }

    private fun ByteBuf.readStringCp1252NullTerminated(): String {
        return readCharSequence(lengthToTerminator(), Charset.forName("cp1252")).toString().also {
            skipBytes(1)
        }
    }

    private tailrec fun ByteBuf.lengthToTerminator(length: Int = 0): Int {
        if (getByte(readerIndex() + length).toInt() == 0) return length
        return lengthToTerminator(length + 1)
    }

    private fun ByteBuf.readClientScript2Hook(): Array<ClientScript2Hook>? {
        val length = readUnsignedByte().toInt()
        if (length == 0) {
            return null
        }
        return Array(length) {
            val alphaNumeric = readBoolean()
            ClientScript2Hook(
                alphaNumeric = alphaNumeric,
                value = if (alphaNumeric) readStringCp1252NullTerminated() else readInt().toString()
            )
        }
    }

    private fun ByteBuf.readClientScript2HookTriggers(): IntArray? {
        val length = readUnsignedByte().toInt()
        if (length == 0) {
            return null
        }
        return IntArray(length) { readInt() }
    }
}
