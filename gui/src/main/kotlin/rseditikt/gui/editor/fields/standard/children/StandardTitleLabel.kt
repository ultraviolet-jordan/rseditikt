package rseditikt.gui.editor.fields.standard.children

import com.google.inject.Singleton
import javafx.geometry.Insets
import javafx.scene.control.Label
import rseditikt.gui.Constants

/**
 * @author Jordan Abraham
 */
@Singleton
class StandardTitleLabel : Label("Standard") {
    init {
        padding = Insets(5.0, 5.0, 5.0, 1.0)
        font = Constants.VerdanaBold12
    }
}
