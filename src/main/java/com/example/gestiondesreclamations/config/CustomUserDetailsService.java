package com.example.gestiondesreclamations.config;

import com.example.gestiondesreclamations.dao.entities.Role;
import com.example.gestiondesreclamations.dao.entities.Utilisateur;
import com.example.gestiondesreclamations.dao.repositories.UtilisateurDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final UtilisateurDAO utilisateurDAO;


    private final static String ROLE_PREFIX ="ROLE_";
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("email est :{}" , username);
        Optional<Utilisateur> utilisateur= utilisateurDAO.findByEmail(username);
        utilisateur.orElseThrow(()->new UsernameNotFoundException("Utilisateur non trouve"));
        log.info("utilisateur {}" ,utilisateur.get());

        String motDePasse = utilisateur.get().getMotDePasse();
        log.info("motDePasse {}" ,motDePasse);
        Role r =utilisateur.get().getRole();
        String role = r.getNom();
        log.info("role {}",role);

        role = ROLE_PREFIX+role;
        log.info("role {}",role);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(role));
        log.info("roles {}",roles);
        return new CustomUserDetails(username,motDePasse,roles);
    }
}
