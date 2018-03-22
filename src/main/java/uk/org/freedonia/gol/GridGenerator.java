package uk.org.freedonia.gol;

import org.springframework.stereotype.Component;
import uk.org.freedonia.data.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

@Component
public class GridGenerator {


    public Grid generateNewGrid(int xMax, int yMax) {
        List<Cell> cells = createEmptyCellGrid( xMax,yMax);
        List<List<Cell>> rows = new ArrayList<>();

        List<Cell> cellRow = new ArrayList<>();
        for(Cell cell : cells) {
            if(cellRow.size()==xMax) {
                rows.add( cellRow );
                cellRow = new ArrayList<>();
            }
            cellRow.add(cell);
        }
        if(!cellRow.isEmpty()) {
            rows.add(cellRow);
        }

        return new Grid(rows);
    }

    private int findMaxX(List<Cell> cells) {
        return cells.stream().mapToInt(cell -> cell.getGridReference().getX()).max().getAsInt()+1;
    }

    public Grid createGridFromCells(List<Cell> cells) {
        List<List<Cell>> rows = new ArrayList<>();
        int xMax = findMaxX(cells);
        List<Cell> cellRow = new ArrayList<>();
        for(Cell cell : cells) {
            if(cellRow.size()==xMax) {
                rows.add( cellRow );
                cellRow = new ArrayList<>();
            }
            cellRow.add(cell);
        }
        if(!cellRow.isEmpty()) {
            rows.add(cellRow);
        }
        return new Grid(rows);

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
