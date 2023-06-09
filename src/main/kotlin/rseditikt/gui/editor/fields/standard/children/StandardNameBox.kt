package rseditikt.gui.editor.fields.standard.children

import javafx.scene.Node
import javafx.scene.control.TextField
import javafx.scene.layout.Priority
import rseditikt.gui.editor.fields.FieldBox

/**
 * @author Jordan Abraham
 */
object StandardNameBox : FieldBox(
    name = "Name",
) {
    init {
        children.addAll(input())
    }

    override fun input(): Array<Node> = arrayOf(
        TextField().also {
            setHgrow(it, Priority.ALWAYS)
        }
    )
}
