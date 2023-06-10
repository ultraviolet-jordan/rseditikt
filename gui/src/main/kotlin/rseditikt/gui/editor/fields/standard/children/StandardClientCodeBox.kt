package rseditikt.gui.editor.fields.standard.children

import com.google.inject.Singleton
import javafx.scene.Node
import rseditikt.gui.editor.fields.FieldBox

/**
 * @author Jordan Abraham
 */
@Singleton
class StandardClientCodeBox : FieldBox(
    name = "Clientcode",
) {
    init {
        children.addAll(input())
    }

    override fun input(): Array<Node> = arrayOf(
        createSpinner(0, 127, 0)
    )
}
