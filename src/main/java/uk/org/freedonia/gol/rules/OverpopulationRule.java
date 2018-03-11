package uk.org.freedonia.gol.rules;

import org.springframework.stereotype.Component;
import uk.org.freedonia.data.Cell;
import uk.org.freedonia.data.CellState;
import uk.org.freedonia.data.GridReference;

import java.util.List;
@Component
public class OverpopulationRule implements GOLRule {
    @Override
    public Cell transformCell(Cell cell, List<Cell> adjoiningCells) {
        GridReference gridReference = cell.getGridReference();
        Cell newCell = new Cell(cell.getCellstate(), gridReference);
        if(cell.getCellstate().equals(CellState.LIVE)) {
            long count = adjoiningCells.stream().filter(cl -> cl.getCellstate().equals(CellState.LIVE)).count();
            if (count >= 4) {
                newCell.setCellstate(CellState.DEAD);
            }
        }
        return newCell;
    }
}
