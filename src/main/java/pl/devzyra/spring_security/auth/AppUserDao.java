package pl.devzyra.spring_security.auth;

import org.springframework.stereotype.Service;

import java.util.Optional;


public interface AppUserDao {

    Optional<AppUserDetails> selectAppUserDetailsByUsername(String username);

}
