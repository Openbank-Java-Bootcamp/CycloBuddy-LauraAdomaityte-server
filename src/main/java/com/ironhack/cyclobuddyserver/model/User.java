package com.ironhack.cyclobuddyserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private @NotEmpty(
            message = "Provide a name"
    ) String name;
    private @Pattern(
            regexp = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?",
            message = "Provide a valid email address."
    ) String email;
    private @Pattern(
            regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.,:])(?=\\S+$).{7,}",
            message = "Password must have at least 7 characters and contain at least one number, one lowercase, one uppercase letter and one of the following signs: @#$%^&+=.,:"
    ) String password;
    private String city;
    private String bicycleType;
    private Integer averageSpeed;
    private Integer averageKmPerMonth;

    @JsonIgnore
    @OneToMany(
            mappedBy="user"
    )
    private Set<Ride> rides = Collections.emptySet();

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    private Set<Role> roles = Collections.emptySet();



    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


}
