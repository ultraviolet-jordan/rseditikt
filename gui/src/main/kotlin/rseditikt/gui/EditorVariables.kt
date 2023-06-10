package rseditikt.gui

import com.google.inject.Singleton

/**
 * @author Jordan Abraham
 */
@Singleton
data class EditorVariables(
    var cachePath: String? = "\$not_set\$"
)
