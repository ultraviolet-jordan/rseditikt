package rseditikt.gui.menubar

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.scene.control.MenuBar

/**
 * @author Jordan Abraham
 */
@Singleton
class MenuBar @Inject constructor(
    menuBarItems: MenuBarItems
) : MenuBar() {
    init {
        menus.addAll(menuBarItems)
    }
}
