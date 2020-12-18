package com.Electron.Electron.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User
        implements UserDetails
{
    @Id
    @GeneratedValue(generator = "id_sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_sequence",sequenceName = "IdSequence",allocationSize = 10)
    private Long id;

    private String username;

    private String password;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
