package uk.org.freedonia.gol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.org.freedonia.data.Cell;
import uk.org.freedonia.data.Grid;
import uk.org.freedonia.data.GridReference;
import uk.org.freedonia.gol.rules.OverpopulationRule;
import uk.org.freedonia.gol.rules.ReproductionRule;
import uk.org.freedonia.gol.rules.UnderpopulationRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;





@Component
public class TickHandler {

    @Autowired
    private GridUtils gridUtils;
    @Autowired
    private UnderpopulationRule underpopulationRule;
    @Autowired
    private OverpopulationRule overpopulationRule;
    @Autowired
    private ReproductionRule reproductionRule;

    public Grid tick(Grid grid) {
        HashMap<GridReference, Cell>  cells = gridUtils.loadGridIntoMap(grid);
        Grid newGrid = new Grid(new ArrayList<>());
        for(Cell cell : grid.getGridList()) {
            List<Cell> adjoiningCells = gridUtils.getAdjoiningCells(cell.getGridReference(), cells);
            Cell newCell = underpopulationRule.transformCell(cell,adjoiningCells);
            newCell = overpopulationRule.transformCell(newCell, adjoiningCells);
            newCell = reproductionRule.transformCell(newCell, adjoiningCells);
            newGrid.getGridList().add(newCell);
        }
        return newGrid;
    }







}
