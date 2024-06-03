package br.com.kan.infra.controller;

import br.com.kan.domain.entities.documento.Documento;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record DocumentoDto(
        Integer Id,

        String descricao,
        String tipoDocumento,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate dataInclusao,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        LocalDate dataAlteracao
)
{
}
