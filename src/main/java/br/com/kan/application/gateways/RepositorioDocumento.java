package br.com.kan.application.gateways;

import br.com.kan.domain.entities.beneficiario.Beneficiario;
import br.com.kan.domain.entities.documento.Documento;
import br.com.kan.infra.persistence.BeneficiarioEntity;

import java.util.List;

public interface RepositorioDocumento {

    void cadastrarDocumentos(List<Documento> listDocumento, BeneficiarioEntity beneficiarioEntity);

   void deletarDocumentos(BeneficiarioEntity beneficiarioEntity);


}
