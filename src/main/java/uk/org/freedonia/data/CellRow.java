package uk.org.freedonia.data;

import java.util.ArrayList;
import java.util.List;

public class CellRow {
    public CellRow() {
    }

    public List<Cell> getRow() {
        return row;

    }

    public CellRow(List<Cell> row) {
        this.row = row;
    }

    public void setRow(List<Cell> row) {
        this.row = row;
    }

    List<Cell> row = new ArrayList<>();
}
