package hackathon.banco.safra.easyway.application.domain.customers;

import hackathon.banco.safra.easyway.application.enums.CustomerTypeEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Customer {

    protected String name;
    protected String cpf;
    protected String email;
    protected Long phoneNumber;
    protected CustomerTypeEnum customerType;
    protected Integer score;


}
