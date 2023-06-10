package rseditikt.gui.editor.fields.standard.children

import com.google.inject.Singleton
import javafx.scene.Node
import rseditikt.gui.editor.fields.FieldBox

/**
 * @author Jordan Abraham
 */
@Singleton
class StandardYBox : FieldBox(
    name = "Y"
) {
    init {
        children.addAll(input())
    }

    override fun input(): Array<Node> = arrayOf(
        createSpinner(0, 999, 0),
        createComboBox("top", "bottom")
    )
}
