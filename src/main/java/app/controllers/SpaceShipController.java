package app.controllers;

import app.models.Crew;
import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.repositories.CrewRepo;
import app.repositories.SpaceShipRepo;
import app.services.SpaceShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SpaceShipController {

    @Autowired
    private SpaceShipRepo shipRepo;

    @Autowired
    private CrewRepo crewRepo;

    @Autowired
    private SpaceShipService service;

    @Autowired
    public SpaceShipController(SpaceShipRepo shipRepo) {
        this.shipRepo = shipRepo;
    }

    public SpaceShipController(CrewRepo crewRepo) {
        this.crewRepo = crewRepo;
    }

    public SpaceShipController(SpaceShipService service) {
        this.service = service;
    }


    @GetMapping(value = {"/spaceship"})
    public String saveNewSpaceShip(Model model) {
        model.addAttribute("newShip", new SpaceShip());
        model.addAttribute("shipClasses", SpaceShipClass.values());

        return "spaceship_new";
    }

    @GetMapping(value = {"/allspaceship"})
    public String allSpaceShip(Model model) {
        List<SpaceShip> spaceShips = (List<SpaceShip>) shipRepo.findAll();
        model.addAttribute("spaceShip", spaceShips);

        return "allspaceship";
    }

    @GetMapping(value = {"/result"})
    public String result(Model model) {
        List<SpaceShip> ship = service.getByActive();
        model.addAttribute("ship", ship);
        return "result";

    }

    @GetMapping(value = {"/crew"})
    public String crew(Model model) {
        List<Crew> crews = (List<Crew>) crewRepo.findAll();
        model.addAttribute("crew", crews);
        return "crew";

    }
}
