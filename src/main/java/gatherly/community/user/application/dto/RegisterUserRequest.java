package gatherly.community.user.application.dto;

import java.beans.ConstructorProperties;
import lombok.Getter;

@Getter
public class RegisterUserRequest {

  private String username;
  private String email;
  private String password;
  private String profileImage;

  // fcssB
  @ConstructorProperties({"username", "email", "password", "profileImage"})
  public RegisterUserRequest(String username, String email, String password, String profileImage){
    this.username = username;
    this.email = email;
    this.password = password;
    this.profileImage = profileImage;
  }
}
