package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegister {
    public Integer id;
    public String email;
    public String password;
    public String token;
    public String error;
}
