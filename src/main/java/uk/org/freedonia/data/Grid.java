package uk.org.freedonia.data;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grid {

    public List<Cell> gridList = new ArrayList<>();


    public List<Cell> getGridList() {
        return gridList;
    }

    public void setGridList(List<Cell> gridList) {
        this.gridList = gridList;
    }

    public Grid(List<Cell> gridList) {
        this.gridList = gridList;
    }




}
