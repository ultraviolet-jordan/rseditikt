package rseditikt.gui.editor.fields.standard.children

import com.google.inject.Singleton
import javafx.scene.Node
import rseditikt.gui.editor.fields.FieldBox

/**
 * @author Jordan Abraham
 */
@Singleton
class StandardLayerBox : FieldBox(
    name = "Layer"
) {
    init {
        children.addAll(input())
    }

    override fun input(): Array<Node> = arrayOf(
        createComboBox("topright").also {
            it.disableProperty().set(true)
        }
    )
}
