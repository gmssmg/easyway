package hackathon.banco.safra.easyway.adapters.persistence.entity.customers;

import hackathon.banco.safra.easyway.adapters.persistence.enums.CustomerTypeDataEnum;
import hackathon.banco.safra.easyway.adapters.persistence.enums.SegmentTypeDataEnum;
import hackathon.banco.safra.easyway.adapters.persistence.enums.converters.SegmentTypeDataEnumConverter;
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

@Entity
@Table(name = "TB03_LOAN_CUSTOMER")
@ToString
@SelectBeforeUpdate(false)
@DynamicUpdate
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class LoanCustomerEntity extends CustomerEntity{

    @Column(name = "AGE", columnDefinition = "int", nullable = false)
    private Integer age;

    @Column(name = "SEGMENT_TYPE", columnDefinition = "smallint", nullable = false)
    @Convert(converter = SegmentTypeDataEnumConverter.class)
    private SegmentTypeDataEnum segmentType;

    @Column(name = "BUSINESS_TYPE", columnDefinition = "varchar(80)", nullable = false)
    private String businessType;

    public LoanCustomerEntity(){
        this.customerType = CustomerTypeDataEnum.LOAN;
    }

}
