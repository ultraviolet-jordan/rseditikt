package rseditikt.gui.editor

import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.control.SplitPane
import javafx.scene.control.TextField
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.BorderPane
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import rseditikt.gui.editor.fields.standard.StandardPane

/**
 * @author Jordan Abraham
 */
object EditorPane : SplitPane() {
    init {
        val hpane = HBox().also {
            it.minHeight = 50.0
        }
        arrayOf(
            "Add layer",
            "Add graphic",
            "Add model",
            "Add text",
            "Add rectangle",
            "Add line",
        ).map(::Button).onEach {
            it.font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 12.0)
            it.maxWidth = Double.MAX_VALUE
            it.prefWidth = 200.0
            it.maxHeight = 50.0
            HBox.setHgrow(it, Priority.ALWAYS)
        }.also(hpane.children::addAll)

        val topSection = VBox().also {
            it.background = Background(BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY))
        }

        val middleSection = BorderPane().also {
            it.top = hpane
            it.center = createInterfaceFieldsSplit()
        }

        val bottomSection = createInterfaceCS2HooksFields()

        items.addAll(
            topSection,
            middleSection,
            bottomSection
        )
        orientation = Orientation.VERTICAL
        setDividerPositions(0.426, 0.85)
    }

    private fun createInterfaceFieldsSplit(): SplitPane = SplitPane(StandardPane, VBox(), VBox(), VBox()).also {
        it.setDividerPositions(0.26, 0.55, 0.70)
    }

    private fun createInterfaceCS2HooksFields(): ScrollPane {
        val list = arrayOf(
            "onload",
            "onclick",
            "onhold",
            "onrelease",
            "onmouseover",
            "onmouseleave",
            "onload2",
            "onclick2",
            "onhold2",
            "onrelease2",
            "onmouseover2",
            "onmouseleave2",
        ).associateWith { HBox() }.onEach {
            val onLoadLabel = Label(it.key).also { label ->
                label.padding = Insets(5.0, 5.0, 5.0, 1.0)
                label.font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 12.0)
                HBox.setHgrow(label, Priority.ALWAYS)
            }
            val onLoadTextField = TextField().also { field ->
                HBox.setHgrow(field, Priority.ALWAYS)
            }
            it.value.children.addAll(onLoadLabel, onLoadTextField)
        }

        val box = VBox().also {
            it.spacing = 1.0
            it.children.addAll(list.values)
        }

        return ScrollPane(box).also {
            it.fitToWidthProperty().set(true)
        }
    }
}
