package skunkworks.simplepathfinder.config

class Grid {
    private val cells: MutableMap<String, Array<String>> = mutableMapOf()

    fun put(key: String, values: Array<String>) = cells.put(key, values)

    fun get(key: String): Array<String>? = cells.get(key)

    fun contains(key: String): Boolean = cells.contains(key)

    override fun toString(): String {
        val sb = StringBuilder()
        cells.forEach { (key: String, values: Array<String>) ->
            val csv = values.joinToString()
            sb.append("$key: $csv\n")
        }
        return sb.toString()
    }
}

