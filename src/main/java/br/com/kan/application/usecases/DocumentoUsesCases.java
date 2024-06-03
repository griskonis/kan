package br.com.kan.application.usecases;

import br.com.kan.application.gateways.RepositorioDocumento;
import br.com.kan.domain.entities.documento.Documento;
import br.com.kan.infra.controller.DocumentoDto;
import br.com.kan.infra.persistence.BeneficiarioEntity;

import java.util.ArrayList;
import java.util.List;

public class DocumentoUsesCases {

    private final RepositorioDocumento repositorioDocumento;

    public DocumentoUsesCases(RepositorioDocumento repositorioDocumento) {
        this.repositorioDocumento = repositorioDocumento;
    }

    public  List<Documento> cadastrarDocumentos(List<DocumentoDto> documentoDtoList, BeneficiarioEntity beneficiarioEntity){

        List<Documento> listDocumento = new ArrayList<>();

        for(DocumentoDto documentoDto : documentoDtoList){

            Documento documento = new Documento(0,documentoDto.tipoDocumento(),documentoDto.descricao(),documentoDto.dataInclusao(),documentoDto.dataAlteracao());
            documento.setTipoDocumento(documentoDto.tipoDocumento());
            listDocumento.add(documento);

        }

        return  null;
    }
}
