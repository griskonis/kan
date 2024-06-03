package br.com.kan.application.gateways;

import br.com.kan.domain.entities.beneficiario.Beneficiario;

import java.util.List;

public interface RepositorioBeneficiario {

        Beneficiario cadastrarBeneficiario(Beneficiario beneficiario) throws Exception;

       List<Beneficiario> listarTodos() throws Exception;

    Beneficiario atualizarBeneficiario(Beneficiario beneficiario) throws Exception;

    void deletarBeneficiario(Beneficiario beneficiario) throws Exception;

    Beneficiario beneficiarioById(Long id) throws Exception;
}
