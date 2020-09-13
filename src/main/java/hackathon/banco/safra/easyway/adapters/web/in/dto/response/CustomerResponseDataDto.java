package hackathon.banco.safra.easyway.adapters.web.in.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDataDto {

    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    private CustomerResponseDto customerResponseDto;

}
