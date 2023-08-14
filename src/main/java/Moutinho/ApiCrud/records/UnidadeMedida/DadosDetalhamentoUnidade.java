package Moutinho.ApiCrud.records.UnidadeMedida;


import Moutinho.ApiCrud.domain.UnidadeMedida.UnidadeMedida;

public record DadosDetalhamentoUnidade(Long id, String desc) {

    public DadosDetalhamentoUnidade(UnidadeMedida unidadeMedida) {
        this(unidadeMedida.getId(), unidadeMedida.getDescricao());
    }
}
