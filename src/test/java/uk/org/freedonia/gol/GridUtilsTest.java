package uk.org.freedonia.gol;

import org.junit.jupiter.api.Test;
import uk.org.freedonia.data.Cell;
import uk.org.freedonia.data.Grid;
import uk.org.freedonia.data.GridReference;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GridUtilsTest {

    @Test
    public void testAdjoiningCells() {
        GridGenerator generator = new GridGenerator();
        Grid grid = generator.generateNewGrid(10,10);
        List<Cell> adjoiningCells = new GridUtils().getAdjoiningCells(new GridReference(1,3), new GridUtils().loadGridIntoMap(grid));
        assertEquals(8, adjoiningCells.size());
        List<GridReference> expectedList = Arrays.asList(
                new GridReference(0,2),
                new GridReference(0,3),
                new GridReference(0,4),
                new GridReference(1,2),
                new GridReference(1,4),
                new GridReference(2,2),
                new GridReference(2,3),
                new GridReference(2,4));
        adjoiningCells.stream().forEach(cell -> assertTrue(expectedList.contains(cell.getGridReference())));
    }



}