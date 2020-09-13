package hackathon.banco.safra.easyway.adapters.persistence.entity.optin;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB05_OPT_IN")
@ToString
@SelectBeforeUpdate(false)
@DynamicUpdate
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptInEntity {

    @Column(name = "NAME", columnDefinition = "varchar(100)", nullable = false)
    private String name;

    @Id
    @Column(name = "EMAIL", columnDefinition = "varchar(100)", nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER", columnDefinition = "varchar(20)", nullable = false)
    private String phoneNumber;

}
