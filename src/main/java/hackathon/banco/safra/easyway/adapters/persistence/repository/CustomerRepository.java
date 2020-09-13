package hackathon.banco.safra.easyway.adapters.persistence.repository;


import hackathon.banco.safra.easyway.adapters.persistence.entity.customers.CustomerEntity;
import hackathon.banco.safra.easyway.adapters.persistence.enums.CustomerTypeDataEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

    @Query("SELECT c from CustomerEntity c " +
    "WHERE (c.customerType = :pCustomerType OR :pCustomerType is null)" +
    "AND (c.score BETWEEN :pFirstScore AND :pLastScore OR :pFirstScore is null AND :pLastScore is null)")
    List<CustomerEntity> findCustomerByCriteria(@Param("pCustomerType") CustomerTypeDataEnum customerType,
                                            @Param("pFirstScore")Integer firstScore,
                                            @Param("pLastScore") Integer lastScore);
}
