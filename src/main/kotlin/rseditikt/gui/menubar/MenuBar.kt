package rseditikt.gui.menubar

import javafx.scene.control.Menu
import javafx.scene.control.MenuBar

/**
 * @author Jordan Abraham
 */
object MenuBar : MenuBar() {
    init {
        menus.addAll(
            Menu("File"),
            Menu("Edit"),
            Menu("Add"),
            Menu("Template"),
            Menu("Controls")
        )
    }
}
