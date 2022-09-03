package app.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Officer {

    @Id
    @GeneratedValue
    private long id;
    private String username;

    private String password;

    private LocalDateTime workStart;

    private LocalDateTime workEnd;

    public Officer() {

    }

    public Officer(long id) {
        this.id = id;
    }

    public Officer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Officer( LocalDateTime workStart, LocalDateTime workEnd) {
        this();
        this.workStart = workStart;
        this.workEnd = workEnd;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public boolean isEnable() {
        return workEnd == null;
    }

    private GrantedAuthority createOneAuthority() {
        return new SimpleGrantedAuthority("ADMIN");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getWorkStart() {
        return workStart;
    }

    public void setWorkStart(LocalDateTime workStart) {
        this.workStart = workStart;
    }

    public LocalDateTime getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(LocalDateTime workEnd) {
        this.workEnd = workEnd;
    }
}
