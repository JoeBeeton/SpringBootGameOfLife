package uk.org.freedonia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uk.org.freedonia.data.Cell;
import uk.org.freedonia.data.CellState;
import uk.org.freedonia.data.Grid;
import uk.org.freedonia.data.GridReference;
import uk.org.freedonia.gol.GridUtils;

import java.util.HashMap;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = GOLController.class)
public class GOLControllerTest {

    @Autowired
    private GOLController golController;

    @Test
    public void testGridGeneration10by10() {
        Grid grid = golController.getNewGrid(10,10);
        assertNotNull(grid);
        assertEquals(100, grid.gridList.size());
    }

    @Test
    public void testGridWithVeryLargeGrid() {
        Grid grid = golController.getNewGrid(1000,1000);
        assertNotNull(grid);
        assertEquals(1000*1000, grid.gridList.size());
    }

    @Test
    public void testGridWithZeroSizeGrid() {
        Grid grid = golController.getNewGrid(0,0);
        assertNotNull(grid);
        assertEquals(0, grid.gridList.size());
    }

    @Test
    public void testGridWithNegativeSizeGrid() {
        Grid grid = golController.getNewGrid(-5,-5);
        assertNotNull(grid);
        assertEquals(0, grid.gridList.size());
    }

    @Test
    public void testTickWithEmptyGrid() {
        Grid grid = golController.getNewGrid(10,10);
        Grid newGrid = golController.getNextGrid(grid);
        assertEquals(100,newGrid.getGridList().size());
        long emptyCellCount = newGrid.getGridList().stream().filter(cell -> cell.getCellstate().equals(CellState.EMPTY)).count();
        assertEquals(100, emptyCellCount);
    }

    @Test
    public void testTickWithSimplePattern() {
        Grid grid = golController.getNewGrid(10,10);
        HashMap<GridReference, Cell> map = new GridUtils().loadGridIntoMap(grid);
        map.get(new GridReference(1,2)).setCellstate(CellState.LIVE);
        map.get(new GridReference(2,2)).setCellstate(CellState.LIVE);
        map.get(new GridReference(2,3)).setCellstate(CellState.LIVE);
        Grid newGrid = golController.getNextGrid(grid);
        HashMap<GridReference, Cell> newMap = new GridUtils().loadGridIntoMap(newGrid);
        assertEquals(4, newGrid.getGridList().stream().filter(cell -> cell.getCellstate().equals(CellState.LIVE)).count());
        assertEquals(CellState.LIVE,newMap.get(new GridReference(1,2)).getCellstate());
        assertEquals(CellState.LIVE,newMap.get(new GridReference(2,2)).getCellstate());
        assertEquals(CellState.LIVE,newMap.get(new GridReference(2,3)).getCellstate());
        assertEquals(CellState.LIVE,newMap.get(new GridReference(1,3)).getCellstate());
    }











}