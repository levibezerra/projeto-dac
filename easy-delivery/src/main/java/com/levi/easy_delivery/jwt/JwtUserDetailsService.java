package com.levi.easy_delivery.jwt;

import com.levi.easy_delivery.entity.Usuario;
import com.levi.easy_delivery.enums.Role;
import com.levi.easy_delivery.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscaPorUsername(email);
        return new JwtUserDetails(usuario);
    }

    public JwtToken getTokenAuthenticated(String email) {
        Role role = usuarioService.buscarRolePorUsername(email);
        return JwtUtils.creatToken(email, role.name().substring("ROLE_".length()));
    }
}