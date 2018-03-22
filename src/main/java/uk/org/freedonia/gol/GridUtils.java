package uk.org.freedonia.gol;

import org.springframework.stereotype.Component;
import uk.org.freedonia.data.Cell;
import uk.org.freedonia.data.Grid;
import uk.org.freedonia.data.GridReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class GridUtils {





    public List<Cell> getAdjoiningCells(GridReference gridReference, HashMap<GridReference, Cell> gridMap) {
        int x = gridReference.getX();
        int y = gridReference.getY();
        int xMin = x-1;
        int xMax = x+1;
        int yMin = y-1;
        int yMax = y+1;
        List<Cell> adjoiningCells = new ArrayList<>();
        for(int newX = xMin; newX != xMax+1;newX++) {
            for(int newY = yMin; newY != yMax+1;newY++) {
                GridReference ref = new GridReference(newX, newY);
                if(gridMap.containsKey(ref)&& !gridReference.equals(ref)) {
                    adjoiningCells.add(gridMap.get(ref));
                }
            }
        }
        return adjoiningCells;
    }

    public HashMap<GridReference, Cell> loadGridIntoMap(Grid grid) {
        HashMap<GridReference,Cell> map = new HashMap<>();
        grid.getGridList().forEach(cellRow -> cellRow.stream().forEach(cell -> map.put(cell.getGridReference(), cell)));
        return map;
    }


}
