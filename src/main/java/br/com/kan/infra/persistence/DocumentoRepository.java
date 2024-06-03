package br.com.kan.infra.persistence;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentoRepository extends JpaRepository<DocumentoEntity, Id> {

    @Query(" DELETE FROM DocumentoEntity b where b.beneficiarioEntity.id = :id  ")
    @Modifying
    void deletardocumentoById(@Param("id") Integer id);
}
