package br.com.gameview.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_jogo")
public class VideoGame {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "seq_jogo"
    )
    @SequenceGenerator(
        name = "seq_jogo",
        sequenceName = "seq_jogo",
        allocationSize = 1
    )
    @Column(name = "id_jogo")
    private Long id;

    @NotBlank
    @Column(name = "nome_jogo")
    private String nome;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_lancamento")
    private LocalDate data_lancamento;

    @ManyToOne(
        fetch = FetchType.EAGER,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        }
    )
    @JoinColumn(
        name = "id_dev",
        referencedColumnName = "id_dev",
        foreignKey = @ForeignKey(name = "fk_tb_dev")
    )
    private Desenvolvedora desenvolvedora;

    @OneToMany(
        fetch = FetchType.EAGER,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        mappedBy = "jogo"
    )
    private List<Comentario> comentarios;

    public VideoGame() {}

    public VideoGame(Long id, String nome, LocalDate data_lancamento, Desenvolvedora desenvolvedora) {
        this.id = id;
        this.nome = nome;
        this.data_lancamento = data_lancamento;
        this.desenvolvedora = desenvolvedora;
    }

    public VideoGame(String nome, LocalDate data_lancamento, Desenvolvedora desenvolvedora) {
        this.nome = nome;
        this.data_lancamento = data_lancamento;
        this.desenvolvedora = desenvolvedora;
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

    public LocalDate getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(LocalDate data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public Desenvolvedora getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", data_lancamento=" + data_lancamento +
            ", desenvolvedora=" + desenvolvedora +
            '}';
    }
}
