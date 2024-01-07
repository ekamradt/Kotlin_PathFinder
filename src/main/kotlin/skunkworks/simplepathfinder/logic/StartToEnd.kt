package skunkworks.simplepathfinder.logic

import skunkworks.simplepathfinder.config.Grid
import java.util.*

/**
 * Given a Starting and Ending Letter, return the path
 *  traveled in the form of CSVs.
 */
class StartToEnd(val grid: Grid) {

    private val stack: Stack<String> = Stack()
    private val visited: MutableSet<String> = mutableSetOf()

    fun travel(start: String, end: String): String {
        if (grid.contains(start) && grid.contains(end)) {
            travelRecurse(start, end)
        }
        return stack.joinToString(separator = ",")
    }

    private fun travelRecurse(current: String, end: String): Boolean {
        if (visited.contains(current)) {
            // Already checked this one
            return false
        }
        visited.add(current)
        stack.push(current)

        if (current === end) {
            // Found the end, stop Looking.
            return true
        }

        // Check each child
        grid.get(current)?.forEach { value: String ->
            if (travelRecurse(value, end)) {
                return true
            }
        }
        // The input current value is not in the
        //  path of finding the end value, so remove it.
        stack.pop()
        return false
    }
}