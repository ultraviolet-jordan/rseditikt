package rseditikt.gui

import dev.misfitlabs.kotlinguice4.KotlinModule
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * @author Jordan Abraham
 */
object GUIModule : KotlinModule() {
    override fun configure() {
        bind<Stage>().toProvider<PrimaryStageProvider>()
        bind<Scene>().toProvider<PrimarySceneProvider>()
    }
}
