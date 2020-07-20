package pl.devzyra.spring_security.auth;

import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static pl.devzyra.spring_security.config.UserRole.ADMIN;
import static pl.devzyra.spring_security.config.UserRole.STUDENT;

@Repository("fake")
public class AppUserDaoImpl implements AppUserDao {

    private final PasswordEncoder passwordEncoder;

    public AppUserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<AppUserDetails> selectAppUserDetailsByUsername(String username) {
        return getAppUserDetails().stream()
                .filter(user-> username.equals(user.getUsername()))
                .findFirst();
    }


   // helper method imitates retrieving user from DB
    private List<AppUserDetails> getAppUserDetails(){
        List<AppUserDetails> appUsers = Lists.newArrayList(
                new AppUserDetails(
                        ADMIN.getGrantedAuthority(),
                        passwordEncoder.encode("admin"),
                        "admin",
                        true,
                        true,
                        true,
                        true),
                new AppUserDetails(
                        STUDENT.getGrantedAuthority(),
                        passwordEncoder.encode("user"),
                        "user",
                        true,
                        true,
                        true,
                        true)
                );

        return appUsers;
    }

}
