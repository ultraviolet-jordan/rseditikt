package rseditikt.gui.menubar.file.children

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.control.Label
import javafx.scene.control.MenuItem
import javafx.scene.control.TextArea
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority
import javafx.stage.DirectoryChooser
import javafx.stage.Stage
import rseditikt.cache.CacheStore
import java.nio.file.Path

/**
 * @author Jordan Abraham
 */
@Singleton
class OpenCacheMenuItem @Inject constructor(
    stage: Stage,
    cache: CacheStore
) : MenuItem("Open Cache") {
    init {
        onAction = EventHandler {
            val path = DirectoryChooser().showDialog(stage).toPath()
            try {
                cache.open(path)
            } catch (exception: Exception) {
                handleOpenCacheException(path, exception)
            }
        }
    }

    private fun handleOpenCacheException(path: Path, exception: Exception) {
        val alert = Alert(Alert.AlertType.ERROR).also {
            it.title = "Error"
            it.headerText = "There was a problem when attempting to open the cache."
            it.contentText = "The chosen directory was: $path"
        }

        val label = Label("The exception stacktrace was:")

        val textArea = TextArea(exception.stackTraceToString()).also {
            it.editableProperty().set(false)
            it.wrapTextProperty().set(true)
            it.maxHeight = Double.MAX_VALUE
            it.maxHeight = Double.MAX_VALUE
            GridPane.setVgrow(it, Priority.ALWAYS)
            GridPane.setHgrow(it, Priority.ALWAYS)
        }

        val pane = GridPane().also {
            it.maxWidth = Double.MAX_VALUE
            it.add(label, 0, 0)
            it.add(textArea, 0, 1)
        }

        alert.dialogPane.expandableContent = pane
        alert.show()
    }
}
