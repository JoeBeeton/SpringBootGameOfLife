package uk.org.freedonia.data;

public class Cell {


    private GridReference gridReference;

    private CellState cellstate;


    public Cell(CellState cellstate, GridReference gridReference) {
        this.cellstate = cellstate;
        this.gridReference = gridReference;
    }

    public CellState getCellstate() {
        return cellstate;
    }

    public void setCellstate(CellState cellstate) {
        this.cellstate = cellstate;
    }
    public GridReference getGridReference() {
        return gridReference;
    }

    public void setGridReference(GridReference gridReference) {
        this.gridReference = gridReference;
    }


}
