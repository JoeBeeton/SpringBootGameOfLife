package uk.org.freedonia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import uk.org.freedonia.data.CellState;
import uk.org.freedonia.data.Grid;
import uk.org.freedonia.gol.GridGenerator;
import uk.org.freedonia.gol.TickHandler;

@CrossOrigin
@Controller
@EnableAutoConfiguration
@ComponentScan
public class GOLController {

    @Autowired
    private GridGenerator gridGenerator;

    @Autowired
    private TickHandler tickHandler;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GOLController.class, args);
    }

    @RequestMapping(path = "/tick", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public Grid getNextGrid(@RequestBody Grid test) {
        return tickHandler.tick(test);
    }

    @RequestMapping("/newGrid")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public Grid getNewGrid(@RequestParam(name="xLength", required = false, defaultValue = "40") int xLength, @RequestParam(name="yLength", required = false, defaultValue = "40") int yLength) {
        Grid grid =  gridGenerator.generateNewGrid(xLength,yLength);
        return grid;
    }

}
