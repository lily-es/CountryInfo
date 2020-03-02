package lilyes.countryinfo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import javafx.scene.control.TreeItem

@JsonIgnoreProperties(ignoreUnknown = true)
data class Country(val name: String,
                   @JsonProperty("topLevelDomain") val webDomains: Array<String>,
                   val callingCodes: Array<String>,
                   val capital: String,
                   val region: String,
                   @JsonProperty("subregion") val subRegion: String,
                   val population: Long,
                   @JsonProperty("latlng") val latitudeLongitude: Array<Float>,
                   val demonym: String,
                   val area: Float,
                   @JsonProperty("borders") val borderingCountries: Array<String>,
                   val nativeName: String,
                   val currencies: Array<Currency>,
                   val languages: Array<Language>,
                   val regionalBlocs: Array<RegionalBloc>) {

    fun toTreeItem(): TreeItem<String> {
        val rootItem = TreeItem<String>()
        when {
            webDomains.size == 1 -> {
                rootItem.children.add(TreeItem("Web Domain: ${webDomains[0]}"))
            }
            webDomains.size > 1 -> {
                val treeItem = TreeItem("Web Domains")
                for (domain in webDomains) {
                    treeItem.children.add(TreeItem(domain))
                }
                rootItem.children.add(treeItem)
            }
        }
        when {
            callingCodes.size == 1 -> {
                rootItem.children.add(TreeItem("Calling Code: +${callingCodes[0]}"))
            }
            callingCodes.size > 1 -> {
                val treeItem = TreeItem("Calling Codes")
                for (callingCode in callingCodes) {
                    treeItem.children.add(TreeItem("+$callingCode"))
                }
                rootItem.children.add(treeItem)
            }
        }
        rootItem.children.add(TreeItem("Capital: $capital"))
        rootItem.children.add(TreeItem("Region: $subRegion, $region"))
        rootItem.children.add(TreeItem("Population: $population"))
        rootItem.children.add(TreeItem("Latitude: ${latitudeLongitude[0]}"))
        rootItem.children.add(TreeItem("Longitude: ${latitudeLongitude[1]}"))
        rootItem.children.add(TreeItem("Demonym: $demonym"))
        rootItem.children.add(TreeItem("Area: $area"))
        //todo: display country name instead of code
        when {
            borderingCountries.size == 1 -> {
                rootItem.children.add(TreeItem("Bordering Country: ${borderingCountries[0]}"))
            }
            borderingCountries.size > 1 -> {
                val treeItem = TreeItem("Bordering Countries")
                for (borderingCountry in borderingCountries) {
                    treeItem.children.add(TreeItem(borderingCountry))
                }
                rootItem.children.add(treeItem)
            }
        }
        rootItem.children.add(TreeItem("Native name: $nativeName"))
        when {
            currencies.size == 1 -> {
                rootItem.children.add(TreeItem("Currency: ${currencies[0]}"))
            }
            currencies.size > 1 -> {
                val treeItem = TreeItem("Currencies")
                for (currency in currencies) {
                    treeItem.children.add(TreeItem(currency.toString()))
                }
                rootItem.children.add(treeItem)
            }
        }
        when {
            languages.size == 1 -> {
                rootItem.children.add(TreeItem("Language: ${languages[0]}"))
            }
            languages.size > 1 -> {
                val treeItem = TreeItem("Languages")
                for (language in languages) {
                    treeItem.children.add(TreeItem(language.toString()))
                }
                rootItem.children.add(treeItem)
            }
        }
        when {
            regionalBlocs.size == 1 -> {
                rootItem.children.add(TreeItem("Regional Bloc: ${regionalBlocs[0]}"))
            }
            regionalBlocs.size > 1 -> {
                val treeItem = TreeItem("Regional Blocks")
                for (regionalBloc in regionalBlocs) {
                    treeItem.children.add(TreeItem(regionalBloc.toString()))
                }
                rootItem.children.add(treeItem)
            }
        }
        return rootItem
    }
}
