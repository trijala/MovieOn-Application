package MovieOn.db.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder

@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    @JsonProperty("username")
    private  String username;
    @JsonProperty("email")
    private  String email;
    @JsonProperty("password")
    private  String password;



    public RegistrationRequest(String username,String email, String password){
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public RegistrationRequest(){

    }
}

