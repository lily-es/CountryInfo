package lilyes.countryinfo


data class Currency(val code: String?,
                    val name: String?,
                    val symbol: String?) {
    override fun toString(): String {
        return "$code - $name - $symbol"
    }
}