package rseditikt.gui.menubar.file

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.scene.control.Menu

/**
 * @author Jordan Abraham
 */
@Singleton
class FileMenu @Inject constructor(
    fileMenuItems: FileMenuItems
) : Menu("File") {
    init {
        items.addAll(fileMenuItems)
    }
}
