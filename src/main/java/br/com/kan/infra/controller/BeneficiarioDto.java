package br.com.kan.infra.controller;

import br.com.kan.domain.entities.documento.Documento;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record BeneficiarioDto(
        Integer Id,

        String nome,
        String telefone,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate dataNascimento,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate dataInclusao,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate dataAlteracao,

        List<DocumentoDto> listDocumentoDto

    )
{
}
