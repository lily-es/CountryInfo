package lilyes.countryinfo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class RegionalBloc(val acronym: String,
                        val name: String) {
    override fun toString(): String {
        return "$acronym - $name"
    }
}