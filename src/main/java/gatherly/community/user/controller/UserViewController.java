package gatherly.community.user.controller;

import gatherly.community.user.application.UserService;
import gatherly.community.user.application.dto.RegisterUserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class UserViewController {

  private final UserService userService;

  public UserViewController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/auth/signup")
  public String signup(RegisterUserRequest request) {
    userService.registerUser(request);
    return "signup";
  }
}
