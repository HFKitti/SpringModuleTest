package app.services;

import app.models.Officer;
import app.repositories.AppuserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OfficerService implements UserDetailsService {

    private AppuserRepo repo;

    public OfficerService(AppuserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        saveDefaultUser();

        return (UserDetails) repo.findByUsername(username);
    }
    public void saveDefaultUser(){
        repo.save(new Officer("user", "user"));
    }
}
