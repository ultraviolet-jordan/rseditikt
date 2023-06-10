package rseditikt.gui.menubar.file.children

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.event.EventHandler
import javafx.scene.control.MenuItem
import rseditikt.cache.CacheStore

/**
 * @author Jordan Abraham
 */
@Singleton
class CloseCacheMenuItem @Inject constructor(
    cache: CacheStore
) : MenuItem("Close Cache") {
    init {
        onAction = EventHandler {
            cache.close()
        }
    }
}
