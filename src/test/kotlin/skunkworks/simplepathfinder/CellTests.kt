package skunkworks.simplepathfinder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import skunkworks.simplepathfinder.config.Grid
import skunkworks.simplepathfinder.logic.StartToEnd

class CellTests {

    private val GRID: Grid = buildGrid()

    @Test
    fun `Test a value not in the Grid`() {
        // Value is not within the Grid
        assertEquals("", buildStartToEnd("Z", "Z"))
    }

    @Test
    fun `Test a value with no children`() {
        // Value has no connecction to the end
        assertEquals("", buildStartToEnd("N", "Y"))
    }

    @Test
    fun `Test a value with no connection to the end value`() {
        // Value has no connecction to the end
        assertEquals("", buildStartToEnd("A", "Y"))
    }

    @Test
    fun `Test valid easy path A to B`() {
        assertEquals("A,B", buildStartToEnd("A", "B"))
    }

    @Test
    fun `Test valid medium path A to M`() {
        assertEquals("A,B,C,H,M", buildStartToEnd("A", "M"))
    }

    @Test
    fun `Test valid longer path`() {
        assertEquals("F,G,L,Q,R,S,X,Y", buildStartToEnd("F", "Y"))
    }

    private fun buildStartToEnd(start: String, end: String): String {
        val travel = StartToEnd(GRID)
        return travel.travel(start, end)
    }

    /*
     * |=====|=====|=====|=====|=====|
     * |  A     B     C  |  D  |  E  |
     * |=====|=====|     |     |=====|
     * |  F     G  |  H     I     J  |
     * |=====|     |     |=====|     |
     * |  K     L  |  M  |  N  |  O  |
     * |=====|     |=====|=====|=====|
     * |  P     Q     R     S     T  |
     * |     |=====|=====|     |=====|
     * |  U  |  V     W  |  X     Y  |
     * |=====|=====|=====|=====|=====|
     */
    fun buildGrid(): Grid {
        val grid: Grid = Grid()
        grid.put("A", arrayOf("B"))
        grid.put("B", arrayOf("A", "C"))
        grid.put("C", arrayOf("B", "H"))
        grid.put("D", arrayOf("I"))
        grid.put("E", arrayOf())
        grid.put("F", arrayOf("G"))
        grid.put("G", arrayOf("F", "L"))
        grid.put("H", arrayOf("C", "I", "M"))
        grid.put("I", arrayOf("H", "D", "J"))
        grid.put("J", arrayOf("I", "O"))
        grid.put("K", arrayOf("L"))
        grid.put("L", arrayOf("K", "G", "Q"))
        grid.put("M", arrayOf("H"))
        grid.put("N", arrayOf())
        grid.put("O", arrayOf("J"))
        grid.put("P", arrayOf("Q", "U"))
        grid.put("Q", arrayOf("P", "L", "R"))
        grid.put("R", arrayOf("Q", "S"))
        grid.put("S", arrayOf("R", "T", "X"))
        grid.put("T", arrayOf("S"))
        grid.put("U", arrayOf("P"))
        grid.put("V", arrayOf("W"))
        grid.put("W", arrayOf("V"))
        grid.put("X", arrayOf("S", "Y"))
        grid.put("Y", arrayOf("X"))
        return grid
    }

}