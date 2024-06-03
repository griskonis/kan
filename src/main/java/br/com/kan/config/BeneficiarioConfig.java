package br.com.kan.config;

import br.com.kan.application.gateways.RepositorioBeneficiario;
import br.com.kan.application.gateways.RepositorioDocumento;
import br.com.kan.application.usecases.BeneficiarioUseCases;
import br.com.kan.application.usecases.ListarBeneficiarios;
import br.com.kan.infra.gateways.BeneficiarioEntityMapper;
import br.com.kan.infra.gateways.DocumentoEntityMapper;
import br.com.kan.infra.gateways.RepositorioBeneficiarioJpa;
import br.com.kan.infra.gateways.RepositorioDocumentoJpa;
import br.com.kan.infra.persistence.BeneficiarioRepository;
import br.com.kan.infra.persistence.DocumentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeneficiarioConfig {


    @Bean
    BeneficiarioUseCases criarBeneficiario(RepositorioBeneficiario repositorioBeneficiario, RepositorioDocumento repositorioDocumento){
        return  new BeneficiarioUseCases(repositorioBeneficiario,repositorioDocumento);
    }

    @Bean
    ListarBeneficiarios listarBeneficiarios(RepositorioBeneficiario repositorioBeneficiario){
        return  new ListarBeneficiarios(repositorioBeneficiario);
    }

    @Bean
    RepositorioBeneficiarioJpa cadastrarBeneficiario  (BeneficiarioRepository repository, BeneficiarioEntityMapper mapper) {
       return new RepositorioBeneficiarioJpa(repository,mapper);
    }

    @Bean
    RepositorioDocumentoJpa cadastrarDocumento(DocumentoRepository repository, DocumentoEntityMapper mapper){
        return  new RepositorioDocumentoJpa(repository,mapper);
    }


    @Bean
    ModelMapper criarModelMapper() { return new ModelMapper();};

    @Bean
    BeneficiarioEntityMapper retornaMappper() {
        return  new BeneficiarioEntityMapper();
    }

    @Bean
    DocumentoEntityMapper retornaDocumentoMappper() {
        return  new DocumentoEntityMapper();
    }

}
