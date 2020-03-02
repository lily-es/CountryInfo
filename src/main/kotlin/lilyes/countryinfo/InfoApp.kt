package lilyes.countryinfo

import javafx.stage.Stage
import tornadofx.*

class InfoApp : App(MainView::class) {
    override fun start(stage: Stage) {
        stage.isResizable = false
        super.start(stage)
    }
}

fun main() {
    launch<InfoApp>()
}