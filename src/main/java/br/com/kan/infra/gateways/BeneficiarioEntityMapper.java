package br.com.kan.infra.gateways;

import br.com.kan.domain.entities.beneficiario.Beneficiario;
import br.com.kan.domain.entities.documento.Documento;
import br.com.kan.infra.controller.DocumentoDto;
import br.com.kan.infra.persistence.BeneficiarioEntity;
import br.com.kan.infra.persistence.DocumentoEntity;
import org.modelmapper.ModelMapper;


import java.util.ArrayList;
import java.util.List;

public class BeneficiarioEntityMapper {


    public BeneficiarioEntity toEntity(Beneficiario beneficiario){


        return  new BeneficiarioEntity(beneficiario.getId(),beneficiario.getNome(),
                beneficiario.getTelefone(), beneficiario.getDataNascimento(),
                beneficiario.getDataInclusao(),beneficiario.getDataAlteracao());
    }

    public  Beneficiario toDomain(BeneficiarioEntity beneficiarioEntity){


        if (beneficiarioEntity !=null) {


            List<Documento> listDocumento = new ArrayList<>();
            if (beneficiarioEntity.getListDocumento() != null) {

                for (DocumentoEntity documentoEntity : beneficiarioEntity.getListDocumento()) {

                    Documento documento = new Documento(0, documentoEntity.getTipoDocumento(), documentoEntity.getDescricao(), documentoEntity.getDataInclusao(), documentoEntity.getDataAlteracao());

                    listDocumento.add(documento);

                }
            }
            return new Beneficiario(beneficiarioEntity.getId(), beneficiarioEntity.getNome(),
                    beneficiarioEntity.getTelefone(), beneficiarioEntity.getDataNascimento(),
                    beneficiarioEntity.getDataInclusao(), beneficiarioEntity.getDataAlteracao(), listDocumento);

        }else {
            return  null;
        }
    }


}
