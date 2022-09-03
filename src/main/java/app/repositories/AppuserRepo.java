package app.repositories;

import app.models.Officer;
import org.springframework.data.repository.CrudRepository;

public interface AppuserRepo extends CrudRepository<Officer, Long> {
    Officer findByUsername(String username);

}
