package br.com.gameview.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_coment")
public class Comentario {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "seq_coment"
    )
    @SequenceGenerator(
        name = "seq_coment",
        sequenceName = "seq_coment",
        allocationSize = 1
    )
    @Column(name = "id_coment")
    private Long id;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "nota_coment")
    private int nota;

    @NotBlank
    @Column(name = "conteudo_coment")
    private String conteudo;

    @Column(name = "usuario_coment")
    private String usuario;

    @Column(name = "jogo_coment")
    private String jogo;

    public Comentario() {}

    public Comentario(Long id, @NotNull @Min(1) @Max(5) int nota, @NotBlank String conteudo, @NotBlank String usuario, @NotBlank String jogo) {
        this.id = id;
        this.nota = nota;
        this.conteudo = conteudo;
        this.usuario = usuario;
        this.jogo = jogo;
    }

    public Comentario(@NotNull @Min(1) @Max(5) int nota, @NotBlank String conteudo, @NotBlank String usuario, @NotBlank String jogo) {
        this.nota = nota;
        this.conteudo = conteudo;
        this.usuario = usuario;
        this.jogo = jogo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getJogo() {
        return jogo;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

    @Override
    public String toString() {
        return "Comentario [id=" + id + ", nota=" + nota + ", conteudo=" + conteudo + ", usuario=" + usuario + ", jogo=" + jogo + "]";
    }
}
