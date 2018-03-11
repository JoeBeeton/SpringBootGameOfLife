package uk.org.freedonia.gol.rules;

import org.junit.jupiter.api.Test;
import uk.org.freedonia.data.Cell;
import uk.org.freedonia.data.CellState;
import uk.org.freedonia.data.Grid;
import uk.org.freedonia.data.GridReference;
import uk.org.freedonia.gol.GridGenerator;
import uk.org.freedonia.gol.GridUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnderpopulationRuleTest {
    @Test
    public void testWithZeroLiveCellNeighbour() {
        UnderpopulationRule rule = new UnderpopulationRule();
        Grid grid = new GridGenerator().generateNewGrid(10,10);
        List<Cell> adjoiningCells = new GridUtils().getAdjoiningCells(new GridReference(2,2), new GridUtils().loadGridIntoMap(grid));
        Cell cell = new Cell(CellState.LIVE, new GridReference(2,2));
        Cell newCell = rule.transformCell(cell, adjoiningCells);
        assertEquals(CellState.DEAD, newCell.getCellstate());
    }

    @Test
    public void testWithOnlyOneLiveCellNeighbour() {
        UnderpopulationRule rule = new UnderpopulationRule();
        Grid grid = new GridGenerator().generateNewGrid(10,10);
        List<Cell> adjoiningCells = new GridUtils().getAdjoiningCells(new GridReference(2,2), new GridUtils().loadGridIntoMap(grid));
        Cell cell = new Cell(CellState.LIVE, new GridReference(2,2));
        adjoiningCells.get(0).setCellstate(CellState.LIVE);
        Cell newCell = rule.transformCell(cell, adjoiningCells);
        assertEquals(CellState.DEAD, newCell.getCellstate());
    }


    @Test
    public void testWithTwoLiveCellNeighbour() {
        UnderpopulationRule rule = new UnderpopulationRule();
        Grid grid = new GridGenerator().generateNewGrid(10,10);
        List<Cell> adjoiningCells = new GridUtils().getAdjoiningCells(new GridReference(2,2), new GridUtils().loadGridIntoMap(grid));
        Cell cell = new Cell(CellState.LIVE, new GridReference(2,2));
        adjoiningCells.get(0).setCellstate(CellState.LIVE);
        adjoiningCells.get(1).setCellstate(CellState.LIVE);
        Cell newCell = rule.transformCell(cell, adjoiningCells);
        assertEquals(CellState.LIVE, newCell.getCellstate());
    }

    @Test
    public void testWithThreeLiveCellNeighbour() {
        UnderpopulationRule rule = new UnderpopulationRule();
        Grid grid = new GridGenerator().generateNewGrid(10,10);
        List<Cell> adjoiningCells = new GridUtils().getAdjoiningCells(new GridReference(2,2), new GridUtils().loadGridIntoMap(grid));
        Cell cell = new Cell(CellState.LIVE, new GridReference(2,2));
        adjoiningCells.get(0).setCellstate(CellState.LIVE);
        adjoiningCells.get(1).setCellstate(CellState.LIVE);
        adjoiningCells.get(2).setCellstate(CellState.LIVE);
        Cell newCell = rule.transformCell(cell, adjoiningCells);
        assertEquals(CellState.LIVE, newCell.getCellstate());
    }

    @Test
    public void testWithFourLiveCellNeighbour() {
        UnderpopulationRule rule = new UnderpopulationRule();
        Grid grid = new GridGenerator().generateNewGrid(10,10);
        List<Cell> adjoiningCells = new GridUtils().getAdjoiningCells(new GridReference(2,2), new GridUtils().loadGridIntoMap(grid));
        Cell cell = new Cell(CellState.LIVE, new GridReference(2,2));
        adjoiningCells.get(0).setCellstate(CellState.LIVE);
        adjoiningCells.get(1).setCellstate(CellState.LIVE);
        adjoiningCells.get(2).setCellstate(CellState.LIVE);
        adjoiningCells.get(3).setCellstate(CellState.LIVE);
        Cell newCell = rule.transformCell(cell, adjoiningCells);
        assertEquals(CellState.LIVE, newCell.getCellstate());
    }

}