package rseditikt.gui.editor.fields.individual

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.scene.Node
import rseditikt.gui.editor.fields.individual.children.IndividualProperties2dxofBox
import rseditikt.gui.editor.fields.individual.children.IndividualProperties2dyofBox
import rseditikt.gui.editor.fields.individual.children.IndividualPropertiesAnimationBox
import rseditikt.gui.editor.fields.individual.children.IndividualPropertiesModelBox
import rseditikt.gui.editor.fields.individual.children.IndividualPropertiesModelZoomBox
import rseditikt.gui.editor.fields.individual.children.IndividualPropertiesOrthogonalBox
import rseditikt.gui.editor.fields.individual.children.IndividualPropertiesTitleLabel
import rseditikt.gui.editor.fields.individual.children.IndividualPropertiesXAngleBox
import rseditikt.gui.editor.fields.individual.children.IndividualPropertiesYAngleBox
import rseditikt.gui.editor.fields.individual.children.IndividualPropertiesZAngleBox

/**
 * @author Jordan Abraham
 */
@Singleton
class IndividualPropertiesPaneItems @Inject constructor(
    individualPropertiesTitleLabel: IndividualPropertiesTitleLabel,
    individualPropertiesModelBox: IndividualPropertiesModelBox,
    individualPropertiesModelZoomBox: IndividualPropertiesModelZoomBox,
    individualProperties2dxofBox: IndividualProperties2dxofBox,
    individualProperties2dyofBox: IndividualProperties2dyofBox,
    individualPropertiesXAngleBox: IndividualPropertiesXAngleBox,
    individualPropertiesYAngleBox: IndividualPropertiesYAngleBox,
    individualPropertiesZAngleBox: IndividualPropertiesZAngleBox,
    individualPropertiesAnimationBox: IndividualPropertiesAnimationBox,
    individualPropertiesOrthogonalBox: IndividualPropertiesOrthogonalBox
) : List<Node> by listOf(
    individualPropertiesTitleLabel,
    individualPropertiesModelBox,
    individualPropertiesModelZoomBox,
    individualProperties2dxofBox,
    individualProperties2dyofBox,
    individualPropertiesXAngleBox,
    individualPropertiesYAngleBox,
    individualPropertiesZAngleBox,
    individualPropertiesAnimationBox,
    individualPropertiesOrthogonalBox
)
