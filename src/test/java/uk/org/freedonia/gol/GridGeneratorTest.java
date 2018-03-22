package uk.org.freedonia.gol;

import org.junit.jupiter.api.Test;
import uk.org.freedonia.data.Grid;

import static org.junit.jupiter.api.Assertions.*;

class GridGeneratorTest {


    @Test
    public void testGridGenerator() {
        GridGenerator gen = new GridGenerator();
        Grid grid = gen.generateNewGrid(10,10);
        assertEquals(10, grid.getGridList().size());
    }

}