package pl.devzyra.spring_security.config;

import com.google.common.collect.Sets;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static pl.devzyra.spring_security.config.UserPermission.*;

@Getter
public enum UserRole {
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(COURSE_READ,STUDENT_READ)),
    STUDENT(Sets.newHashSet());

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
       Set<SimpleGrantedAuthority> permissions  =  getPermissions().stream()
             .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
             .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
