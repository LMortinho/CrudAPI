package Moutinho.ApiCrud.records.UnidadeMedida;

import Moutinho.ApiCrud.domain.UnidadeMedida.UnidadeMedida;

public record DadosListagemMedida(Long codigo, String descricao) {

    public DadosListagemMedida(UnidadeMedida unidadeMedida) {
        this(unidadeMedida.getId(), unidadeMedida.getDescricao());
    }
}
