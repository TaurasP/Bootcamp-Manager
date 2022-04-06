package com.bootcamp.bootcampmanager.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private boolean enabled;

    @Column
    private String roles;

    public String userRole() {
        if(roles.equals("ROLE_ADMIN"))
            return new String("admin");
        if(roles.equals("ROLE_STUDENT"))
            return new String("student");
        if(roles.equals("ROLE_LECTURER"))
            return new String("lecturer");
        return "user with no role";
    }
}
