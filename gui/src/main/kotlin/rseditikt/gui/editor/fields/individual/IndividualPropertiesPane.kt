package rseditikt.gui.editor.fields.individual

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.scene.control.ScrollPane
import javafx.scene.layout.VBox

/**
 * @author Jordan Abraham
 */
@Singleton
class IndividualPropertiesPane @Inject constructor(
    individualPropertiesPaneItems: IndividualPropertiesPaneItems
) : ScrollPane() {
    init {
        content = VBox().also {
            it.spacing = 5.0
            it.children.addAll(individualPropertiesPaneItems)
        }
        fitToWidthProperty().set(true)
    }
}
