package MovieOn.db.requests;



import lombok.*;

@Getter
@Builder

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String username;
    private final String email;
    private final String password;

}

