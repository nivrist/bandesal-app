/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bandesal.config;



import com.bandesal.entities.MvUsuarios;
import com.bandesal.services.IUsuariosServices;
import com.bandesal.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 *
 * @author irvin_monterroza
 */
public class AuthenticationProviderSec extends Utils implements AuthenticationProvider {

    
   
    
    public AuthenticationProviderSec() {
        super();
    }
    
    @Autowired
    IUsuariosServices usuarioService;

    @Autowired
    SessionRegistry sessionRegistry;

    

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        BCryptPasswordEncoder pass = new BCryptPasswordEncoder(12);
        Authentication authRet = null;        
        try {

            List<GrantedAuthority> roles = new ArrayList<>();
            GrantedAuthority role = null;
            String usuario = auth.getPrincipal().toString().trim();
            MvUsuarios user = usuarioService.getUsuariosValido(usuario);
            String password = auth.getCredentials().toString().trim();
            setCurrentUserInit(usuario);            
            if (usuario.isEmpty() && password.isEmpty()) {

                throw new BadCredentialsException(getMessegesBundles("loginform.messages.errorusernull"));

            } else {

                if (user != null) {

                    if (pass.matches(password, user.getPassword())) {
                         
                            role = new SimpleGrantedAuthority("ROLE_ADMIN");
                            roles.add(role);
                            authRet = new UsernamePasswordAuthenticationToken(usuario, password, roles);

                        } else {
                        throw new BadCredentialsException(getMessegesBundles("loginform.messages.errorlogin"));
                    }

                } else {

                    throw new BadCredentialsException(getMessegesBundles("loginform.messages.errorlogin"));
                }

            }

        } catch (BadCredentialsException e) {

            throw new BadCredentialsException(getMessegesBundles("loginform.messages.errorlogin"));

        }
        return authRet;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
