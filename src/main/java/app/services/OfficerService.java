package app.services;

import app.models.Officer;
import app.repositories.AppuserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class OfficerService implements UserDetailsService {

    private AppuserRepo repo;

    @PersistenceContext
    private EntityManager manager;

    public OfficerService(AppuserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Officer officer = repo.findByUsername(username);
        if (username == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new Officer();
    }

   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        saveDefaultUser();

        return (UserDetails) repo.findByUsername(username);
    }*/

   /* public void saveDefaultUser(){
        repo.save(new Officer("user", "user"));
    }

    public void saveUser (String username, String password) {
        String encodedPw = encoder.encode(password);
    }*/


}
