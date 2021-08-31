package MovieOn.db.token;

import MovieOn.db.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @SequenceGenerator(
            name = "config_seq",
            sequenceName = "config_seq",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "config_seq"
    )
    private Long id;
    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expiresAt;


    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private Users user;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt,Users user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiredAt;
        this.user = user;
    }


}
