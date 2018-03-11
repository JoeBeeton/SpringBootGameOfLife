package uk.org.freedonia.gol;

import org.springframework.stereotype.Component;
import uk.org.freedonia.data.Cell;
import uk.org.freedonia.data.CellState;
import uk.org.freedonia.data.Grid;
import uk.org.freedonia.data.GridReference;

import java.util.ArrayList;
import java.util.List;

@Component
public class GridGenerator {


    public Grid generateNewGrid(int xMax, int yMax) {
        List<Cell> cells = createEmptyCellGrid( xMax,yMax);
        return new Grid(cells);
    }

    private List<Cell> createEmptyCellGrid(int xMax, int yMax) {
        List<Cell> cells = new ArrayList<>();
        for(int x = 0; x < xMax; x++ ) {
            for(int y = 0; y < yMax; y++) {
                cells.add(new Cell(CellState.EMPTY, new GridReference(x,y)));
            }
        }
        return cells;
    }


}
