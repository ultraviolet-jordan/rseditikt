package rseditikt.gui.editor.fields.standard.children

import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.Spinner
import javafx.scene.layout.Priority
import rseditikt.gui.editor.fields.FieldBox

/**
 * @author Jordan Abraham
 */
object StandardClientCodeBox : FieldBox(
    name = "Clientcode",
) {
    init {
        children.addAll(input())
    }

    override fun input(): Array<Node> = arrayOf(
        Spinner<Int>(0, 127, 0).also {
            it.editor.alignment = Pos.CENTER_RIGHT
            it.maxWidth = Double.MAX_VALUE
            setHgrow(it, Priority.ALWAYS)
        }
    )
}
