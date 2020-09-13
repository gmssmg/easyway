package hackathon.banco.safra.easyway.application.domain.customers;

import hackathon.banco.safra.easyway.application.enums.CustomerTypeEnum;
import hackathon.banco.safra.easyway.application.enums.SegmentTypeEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@ToString
public class LoanCustomer extends Customer{

    private Integer age;
    private SegmentTypeEnum segmentType;
    private String businessType;

    public LoanCustomer(){
        this.customerType = CustomerTypeEnum.LOAN;
    }
}
