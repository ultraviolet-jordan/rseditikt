package rseditikt.gui.editor.fields.standard

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.scene.Node
import rseditikt.gui.editor.fields.standard.children.StandardClientCodeBox
import rseditikt.gui.editor.fields.standard.children.StandardHeightBox
import rseditikt.gui.editor.fields.standard.children.StandardHideBox
import rseditikt.gui.editor.fields.standard.children.StandardLayerBox
import rseditikt.gui.editor.fields.standard.children.StandardNameBox
import rseditikt.gui.editor.fields.standard.children.StandardTitleLabel
import rseditikt.gui.editor.fields.standard.children.StandardTypeBox
import rseditikt.gui.editor.fields.standard.children.StandardWidthBox
import rseditikt.gui.editor.fields.standard.children.StandardXBox
import rseditikt.gui.editor.fields.standard.children.StandardYBox

/**
 * @author Jordan Abraham
 */
@Singleton
class StandardPaneItems @Inject constructor(
    standardTitleLabel: StandardTitleLabel,
    standardNameBox: StandardNameBox,
    standardTypeBox: StandardTypeBox,
    standardClientCodeBox: StandardClientCodeBox,
    standardXBox: StandardXBox,
    standardYBox: StandardYBox,
    standardWidthBox: StandardWidthBox,
    standardHeightBox: StandardHeightBox,
    standardHideBox: StandardHideBox,
    standardLayerBox: StandardLayerBox
) : List<Node> by listOf(
    standardTitleLabel,
    standardNameBox,
    standardTypeBox,
    standardClientCodeBox,
    standardXBox,
    standardYBox,
    standardWidthBox,
    standardHeightBox,
    standardHideBox,
    standardLayerBox
)
