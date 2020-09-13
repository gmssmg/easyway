package hackathon.banco.safra.easyway.adapters.persistence.entity.customers;

import hackathon.banco.safra.easyway.adapters.persistence.enums.CustomerTypeDataEnum;
import hackathon.banco.safra.easyway.adapters.persistence.enums.converters.CustomerTypeDataEnumConverter;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB01_CUSTOMER")
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
@SelectBeforeUpdate(false)
@DynamicUpdate
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class CustomerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "NAME", columnDefinition = "varchar(100)", nullable = false)
    protected String name;

    @Id
    @Column(name = "CPF", columnDefinition = "varchar(11)", nullable = false)
    protected String cpf;

    @Column(name = "EMAIL", columnDefinition = "varchar(100)", nullable = false)
    protected String email;

    @Column(name = "PHONE_NUMBER", columnDefinition = "bigint", nullable = false)
    protected Long phoneNumber;

    @Column(name = "CUSTOMER_TYPE", columnDefinition = "smallint", nullable = false)
    @Convert(converter = CustomerTypeDataEnumConverter.class)
    @Setter(AccessLevel.NONE)
    protected CustomerTypeDataEnum customerType;

    @Column(name = "SCORE", columnDefinition = "int")
    protected Integer score;

}
