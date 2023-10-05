package br.com.gameview.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(
    name = "tb_dev",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_nome_dev",
            columnNames = "nome_dev"
        )
    }
)
public class Desenvolvedora {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "seq_dev"
    )
    @SequenceGenerator(
        name = "seq_dev",
        sequenceName = "seq_dev",
        allocationSize = 1
    )
    @Column(name = "id_dev")
    private Long id;

    @NotBlank
    @Column(name = "nome_dev")
    private String nome;

    @OneToMany(
        fetch = FetchType.EAGER,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        mappedBy = "desenvolvedora"
    )
    private List<VideoGame> jogos;

    public Desenvolvedora() {}

    public Desenvolvedora(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Desenvolvedora(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Desenvolvedora{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            '}';
    }
}
