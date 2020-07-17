package pl.devzyra.spring_security.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class Student {

    private final Integer id;
    private final String studentName;




}
