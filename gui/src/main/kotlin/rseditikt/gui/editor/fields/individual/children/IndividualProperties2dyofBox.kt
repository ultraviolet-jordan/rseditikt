package rseditikt.gui.editor.fields.individual.children

import com.google.inject.Singleton
import javafx.scene.Node
import rseditikt.gui.editor.fields.FieldBox

/**
 * @author Jordan Abraham
 */
@Singleton
class IndividualProperties2dyofBox : FieldBox(
    name = "2dyof",
) {
    init {
        children.addAll(input())
    }

    override fun input(): Array<Node> = arrayOf(
        createSpinner(0, 5000, 0)
    )
}
