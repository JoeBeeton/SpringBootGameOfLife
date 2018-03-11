package uk.org.freedonia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import uk.org.freedonia.data.Grid;
import uk.org.freedonia.gol.GridGenerator;
import uk.org.freedonia.gol.TickHandler;


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
    @ResponseBody
    public Grid getNextGrid(@RequestParam(name="grid") Grid grid) {
       return tickHandler.tick(grid);
    }

    @RequestMapping("/newGrid")
    @ResponseBody
    public Grid getNewGrid(@RequestParam(name="xLength", required = false, defaultValue = "10") int xLength, @RequestParam(name="yLength", required = false, defaultValue = "10") int yLength) {
        return gridGenerator.generateNewGrid(xLength,yLength);
    }

}
