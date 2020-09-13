package hackathon.banco.safra.easyway.application.domain.customers;

import hackathon.banco.safra.easyway.application.enums.CustomerTypeEnum;
import hackathon.banco.safra.easyway.application.enums.InvestmentProfileEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@ToString
public class InvestmentCustomer extends Customer{

    private BigDecimal income;
    private BigDecimal investingAmount;
    private Integer rescueTime;
    private BigDecimal allowedLossAmount;
    private InvestmentProfileEnum investmentProfile;


    public InvestmentCustomer(){
        this.customerType = CustomerTypeEnum.INVESTMENT;
    }



}
