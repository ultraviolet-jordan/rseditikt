package rseditikt.gui.menubar.file

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.scene.control.MenuItem
import rseditikt.gui.menubar.file.children.CloseCacheMenuItem
import rseditikt.gui.menubar.file.children.OpenCacheMenuItem
import rseditikt.gui.menubar.file.children.SaveCacheMenuItem

/**
 * @author Jordan Abraham
 */
@Singleton
class FileMenuItems @Inject constructor(
    openCacheMenuItem: OpenCacheMenuItem,
    saveCacheMenuItem: SaveCacheMenuItem,
    closeCacheMenuItem: CloseCacheMenuItem
) : List<MenuItem> by listOf(
    openCacheMenuItem,
    saveCacheMenuItem,
    closeCacheMenuItem
)
