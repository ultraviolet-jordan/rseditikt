package rseditikt.gui.editor.fields

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.Spinner
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import rseditikt.gui.Constants

/**
 * @author Jordan Abraham
 */
abstract class FieldBox(
    name: String,
) : HBox() {
    init {
        children.add(createLabel(name))
    }

    abstract fun input(): Array<Node>

    protected fun createLabel(name: String) = Label(name).also {
        it.padding = Insets(5.0, 5.0, 5.0, 1.0)
        it.font = Constants.VerdanaNormal12
        setHgrow(it, Priority.ALWAYS)
    }

    protected fun createSpinner(min: Int, max: Int, initial: Int): Spinner<Int> = Spinner<Int>(min, max, initial).also {
        it.editor.alignment = Pos.CENTER_RIGHT
        it.maxWidth = Double.MAX_VALUE
        setHgrow(it, Priority.ALWAYS)
    }

    protected fun createTextField(): TextField = TextField().also {
        setHgrow(it, Priority.ALWAYS)
    }

    protected fun createComboBox(vararg elements: String): ComboBox<String> = ComboBox<String>().also {
        it.items.addAll(elements)
        it.selectionModel.select(0)
        it.maxWidth = Double.MAX_VALUE
        setHgrow(it, Priority.ALWAYS)
    }
}
