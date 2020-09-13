package hackathon.banco.safra.easyway.adapters.persistence.entity.customers;

import hackathon.banco.safra.easyway.adapters.persistence.enums.CustomerTypeDataEnum;
import hackathon.banco.safra.easyway.adapters.persistence.enums.InvestmentProfileDataEnum;
import hackathon.banco.safra.easyway.adapters.persistence.enums.converters.InvestmentProfileDataEnumConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "TB02_INVESTMENT_CUSTOMER")
@ToString
@SelectBeforeUpdate(false)
@DynamicUpdate
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class InvestmentCustomerEntity extends CustomerEntity{

    @Column(name = "INCOME", columnDefinition = "decimal(17,2)", nullable = false)
    private BigDecimal income;

    @Column(name = "INVESTING_AMOUNT", columnDefinition = "decimal(17,2)", nullable = false)
    private BigDecimal investingAmount;

    @Column(name = "RESCUE_TIME", columnDefinition = "int", nullable = false)
    private Integer rescueTime;

    @Column(name = "ALLOWED_LOSS_AMOUNT", columnDefinition = "decimal(17,2)", nullable = false)
    private BigDecimal allowedLossAmount;

    @Column(name = "INVESTMENT_PROFILE", columnDefinition = "smallint", nullable = false)
    @Convert(converter = InvestmentProfileDataEnumConverter.class)
    private InvestmentProfileDataEnum investmentProfile;

    public InvestmentCustomerEntity(){
        this.customerType = CustomerTypeDataEnum.INVESTMENT;
    }
}
