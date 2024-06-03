package br.com.kan.infra.gateways;

import br.com.kan.domain.entities.beneficiario.Beneficiario;
import br.com.kan.domain.entities.documento.Documento;
import br.com.kan.infra.persistence.BeneficiarioEntity;
import br.com.kan.infra.persistence.DocumentoEntity;

import java.util.ArrayList;
import java.util.List;

public class DocumentoEntityMapper {

    public List<DocumentoEntity> toEntity(List<Documento> listDocumento,BeneficiarioEntity beneficiarioEntity ){


        List<DocumentoEntity> listDocumentoEntity = new ArrayList<>();

        for(Documento documento : listDocumento){

            //       DocumentoEntity documentoEntity = new DocumentoEntity(0,documento.getTipoDocumento(),documento.getDescricao(),documento.getDataInclusao(),documento.getDataAlteracao());
            DocumentoEntity documentoEntity = new DocumentoEntity();

            documentoEntity.setTipoDocumento(documento.getTipoDocumento());
            documentoEntity.setDescricao(documento.getDescricao());
            documentoEntity.setDataAlteracao(documento.getDataAlteracao());
            documentoEntity.setDataInclusao(documento.getDataInclusao());
            documentoEntity.setBeneficiarioEntity(beneficiarioEntity);

            listDocumentoEntity.add(documentoEntity);

        }


        return  listDocumentoEntity;
    }

    public  Beneficiario toDomain(BeneficiarioEntity beneficiarioEntity){

        return  new Beneficiario(beneficiarioEntity.getId(), beneficiarioEntity.getNome(),
                beneficiarioEntity.getTelefone(), beneficiarioEntity.getDataNascimento(),
                beneficiarioEntity.getDataInclusao(),beneficiarioEntity.getDataAlteracao(),null);
    }

}
