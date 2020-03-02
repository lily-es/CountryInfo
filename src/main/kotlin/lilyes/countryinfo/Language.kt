package lilyes.countryinfo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Language(val name: String,
                    val nativeName: String) {
    override fun toString(): String {
        return "$name($nativeName)"
    }
}