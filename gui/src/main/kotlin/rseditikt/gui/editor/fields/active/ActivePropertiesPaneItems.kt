package rseditikt.gui.editor.fields.active

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.scene.Node
import rseditikt.gui.editor.fields.active.children.ActivePropertiesTitleLabel

/**
 * @author Jordan Abraham
 */
@Singleton
class ActivePropertiesPaneItems @Inject constructor(
    activePropertiesTitleLabel: ActivePropertiesTitleLabel
) : List<Node> by listOf(
    activePropertiesTitleLabel
)
