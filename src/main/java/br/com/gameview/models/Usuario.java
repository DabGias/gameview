package br.com.gameview.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
    name = "tb_usuario",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_username_usuario",
            columnNames = "username_usuario"
        )
    }
)
public class Usuario {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "seq_usuario"
    )
    @SequenceGenerator(
        name = "seq_usuario",
        sequenceName = "seq_usuario",
        allocationSize = 1
    )
    @Column(name = "id_usuario")
    private Long id;

    @NotBlank
    @Column(name = "username_usuario")
    private String username;

    @NotBlank
    @Min(value = 8)
    @Column(name = "senha_usuario")
    private String senha;

    public Usuario() {}

    public Usuario(Long id, String username, String senha) {
        this.id = id;
        this.username = username;
        this.senha = senha;
    }

    public Usuario(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", senha='" + senha + '\'' +
            '}';
    }
}
