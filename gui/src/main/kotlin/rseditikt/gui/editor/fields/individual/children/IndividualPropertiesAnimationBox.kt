package rseditikt.gui.editor.fields.individual.children

import com.google.inject.Singleton
import javafx.scene.Node
import rseditikt.gui.editor.fields.FieldBox

/**
 * @author Jordan Abraham
 */
@Singleton
class IndividualPropertiesAnimationBox : FieldBox(
    name = "Animation"
) {
    init {
        children.addAll(input())
    }

    override fun input(): Array<Node> = arrayOf(
        createComboBox().also {
            it.disableProperty().set(true)
        }
    )
}
