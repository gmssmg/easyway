package hackathon.banco.safra.easyway.adapters.web.in.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.LinkedList;
import java.util.List;


@Getter
@Setter
@ToString(exclude = {"customers"})
@NoArgsConstructor
public class CustomerResponseListDto {

    @JsonProperty("data")
    private final List<CustomerResponseDto> customers = new LinkedList<>();

}
