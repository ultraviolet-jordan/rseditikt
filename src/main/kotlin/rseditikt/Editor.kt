package rseditikt

import javafx.application.Application
import javafx.application.Application.launch
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import rseditikt.gui.editor.EditorPane
import rseditikt.gui.menubar.MenuBar

class Editor : Application() {
    override fun start(stage: Stage) {
        val root = BorderPane().also {
            it.top = MenuBar
            it.center = EditorPane
        }

        val scene = Scene(root, 1047.0, 950.0)
        stage.scene = scene
        stage.title = "rseditikt"
        stage.show()
    }
}

fun main() {
    launch(Editor::class.java)
}
