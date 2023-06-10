package rseditikt.gui

import com.google.inject.Guice
import dev.misfitlabs.kotlinguice4.getInstance
import javafx.application.Application
import javafx.application.Application.launch
import javafx.scene.Scene
import javafx.stage.Stage
import rseditikt.cache.CacheOSRSModule

/**
 * @author Jordan Abraham
 */
class Editor : Application() {
    override fun start(stage: Stage) {
        val injector = Guice.createInjector(CacheOSRSModule, GUIModule)
        val primaryStage = injector.getInstance<Stage>()
        val primaryScene = injector.getInstance<Scene>()

        primaryStage.apply {
            title = "rseditikt"
            scene = primaryScene
        }
        primaryStage.showAndWait()
    }
}

fun main() {
    launch(Editor::class.java)
}
