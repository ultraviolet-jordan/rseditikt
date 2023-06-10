package rseditikt.gui.editor.fields.active.children

import com.google.inject.Singleton
import javafx.geometry.Insets
import javafx.scene.control.Label
import rseditikt.gui.Constants

/**
 * @author Jordan Abraham
 */
@Singleton
class ActivePropertiesTitleLabel : Label("Active properties") {
    init {
        padding = Insets(5.0, 5.0, 5.0, 1.0)
        font = Constants.VerdanaBold12
    }
}
