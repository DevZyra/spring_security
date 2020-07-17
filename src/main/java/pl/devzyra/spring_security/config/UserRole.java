package pl.devzyra.spring_security.config;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import static pl.devzyra.spring_security.config.UserPermission.*;

@Getter
public enum UserRole {
    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE)),
    STUDENT(Sets.newHashSet());

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }
}
