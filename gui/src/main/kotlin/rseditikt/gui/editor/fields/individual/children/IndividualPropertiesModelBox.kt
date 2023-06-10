package rseditikt.gui.editor.fields.individual.children

import com.google.inject.Singleton
import javafx.scene.Node
import rseditikt.gui.editor.fields.FieldBox

/**
 * @author Jordan Abraham
 */
@Singleton
class IndividualPropertiesModelBox : FieldBox(
    name = "Model",
) {
    init {
        children.addAll(input())
    }

    override fun input(): Array<Node> = arrayOf(
        createTextField()
    )
}
