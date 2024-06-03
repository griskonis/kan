package br.com.kan.application.gateways;

import br.com.kan.domain.entities.beneficiario.Beneficiario;

import java.util.List;

public interface RepositorioBeneficiario {

        Beneficiario cadastrarBeneficiario(Beneficiario beneficiario);

       List<Beneficiario> listarTodos();

    Beneficiario atualizarBeneficiario(Beneficiario beneficiario);

    void deletarBeneficiario(Beneficiario beneficiario);

    Beneficiario beneficiarioById(Long id);
}
