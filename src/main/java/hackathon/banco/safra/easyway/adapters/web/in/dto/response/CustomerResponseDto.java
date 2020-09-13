package hackathon.banco.safra.easyway.adapters.web.in.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
public class CustomerResponseDto {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "name", required = true)
    protected String name;

    @JsonProperty(value = "cpf", required = true)
    protected String cpf;

    @JsonProperty(value = "email", required = true)
    protected String email;

    @JsonProperty(value = "phoneNumber", required = true)
    protected Long phoneNumber;

    @JsonProperty(value = "customerType", required = true)
    protected String customerType;

    @JsonProperty(value = "income")
    private BigDecimal income;

    @JsonProperty(value = "investingAmount")
    private BigDecimal investingAmount;

    @JsonProperty(value = "rescueTime")
    private Integer rescueTime;

    @JsonProperty(value = "allowedLossAmount")
    private BigDecimal allowedLossAmount;

    @JsonProperty(value = "age")
    private Integer age;

    @JsonProperty(value = "segmentType")
    private String segmentType;

    @JsonProperty(value = "businessType")
    private String businessType;

    @JsonProperty(value = "creditAmount")
    private BigDecimal creditAmount;

    public CustomerResponseDto(String cpf){
        this.cpf = cpf;
    }

}
