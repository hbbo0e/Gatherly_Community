package gatherly.community.auth.config;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import gatherly.community.auth.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

// TODO 0124, oauth 없이 --> blog 참고
@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {

  private final UserDetailService userService;

  @Bean
  public WebSecurityCustomizer configure(){
    return (web) -> web.ignoring()
        .requestMatchers(toH2Console())
        .requestMatchers("/static/**");
  }

  // ⚠️ disable 리팩토링 필요
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    return http
        .authorizeRequests() // 인증, 인가 설정
        .requestMatchers("/auth/signup", "/auth/login").permitAll()
        .anyRequest().authenticated()
        .and()
        .logout() // 로그아웃 설정
        .logoutSuccessUrl("/login")
        .invalidateHttpSession(true)
        .and()
        .csrf().disable()
        .build();
  }


  // TODO 0124 0900 인증 관리자 관련 설정



  // TODO 0124 0900 passwordencoder 로 사용할 빈 등록

}
