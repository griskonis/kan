package br.com.kan.application.usecases;

import br.com.kan.application.gateways.RepositorioBeneficiario;
import br.com.kan.domain.entities.beneficiario.Beneficiario;
import br.com.kan.infra.controller.BeneficiarioDto;

import java.util.List;

public class ListarBeneficiarios {

    private final RepositorioBeneficiario repositorioBeneficiario;

    public ListarBeneficiarios(RepositorioBeneficiario repositorioBeneficiario) {


        this.repositorioBeneficiario = repositorioBeneficiario;
    }

    public List<Beneficiario> listarBeneficiarios() {

        try {
            return this.repositorioBeneficiario.listarTodos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Beneficiario beneficiarioById(Long id) throws Exception {

        return this.repositorioBeneficiario.beneficiarioById(id);

    }
}
