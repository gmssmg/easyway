package hackathon.banco.safra.easyway.adapters.persistence.entity.customers;

import hackathon.banco.safra.easyway.adapters.persistence.enums.CustomerTypeDataEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "TB04_MICROCREDIT_CUSTOMER")
@ToString
@SelectBeforeUpdate(false)
@DynamicUpdate
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class MicroCreditCustomerEntity extends CustomerEntity{

    @Column(name = "CREDIT_AMOUNT", columnDefinition = "decimal(17,2)", nullable = false)
    private BigDecimal creditAmount;

    public MicroCreditCustomerEntity(){
        this.customerType = CustomerTypeDataEnum.MICROCREDIT;
    }

}
