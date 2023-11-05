package br.com.gameview.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

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
    @Column(name = "dt_lancamento_jogo")
    private LocalDate dataLancamento;

    @NotBlank
    @Column(name = "dev_jogo")
    private String desenvolvedora;

    public VideoGame() {}

    public VideoGame(Long id, @NotBlank String nome, @NotNull LocalDate dataLancamento, @NotBlank String desenvolvedora) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.desenvolvedora = desenvolvedora;
    }

    public VideoGame(@NotBlank String nome, @NotNull LocalDate dataLancamento, @NotBlank String desenvolvedora) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
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

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    @Override
    public String toString() {
        return "VideoGame [id=" + id + ", nome=" + nome + ", dataLancamento=" + dataLancamento + ", desenvolvedora=" + desenvolvedora + "]";
    }
}
