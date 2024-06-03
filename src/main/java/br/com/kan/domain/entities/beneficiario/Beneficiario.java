package br.com.kan.domain.entities.beneficiario;


import br.com.kan.domain.entities.documento.Documento;

import java.time.LocalDate;
import java.util.List;

public class Beneficiario {


    public  Beneficiario(Integer id,String nome, String telefone, LocalDate dataNascimento, LocalDate dataInclusao,LocalDate dataAlteracao,List<Documento> listDocumento){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataInclusao = dataInclusao;
        this.dataAlteracao = dataAlteracao;
        this.listDocumento = listDocumento;
    }

    private Integer id;

    private String nome;

    private String telefone;

    private LocalDate dataNascimento;

    private LocalDate dataInclusao;

    private LocalDate dataAlteracao;


    private List<Documento> listDocumento;



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

    public List<Documento> getListDocumento() {
        return listDocumento;
    }

    public void setListDocumento(List<Documento> listDocumento) {
        this.listDocumento = listDocumento;
    }
}
