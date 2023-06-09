package rseditikt.gui.editor.fields

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import rseditikt.Constants

/**
 * @author Jordan Abraham
 */
abstract class FieldBox(
    name: String,
) : HBox() {
    init {
        Label(name).also {
            it.padding = Insets(5.0, 5.0, 5.0, 1.0)
            it.font = Constants.VerdanaNormal12
            setHgrow(it, Priority.ALWAYS)
        }.let(children::add)
    }

    abstract fun input(): Array<Node>
}
