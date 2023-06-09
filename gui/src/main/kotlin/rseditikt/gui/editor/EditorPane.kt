package rseditikt.gui.editor

import com.google.inject.Inject
import com.google.inject.Singleton
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
import rseditikt.gui.Constants
import rseditikt.gui.editor.fields.active.ActivePropertiesPane
import rseditikt.gui.editor.fields.individual.IndividualPropertiesPane
import rseditikt.gui.editor.fields.standard.StandardPane

/**
 * @author Jordan Abraham
 */
@Singleton
class EditorPane @Inject constructor(
    private val standardPane: StandardPane,
    private val individualPropertiesPane: IndividualPropertiesPane,
    private val activePropertiesPane: ActivePropertiesPane
) : SplitPane() {
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
            it.font = Constants.VerdanaBold12
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

    private fun createInterfaceFieldsSplit(): SplitPane = SplitPane(
        standardPane,
        individualPropertiesPane,
        activePropertiesPane,
        VBox()
    ).also {
        it.setDividerPositions(0.26, 0.55, 0.70)
    }

    private fun createInterfaceCS2HooksFields(): ScrollPane {
        val box = VBox().also {
            it.spacing = 1.0
        }

        arrayOf(
            "onLoad",
            "onMouseOver",
            "onMouseLeave",
            "onTargetLeave",
            "onTargetEnter",
            "onVarTransmit",
            "onInvTransmit",
            "onStatTransmit",
            "onTimer",
            "onOp",
            "onMouseRepeat",
            "onClick",
            "onClickRepeat",
            "onRelease",
            "onHold",
            "onDrag",
            "onDragComplete",
            "onScroll",
            "varTransmitTriggers",
            "invTransmitTriggers",
            "statTransmitTriggers"
        ).associateWith { HBox() }.onEach { entry ->
            val label = Label(entry.key).also {
                it.padding = Insets(5.0, 5.0, 5.0, 1.0)
                it.font = Constants.VerdanaBold12
                HBox.setHgrow(it, Priority.ALWAYS)
            }
            val input = TextField().also {
                HBox.setHgrow(it, Priority.ALWAYS)
            }
            entry.value.children.addAll(label, input)
        }.also { box.children.addAll(it.values) }

        return ScrollPane(box).also {
            it.fitToWidthProperty().set(true)
        }
    }
}
