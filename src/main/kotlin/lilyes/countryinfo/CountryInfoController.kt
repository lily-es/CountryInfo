package lilyes.countryinfo

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import javafx.collections.ObservableList
import kong.unirest.Unirest
import tornadofx.*

class CountryInfoController {

    fun getCountryList(): ObservableList<String> {
        val response = Unirest.get(NAMES_URL)
                .asJson()

        if (response.isSuccess) {
            val names = response.body.array
            val list = mutableListOf<String>()
            for (x in 0 until names.length()) {
                list.add(names.getJSONObject(x).getString("name"))
            }
            return list.asObservable()
        } else {
            throw RequestFailedException("Unable to get country names")
        }
    }

    fun getInfoByName(countryName: String): Country {
        val response = Unirest.get(INFO_URL)
                .routeParam("name", countryName)
                .asJson()

        if (response.isSuccess) {
            return mapper.readValue(response.body.array.getJSONObject(0).toString())
        } else {
            throw RequestFailedException("Unable to get info on country $countryName")
        }
    }

    companion object {
        private val mapper = jacksonObjectMapper()
        const val INFO_URL = "https://restcountries.eu/rest/v2/name/{name}"
        const val NAMES_URL = "https://restcountries.eu/rest/v2/all?fields=name"
    }
}

class RequestFailedException(message: String) : Exception(message)