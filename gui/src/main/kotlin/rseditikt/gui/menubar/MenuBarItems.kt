package rseditikt.gui.menubar

import com.google.inject.Inject
import com.google.inject.Singleton
import javafx.scene.control.Menu
import rseditikt.gui.menubar.add.AddMenu
import rseditikt.gui.menubar.controls.ControlsMenu
import rseditikt.gui.menubar.edit.EditMenu
import rseditikt.gui.menubar.file.FileMenu
import rseditikt.gui.menubar.template.TemplateMenu

/**
 * @author Jordan Abraham
 */
@Singleton
class MenuBarItems @Inject constructor(
    fileMenu: FileMenu,
    editMenu: EditMenu,
    addMenu: AddMenu,
    templateMenu: TemplateMenu,
    controlsMenu: ControlsMenu
) : List<Menu> by listOf(
    fileMenu,
    editMenu,
    addMenu,
    templateMenu,
    controlsMenu
)
