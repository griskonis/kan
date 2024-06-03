package br.com.kan.infra.persistence;


import br.com.kan.domain.entities.documento.Documento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "BENEFICIARIO")
public class BeneficiarioEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;


    private String telefone;

    private LocalDate dataNascimento;

    private LocalDate dataInclusao;

    private LocalDate dataAlteracao;

    @JsonIgnore
 //   @OneToMany( mappedBy = "beneficiarioEntity" , fetch = FetchType.LAZY )

    @OneToMany( mappedBy = "beneficiarioEntity" , cascade = CascadeType.REMOVE )
    private List<DocumentoEntity> listDocumento;

    public  BeneficiarioEntity(){}

    public  BeneficiarioEntity(Integer id,String nome, String telefone, LocalDate dataNascimento, LocalDate dataInclusao,LocalDate dataAlteracao){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataInclusao = dataInclusao;
        this.dataAlteracao = dataAlteracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }


    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public List<DocumentoEntity> getListDocumento() {
        return listDocumento;
    }

    public void setListDocumento(List<DocumentoEntity> listDocumento) {
        this.listDocumento = listDocumento;
    }
}
