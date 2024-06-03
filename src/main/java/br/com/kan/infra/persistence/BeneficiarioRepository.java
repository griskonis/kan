package br.com.kan.infra.persistence;

import br.com.kan.domain.entities.beneficiario.Beneficiario;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BeneficiarioRepository extends JpaRepository<BeneficiarioEntity, Id> {

     @Query(" select b from BeneficiarioEntity b where b.id = :id ")
     BeneficiarioEntity beneficiarioById(@Param("id") Long id);


}

