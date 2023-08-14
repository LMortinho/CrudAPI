package Moutinho.ApiCrud.domain.UnidadeMedida;


import Moutinho.ApiCrud.records.UnidadeMedida.DadosCadastroUnidadeMedida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "unidadesmedida")
@Entity(name = "UnidadeMedida")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UnidadeMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    public UnidadeMedida(DadosCadastroUnidadeMedida dados) {
        this.descricao = dados.descricao();
    }
}


