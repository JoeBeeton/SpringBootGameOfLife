package uk.org.freedonia.data;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grid {

    private List<List<Cell>> gridList = new ArrayList<>();


    public List<List<Cell>> getGridList() {
        return gridList;
    }

    public void setGridList(List<List<Cell>> gridList) {
        this.gridList = gridList;
    }
    @JsonCreator
    public Grid(     @JsonProperty("gridList") List<List<Cell>> gridList) {
        this.gridList = gridList;
    }




}
