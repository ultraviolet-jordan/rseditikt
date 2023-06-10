package rseditikt.gui.editor.fields.individual.children

import com.google.inject.Singleton
import javafx.scene.Node
import rseditikt.gui.editor.fields.FieldBox

/**
 * @author Jordan Abraham
 */
@Singleton
class IndividualPropertiesZAngleBox : FieldBox(
    name = "Z angle",
) {
    init {
        children.addAll(input())
    }

    override fun input(): Array<Node> = arrayOf(
        createSpinner(0, 5000, 0).also {
            it.maxWidth = 60.0
        },
        createLabel("deg"),
        createSpinner(0, 1000, 0)
    )
}
