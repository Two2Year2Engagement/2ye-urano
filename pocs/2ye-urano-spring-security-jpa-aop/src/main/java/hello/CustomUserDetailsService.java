package hello;

import java.util.List;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Qualifier("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepo;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
    	
    	 hello.Users user = userRepository.findByUsername(username);
    	 Authorities role=roleRepo.findByUsername(username);
         List<GrantedAuthority> authorities = buildUserAuthority(role.getAuthority());

         return buildUserForAuthentication(user, authorities);

     }

     private User buildUserForAuthentication(hello.Users user,
                                             List<GrantedAuthority> authorities) {
         return new User(user.getUsername(), user.getPassword(), authorities);
     }
     private List<GrantedAuthority> buildUserAuthority(String userRoles) {

         Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

         // Build user's authorities
         
             setAuths.add(new SimpleGrantedAuthority(userRoles));

         return new ArrayList<GrantedAuthority>(setAuths);
     }

    }
