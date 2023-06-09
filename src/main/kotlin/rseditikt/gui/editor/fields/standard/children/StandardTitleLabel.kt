package rseditikt.gui.editor.fields.standard.children

import javafx.geometry.Insets
import javafx.scene.control.Label
import rseditikt.Constants

/**
 * @author Jordan Abraham
 */
object StandardTitleLabel : Label("Standard") {
    init {
        padding = Insets(5.0, 5.0, 5.0, 1.0)
        font = Constants.VerdanaBold15
    }
}
