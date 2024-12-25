package org.example.TrustProjects.configuration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

import java.util.Collection;

public class JwtAccessTokenConverter implements GrantedAuthoritiesMapper {

    @Override
    public Collection<? extends GrantedAuthority> mapAuthorities(Collection< ? extends GrantedAuthority> authorities){
        return authorities;
    }
}
