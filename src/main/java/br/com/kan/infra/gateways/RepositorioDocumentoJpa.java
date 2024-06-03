package br.com.kan.infra.gateways;

import br.com.kan.application.gateways.RepositorioDocumento;
import br.com.kan.domain.entities.beneficiario.Beneficiario;
import br.com.kan.domain.entities.documento.Documento;
import br.com.kan.infra.persistence.BeneficiarioEntity;
import br.com.kan.infra.persistence.DocumentoEntity;
import br.com.kan.infra.persistence.DocumentoRepository;
import jakarta.transaction.Transactional;

import java.util.List;

public class RepositorioDocumentoJpa implements RepositorioDocumento {



    private  final DocumentoRepository repository;
    private final DocumentoEntityMapper mapper;

    public RepositorioDocumentoJpa(DocumentoRepository repository, DocumentoEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void cadastrarDocumentos(List<Documento> listDocumento,BeneficiarioEntity beneficiarioEntity) throws Exception {

        try {
            List<DocumentoEntity> listDocumentoEntity = mapper.toEntity(listDocumento,beneficiarioEntity);

            beneficiarioEntity.setListDocumento(listDocumentoEntity);

            for(DocumentoEntity documentoEntity : listDocumentoEntity){
                repository.save(documentoEntity);
            }

            for(DocumentoEntity documentoEntity : listDocumentoEntity){
                repository.save(documentoEntity);
            }
        } catch (Exception e) {
            throw new Exception("Erro cadastrarDocumentos", e);
        }

    }

    @Transactional
    @Override
    public void deletarDocumentos(BeneficiarioEntity beneficiarioEntity) throws Exception {

     try{
         repository.deletardocumentoById(beneficiarioEntity.getId());
     } catch (Exception e) {
         throw new Exception("Erro deletarDocumentos", e);
     }


    }
}
