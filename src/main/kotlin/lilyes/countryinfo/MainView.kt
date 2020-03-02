package lilyes.countryinfo

import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.control.TreeView
import javafx.scene.layout.AnchorPane
import tornadofx.*

class MainView : View() {
    private val controller = CountryInfoController()
    override val root: AnchorPane by fxml("/MainView.fxml")
    private val countryName: Label by fxid()
    private val countryList: ListView<String> by fxid()
    private val countryInfo: TreeView<String> by fxid()
    private val statusLabel: Label by fxid()


    init {
        title = "Country Info"
        try {
            countryList.items = controller.getCountryList()
            countryList.onUserSelect {
                countryInfo.root = controller.getInfoByName(it).toTreeItem()
                countryName.text = it
            }
        } catch (e: Exception) {
            statusLabel.text = e.message
        }

    }
}