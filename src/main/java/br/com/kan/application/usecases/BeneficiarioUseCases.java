package br.com.kan.application.usecases;

import br.com.kan.application.gateways.RepositorioBeneficiario;
import br.com.kan.application.gateways.RepositorioDocumento;
import br.com.kan.domain.entities.beneficiario.Beneficiario;
import br.com.kan.domain.entities.documento.Documento;
import br.com.kan.infra.controller.BeneficiarioDto;
import br.com.kan.infra.controller.BeneficiarioDtoSemDoc;
import br.com.kan.infra.controller.DocumentoDto;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class BeneficiarioUseCases {
    private final RepositorioBeneficiario repositorioBeneficiario;

    private  final RepositorioDocumento repositorioDocumento;




    public BeneficiarioUseCases(RepositorioBeneficiario repositorioBeneficiario, RepositorioDocumento repositorioDocumento) {

        this.repositorioBeneficiario = repositorioBeneficiario;
        this.repositorioDocumento = repositorioDocumento;
    }

    public BeneficiarioDto cadastrarBeneficiario(BeneficiarioDto beneficiarioDto) throws Exception {

        try{


            List<Documento> listDocumento = new ArrayList<>();

            if(beneficiarioDto.listDocumentoDto() !=null){

                for(DocumentoDto documentoDto : beneficiarioDto.listDocumentoDto()){

                    Documento documento = new Documento(0,documentoDto.tipoDocumento(),documentoDto.descricao(),documentoDto.dataInclusao(),documentoDto.dataAlteracao());
                    documento.setTipoDocumento(documentoDto.tipoDocumento());
                    listDocumento.add(documento);

                }

                Beneficiario beneficiario =     new Beneficiario(0, beneficiarioDto.nome(),beneficiarioDto.telefone(),beneficiarioDto.dataNascimento(),
                        beneficiarioDto.dataInclusao(),beneficiarioDto.dataAlteracao(),listDocumento);

                repositorioBeneficiario.cadastrarBeneficiario(beneficiario);


                List<DocumentoDto> documentoListDto = new ArrayList<>();

                for(Documento documento : beneficiario.getListDocumento()){

                    DocumentoDto documentoDto = new DocumentoDto(0,documento.getTipoDocumento(),documento.getDescricao(),documento.getDataInclusao(),documento.getDataAlteracao());
                    documentoListDto.add(documentoDto);

                }


                BeneficiarioDto beneficiarioDtoReturn = new BeneficiarioDto(beneficiario.getId(),beneficiario.getNome(),beneficiario.getTelefone(),beneficiario.getDataNascimento(),
                        beneficiario.getDataInclusao(),beneficiario.getDataAlteracao(),documentoListDto);

                return  beneficiarioDtoReturn;


        }else {
            return  null;
        }

        } catch (Exception e) {
            throw new Exception("Erro cadastrarBeneficiario", e);
        }


    }

    public BeneficiarioDtoSemDoc atualizarBeneficiario(Long id,BeneficiarioDtoSemDoc beneficiarioDtoSemDoc) throws Exception {

        List<Documento> listDocumento = new ArrayList<>();

       Beneficiario beneficiario= this.repositorioBeneficiario.beneficiarioById(id);

       if(beneficiario != null){
            beneficiario.setDataAlteracao(beneficiarioDtoSemDoc.dataAlteracao());
            beneficiario.setDataInclusao(beneficiarioDtoSemDoc.dataInclusao());
            beneficiario.setNome(beneficiarioDtoSemDoc.nome());
            beneficiario.setTelefone(beneficiarioDtoSemDoc.telefone());
            beneficiario.setDataNascimento(beneficiario.getDataNascimento());


            repositorioBeneficiario.atualizarBeneficiario(beneficiario);


            List<DocumentoDto> documentoListDto = new ArrayList<>();

            for(Documento documento : beneficiario.getListDocumento()){

                DocumentoDto documentoDto = new DocumentoDto(0,documento.getTipoDocumento(),documento.getDescricao(),documento.getDataInclusao(),documento.getDataAlteracao());
                documentoListDto.add(documentoDto);

            }


            BeneficiarioDtoSemDoc beneficiarioDtoReturn = new BeneficiarioDtoSemDoc(beneficiario.getId(),beneficiario.getNome(),beneficiario.getTelefone(),beneficiario.getDataNascimento(),
                    beneficiario.getDataInclusao(),beneficiario.getDataAlteracao());


            return  beneficiarioDtoReturn;
        }else{
           return  null;
        }




    }

    public HttpStatus deletarBeneficiario(Long id) throws Exception {

        Beneficiario beneficiario= this.repositorioBeneficiario.beneficiarioById(id);

        if(beneficiario !=null){
            repositorioBeneficiario.deletarBeneficiario(beneficiario);
            return HttpStatus.OK;
        }else{
            return HttpStatus.NOT_FOUND;
        }






    }
}



