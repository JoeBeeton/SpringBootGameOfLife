package uk.org.freedonia.gol.rules;

import uk.org.freedonia.data.Cell;

import java.util.List;

public interface GOLRule {

    Cell transformCell(Cell cell, List<Cell> adjoiningCells);

}
