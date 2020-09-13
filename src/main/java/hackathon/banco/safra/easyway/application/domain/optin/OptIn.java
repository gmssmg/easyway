package hackathon.banco.safra.easyway.application.domain.optin;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OptIn {

    private String name;
    private String email;
    private String phoneNumber;

}
