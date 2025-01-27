package gatherly.community.auth.config;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import gatherly.community.auth.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// TODO 0124, oauth 없이 --> blog 참고
@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {

  private final UserDetailService userService;

  @Bean
  public WebSecurityCustomizer configure(){
    return (web) -> web.ignoring()
//        .requestMatchers(toH2Console())
        .requestMatchers("/static/**");
  }

  // ⚠️ disable 리팩토링 필요
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    return http
        .authorizeRequests() // 인증, 인가 설정
        .requestMatchers("/auth/signup", "/auth/login", "/view/auth/signup").permitAll()
        .anyRequest().authenticated()
        .and()
        .logout() // 로그아웃 설정
        .logoutSuccessUrl("/login")
        .invalidateHttpSession(true)
        .and()
        .csrf().disable()
        .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception{
    return http
        .getSharedObject(AuthenticationManagerBuilder.class)
        .userDetailsService(userService) // 사용자 정보 서비스 설정
        .passwordEncoder(bCryptPasswordEncoder)
        .and()
        .build();
  }

  // 패스워드 인코더로 사용할 빈 등록
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder(){
    return new BCryptPasswordEncoder();
  }

}
