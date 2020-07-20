package pl.devzyra.spring_security.auth;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final AppUserDao appUserDao;

    public AppUserDetailsService(@Qualifier("fake") AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserDao.selectAppUserDetailsByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User-> %s  not found" , username)));
    }
}
