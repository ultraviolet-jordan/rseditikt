package rseditikt.gui.menubar.file.children

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.control.MenuItem
import rseditikt.cache.CacheStore
import rseditikt.gui.EditorVariables

/**
 * @author Jordan Abraham
 */
@Singleton
class CloseCacheMenuItem @Inject constructor(
    cache: CacheStore,
    editorVariables: EditorVariables
) : MenuItem("Close Cache") {
    init {
        onAction = EventHandler {
            cache.close()
            val alert = Alert(Alert.AlertType.INFORMATION).also {
                it.title = "Success"
                it.headerText = "Cache successfully closed."
                it.contentText = "The directory ${editorVariables.cachePath} is no longer in use by this editor."
            }
            alert.show()
        }
    }
}
