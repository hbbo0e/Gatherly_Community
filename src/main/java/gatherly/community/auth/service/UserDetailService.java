package gatherly.community.auth.service;

import gatherly.community.user.application.interfaces.UserRepository;
import gatherly.community.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

//@RequiredArgsConstructor
//@Service
//public class UserDetailService implements UserDetailsService {
//
//  private final UserRepository userRepository;
//
//  @Override
//  public User loadUserByUsername(String email){
//    return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException(email));
//  }
//}