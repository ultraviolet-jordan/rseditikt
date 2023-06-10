package rseditikt.gui

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import rseditikt.gui.editor.EditorPane
import rseditikt.gui.menubar.MenuBar

/**
 * @author Jordan Abraham
 */
@Singleton
class PrimarySceneProvider @Inject constructor(
    private val menuBar: MenuBar,
    private val editorPane: EditorPane
) : Provider<Scene> {
    override fun get(): Scene {
        val root = BorderPane().also {
            it.top = menuBar
            it.center = editorPane
        }
        return Scene(root, 1047.0, 950.0)
    }
}
