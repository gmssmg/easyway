package hackathon.banco.safra.easyway.adapters.persistence.repository;


import hackathon.banco.safra.easyway.adapters.persistence.entity.optin.OptInEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptInRepository extends JpaRepository<OptInEntity, String> {

}
