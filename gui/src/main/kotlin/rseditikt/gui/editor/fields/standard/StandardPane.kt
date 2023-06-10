package rseditikt.gui.editor.fields.standard

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.scene.control.ScrollPane
import javafx.scene.layout.VBox

/**
 * @author Jordan Abraham
 */
@Singleton
class StandardPane @Inject constructor(
    standardPaneItems: StandardPaneItems
) : ScrollPane() {
    init {
        content = VBox().also {
            it.spacing = 5.0
            it.children.addAll(standardPaneItems)
        }
        fitToWidthProperty().set(true)
    }
}
