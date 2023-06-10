package rseditikt.gui.editor.fields.individual.children

import com.google.inject.Singleton
import javafx.scene.Node
import rseditikt.gui.editor.fields.FieldBox

/**
 * @author Jordan Abraham
 */
@Singleton
class IndividualPropertiesModelZoomBox : FieldBox(
    name = "Model zoom",
) {
    init {
        children.addAll(input())
    }

    override fun input(): Array<Node> = arrayOf(
        createSpinner(0, 5000, 0)
    )
}
