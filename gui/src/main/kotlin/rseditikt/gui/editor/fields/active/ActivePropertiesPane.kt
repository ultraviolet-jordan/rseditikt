package rseditikt.gui.editor.fields.active

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.scene.control.ScrollPane
import javafx.scene.layout.VBox

/**
 * @author Jordan Abraham
 */
@Singleton
class ActivePropertiesPane @Inject constructor(
    activePropertiesPaneItems: ActivePropertiesPaneItems
) : ScrollPane() {
    init {
        content = VBox().also {
            it.spacing = 5.0
            it.children.addAll(activePropertiesPaneItems)
        }
        fitToWidthProperty().set(true)
    }
}
