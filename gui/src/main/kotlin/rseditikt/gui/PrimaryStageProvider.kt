package rseditikt.gui

import com.google.inject.Provider
import com.google.inject.Singleton
import javafx.stage.Stage

/**
 * @author Jordan Abraham
 */
@Singleton
class PrimaryStageProvider : Provider<Stage> {
    override fun get(): Stage = Stage()
}
