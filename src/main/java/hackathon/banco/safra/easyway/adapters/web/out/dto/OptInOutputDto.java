package hackathon.banco.safra.easyway.adapters.web.out.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptInOutputDto {

    @JsonProperty(value = "Name", required = true)
    private String name;

    @JsonProperty(value = "Email", required = true)
    private String email;

    @JsonProperty(value = "Phone", required = true)
    private String phoneNumber;
}
