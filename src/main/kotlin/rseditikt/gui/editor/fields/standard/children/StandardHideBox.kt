package rseditikt.gui.editor.fields.standard.children

import javafx.scene.Node
import javafx.scene.control.ComboBox
import javafx.scene.layout.Priority
import rseditikt.gui.editor.fields.FieldBox

/**
 * @author Jordan Abraham
 */
object StandardHideBox : FieldBox(
    name = "Hide"
) {
    init {
        children.addAll(input())
    }

    override fun input(): Array<Node> = arrayOf(
        ComboBox<String>().also {
            it.items.addAll("false", "true")
            it.selectionModel.select(0)
            it.maxWidth = Double.MAX_VALUE
            setHgrow(it, Priority.ALWAYS)
        }
    )
}
