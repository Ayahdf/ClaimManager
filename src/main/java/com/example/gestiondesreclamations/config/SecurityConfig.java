
package com.example.gestiondesreclamations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }



    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers( "/supprimerReclamation/","/listProduits/**","/commentaire","/commentaire/**"
                                ,"/ajouterCommentaire/{idProduit}","/listProduits","/ajouterProduit","/modifierProduit/{id}","/deleteProduit/{id}",
                                "/listeReclamations","/listeReclamation","/ajouterReclamation","/modifierReclamation/{id}","/supprimerReclamation/{id}",
                                "/rolelist","/listeacceuil","acceuil","acceuil/**","/listeapresvente",
                                "/apresvente","/apresvente/**","listservice","/listemaintenance","/maintenance","/maintenance/**",
                                "/reclamation","/rec").authenticated()
                        .requestMatchers("/" ,"/reclamer/**","/commentaires/**", "/login/**","/webjars/**","/user/new" ,"/user","user/**")
                        .permitAll())
                .formLogin(form -> form
                        .defaultSuccessUrl("/reclamation", true)) // Redirige vers /listeReclamations après une connexion réussie
               ;

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//    }
}
