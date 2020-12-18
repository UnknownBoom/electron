package com.Electron.Electron.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;

import java.util.Set;

@Data
@Entity
@Table(name="role")
@NoArgsConstructor
public class Role
        implements GrantedAuthority
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    public Role(RoleEnum role) {
        this.role = role;
    }
    public Role(String role) {
        this.role = RoleEnum.valueOf(role);
    }

    private RoleEnum role;

    @Override
    public String getAuthority() {
        return role.name();
    }

    @Transient
    @JsonIgnore
    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
    private Set<User> users;
}
