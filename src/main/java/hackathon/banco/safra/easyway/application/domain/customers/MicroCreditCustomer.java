package hackathon.banco.safra.easyway.application.domain.customers;

import hackathon.banco.safra.easyway.application.enums.CustomerTypeEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@ToString
public class MicroCreditCustomer extends Customer{

    private BigDecimal creditAmount;

    public MicroCreditCustomer(){
        this.customerType = CustomerTypeEnum.MICROCREDIT;
    }
}
