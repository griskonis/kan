package br.com.kan.infra.gateways;

import br.com.kan.application.gateways.RepositorioBeneficiario;
import br.com.kan.application.gateways.RepositorioDocumento;
import br.com.kan.domain.entities.beneficiario.Beneficiario;

import br.com.kan.domain.entities.documento.Documento;
import br.com.kan.infra.persistence.BeneficiarioEntity;
import br.com.kan.infra.persistence.BeneficiarioRepository;
import br.com.kan.infra.persistence.DocumentoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioBeneficiarioJpa implements RepositorioBeneficiario {

    private final BeneficiarioRepository repository;
    private final BeneficiarioEntityMapper mapper;


    @Autowired
    private RepositorioDocumento repositorioDocumento;

    public RepositorioBeneficiarioJpa(BeneficiarioRepository repository, BeneficiarioEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Beneficiario cadastrarBeneficiario(Beneficiario beneficiario) {
        BeneficiarioEntity beneficiarioEntity = mapper.toEntity(beneficiario);
        repository.save(beneficiarioEntity);
        repositorioDocumento.cadastrarDocumentos(beneficiario.getListDocumento(), beneficiarioEntity);

        return mapper.toDomain(beneficiarioEntity);
    }

    @Override
    public List<Beneficiario> listarTodos() {
        return this.repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Beneficiario atualizarBeneficiario(Beneficiario beneficiario) {
       BeneficiarioEntity beneficiarioEntity =  mapper.toEntity(beneficiario);
       repository.save(beneficiarioEntity);
        return mapper.toDomain(beneficiarioEntity);

    }

    @Override
    public void deletarBeneficiario(Beneficiario beneficiario) {

        if(beneficiario != null){
            BeneficiarioEntity beneficiarioEntity =  mapper.toEntity(beneficiario);
            repositorioDocumento.deletarDocumentos(beneficiarioEntity);
        }

    }

    public Beneficiario beneficiarioById(Long id) {

        BeneficiarioEntity beneficiarioEntity = this.repository.beneficiarioById(id);

        return mapper.toDomain(beneficiarioEntity);
    }


}

