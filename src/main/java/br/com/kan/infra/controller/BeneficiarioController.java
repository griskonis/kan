package br.com.kan.infra.controller;


import br.com.kan.application.usecases.BeneficiarioUseCases;
import br.com.kan.application.usecases.ListarBeneficiarios;
import br.com.kan.domain.entities.beneficiario.Beneficiario;
import br.com.kan.domain.entities.documento.Documento;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/beneficiario")
public class BeneficiarioController {



    private final BeneficiarioUseCases beneficiarioUseCases;

    private final ListarBeneficiarios listarBeneficiarios;

    public BeneficiarioController(BeneficiarioUseCases beneficiarioUseCases, ListarBeneficiarios listarBeneficiarios) {
        this.beneficiarioUseCases = beneficiarioUseCases;
        this.listarBeneficiarios = listarBeneficiarios;
    }

    @PostMapping
    public BeneficiarioDto cadastrarBeneficiario(@RequestBody BeneficiarioDto beneficiarioDto) throws Exception {


        try{
            return  this.beneficiarioUseCases.cadastrarBeneficiario(beneficiarioDto);
        } catch (Exception e) {
            throw new Exception("Erro ao cadastrarBeneficiario", e);
        }

    }

    @GetMapping
    public List<BeneficiarioDtoSemDoc> listarBeneficiarios() throws Exception {

        try{
        return listarBeneficiarios.listarBeneficiarios().stream()
                .map(u -> new BeneficiarioDtoSemDoc(u.getId(),u.getNome(),u.getTelefone(),u.getDataNascimento(),u.getDataInclusao(),u.getDataAlteracao()))
                .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception("Erro ao listarBeneficiarios", e);
        }


    }

    @GetMapping(path = {"/{id}"})
    public BeneficiarioDto beneficiarioById(@PathVariable long id) throws Exception {

        try{



                Beneficiario  beneficiario = listarBeneficiarios.beneficiarioById(id);

                if(beneficiario != null){

                    List<DocumentoDto> listDocumentoDto = new ArrayList<>();

                    for(Documento documento : beneficiario.getListDocumento()){

                        DocumentoDto DocumentoDto = new DocumentoDto(documento.getId(), documento.getDescricao(), documento.getTipoDocumento(),documento.getDataInclusao(),documento.getDataAlteracao());

                        listDocumentoDto.add(DocumentoDto);

                    }

                    return     new BeneficiarioDto(beneficiario.getId(),beneficiario.getNome(),beneficiario.getTelefone(),beneficiario.getDataNascimento(),
                            beneficiario.getDataInclusao(),beneficiario.getDataAlteracao(),listDocumentoDto);


                }else {
                    return  null;
                }
        } catch (Exception e) {
            throw new Exception("Erro ao beneficiarioById", e);
        }

    }
    @PutMapping(value = "/{id}")
    public BeneficiarioDtoSemDoc  atualizarBeneficiario(@PathVariable Long id,@RequestBody BeneficiarioDtoSemDoc beneficiarioDtoSemDoc) throws Exception {

        try {
            return this.beneficiarioUseCases.atualizarBeneficiario(id,beneficiarioDtoSemDoc);
        } catch (Exception e) {
            throw new Exception("Erro BeneficiarioDtoSemDoc", e);
        }




    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus deletarBeneficiario(@PathVariable Long id) throws Exception {


        try {
            return this.beneficiarioUseCases.deletarBeneficiario(id);
        } catch (Exception e) {
            throw new Exception("Erro BeneficiarioDtoSemDoc", e);
        }



    }


}
