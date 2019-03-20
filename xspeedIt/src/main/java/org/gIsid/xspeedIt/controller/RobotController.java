package org.gIsid.xspeedIt.controller;

import org.gIsid.xspeedIt.service.actual.ActualRobotService;
import org.gIsid.xspeedIt.service.optimized.OptimizedRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/robot")
public class RobotController {

    @Autowired
    ActualRobotService actualRobotService;

    @Autowired
    OptimizedRobotService optimizedRobotService;

    @GetMapping("/optimized/{chaineArticle}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String[] resolveWithOptimizedRobot(@PathVariable(name = "chaineArticle") String chaineArticle) {
        return optimizedRobotService.resolveCards(chaineArticle);
    }

    @GetMapping("/actual/{chaineArticle}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String[] resolveWithActualRobot(@PathVariable(name = "chaineArticle") String chaineArticle) {
        return actualRobotService.resolveCards(chaineArticle);
    }
}