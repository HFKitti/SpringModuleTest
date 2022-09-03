package app.controllers;

import app.models.Officer;
import app.models.SpaceShip;
import app.repositories.AppuserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OfficerController {

    @Autowired
    public OfficerController(AppuserRepo officerRepo) {
        this.officerRepo = officerRepo;
    }

    @Autowired
    private AppuserRepo officerRepo;


    @GetMapping(value = {"/login"})
    public String result(Officer user) {
        officerRepo.save(user);
        return "login";

    }

}
