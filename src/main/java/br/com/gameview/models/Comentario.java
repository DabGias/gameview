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
    @Min(value = 0)
    @Max(value = 5)
    @Column(name = "nota_coment")
    private int nota;

    @NotBlank
    @Column(name = "conteudo_coment")
    private String conteudo;

    @NotNull
    @ManyToOne(
        fetch = FetchType.EAGER,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        }
    )
    @JoinColumn(
        name = "id_usuario",
        referencedColumnName = "id_usuario",
        foreignKey = @ForeignKey(name = "uk_tb_usuario")
    )
    private Usuario usuario;

    @NotNull
    @ManyToOne(
        fetch = FetchType.EAGER,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        }
    )
    @JoinColumn(
        name = "id_jogo",
        referencedColumnName = "id_jogo",
        foreignKey = @ForeignKey(name = "fk_tb_jogo")
    )
    private VideoGame jogo;

    public Comentario() {}

    public Comentario(Long id, int nota, String conteudo, Usuario usuario, VideoGame jogo) {
        this.id = id;
        this.nota = nota;
        this.conteudo = conteudo;
        this.usuario = usuario;
        this.jogo = jogo;
    }

    public Comentario(int nota, String conteudo, Usuario usuario, VideoGame jogo) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public VideoGame getJogo() {
        return jogo;
    }

    public void setJogo(VideoGame jogo) {
        this.jogo = jogo;
    }

    @Override
    public String toString() {
        return "Comentario [id=" + id + ", nota=" + nota + ", conteudo=" + conteudo + ", usuario=" + usuario + ", jogo=" + jogo + "]";
    }
}
