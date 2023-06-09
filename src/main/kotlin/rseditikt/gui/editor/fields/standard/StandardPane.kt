package rseditikt.gui.editor.fields.standard

import javafx.scene.control.ScrollPane
import javafx.scene.layout.VBox
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
object StandardPane : ScrollPane() {
    init {
        content = VBox().also {
            it.spacing = 5.0
            it.children.addAll(
                StandardTitleLabel,
                StandardNameBox,
                StandardTypeBox,
                StandardClientCodeBox,
                StandardXBox,
                StandardYBox,
                StandardWidthBox,
                StandardHeightBox,
                StandardHideBox,
                StandardLayerBox
            )
        }
        fitToWidthProperty().set(true)
    }
}
