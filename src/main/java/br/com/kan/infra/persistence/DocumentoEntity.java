package br.com.kan.infra.persistence;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "DOCUMENTO")
public class DocumentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "BENEFICIARIO_ID")
    private BeneficiarioEntity beneficiarioEntity;

    private String tipoDocumento;
    private String descricao;

    private LocalDate dataInclusao;

    private LocalDate dataAlteracao;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public BeneficiarioEntity getBeneficiarioEntity() {
        return beneficiarioEntity;
    }

    public void setBeneficiarioEntity(BeneficiarioEntity beneficiarioEntity) {
        this.beneficiarioEntity = beneficiarioEntity;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
