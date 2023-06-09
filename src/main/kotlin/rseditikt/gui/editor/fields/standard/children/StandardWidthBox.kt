package rseditikt.gui.editor.fields.standard.children

import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.ComboBox
import javafx.scene.control.Spinner
import javafx.scene.layout.Priority
import rseditikt.gui.editor.fields.FieldBox

/**
 * @author Jordan Abraham
 */
object StandardWidthBox : FieldBox(
    name = "Width"
) {
    init {
        children.addAll(input())
    }

    override fun input(): Array<Node> {
        val spinner = Spinner<Int>(0, 32, 0).also {
            it.editor.alignment = Pos.CENTER_RIGHT
            it.maxWidth = Double.MAX_VALUE
            setHgrow(it, Priority.ALWAYS)
        }

        val comboBox = ComboBox<String>().also {
            it.items.addAll("abs")
            it.disableProperty().set(true)
            it.selectionModel.select(0)
            it.maxWidth = Double.MAX_VALUE
            setHgrow(it, Priority.ALWAYS)
        }

        return arrayOf(spinner, comboBox)
    }
}
