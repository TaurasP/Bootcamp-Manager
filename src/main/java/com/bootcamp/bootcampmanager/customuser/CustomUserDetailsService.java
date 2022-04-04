package com.bootcamp.bootcampmanager.customuser;

import com.bootcamp.bootcampmanager.user.User;
import com.bootcamp.bootcampmanager.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(email);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found email: " + email));

        return user.map(CustomUser::new).get();
    }
}
