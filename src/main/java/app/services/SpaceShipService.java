package app.services;

import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpaceShipService {

    private SpaceShipRepo shipRepo;

    @Autowired
    public SpaceShipService(SpaceShipRepo shipRepo) {
        this.shipRepo = shipRepo;
    }

    public List<SpaceShip> getAllSpaceShip() {
        return (List<SpaceShip>) shipRepo.findAll();
    }

    public List<SpaceShip> getByActive() {
        List<SpaceShip> result = new ArrayList<>();
        for (SpaceShip spaceShip : getAllSpaceShip()) {
            if (spaceShip.isActive()) {
                result.add(spaceShip);
            }
        }
        return result;
    }


}
