package Moutinho.ApiCrud.Controller;

import Moutinho.ApiCrud.records.UnidadeMedida.DadosDetalhamentoUnidade;
import Moutinho.ApiCrud.records.UnidadeMedida.DadosListagemMedida;
import Moutinho.ApiCrud.records.UnidadeMedida.DadosCadastroUnidadeMedida;
import Moutinho.ApiCrud.domain.UnidadeMedida.UnidadeMedida;
import Moutinho.ApiCrud.repository.UnidadeDeMedidaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medida")
public class UnidadeDeMedidaController {

    @Autowired
    private UnidadeDeMedidaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroUnidadeMedida dados, UriComponentsBuilder uriBuilder) {
        var unidade = new UnidadeMedida(dados);
        repository.save(unidade);

        var uri = uriBuilder.path("/medida/{id}").buildAndExpand(unidade.getId()).toUri();
        var dto = new DadosDetalhamentoUnidade(unidade);

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedida>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        Page<DadosListagemMedida> dadosPage = repository.findAll(paginacao).map(DadosListagemMedida::new);

        return ResponseEntity.ok(dadosPage);
    }


}
