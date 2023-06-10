package rseditikt.cache.sprite

import rseditikt.cache.EntryType

/**
 * @author Jordan Abraham
 */
data class SpriteEntryType(
    val id: Int,
    var sheetOffsetsX: IntArray? = null,
    var sheetOffsetsY: IntArray? = null,
    var sheetWidths: IntArray? = null,
    var sheetHeights: IntArray? = null,
    var sheetPixels: Array<ByteArray?>? = null,
    var sheetWidth: Int = 0,
    var sheetHeight: Int = 0,
    var palette: IntArray? = null
) : EntryType
