package com.levi.easy_delivery.entity;

import com.levi.easy_delivery.enums.StatusDoPrato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "pratos")
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "preco", nullable = false, columnDefinition = "decimal(7,2)")
    private BigDecimal preco;

    @Column(name = "imagem_do_prato")
    private String imagemUrl;

    @Column(name = "status_do_prato", nullable = false)
    private StatusDoPrato status;

    @CreatedDate
    @Column(name = "data_de_criacao")
    private LocalDateTime dataCriacao;

    @LastModifiedDate
    @Column(name = "data_de_modificacao")
    private LocalDateTime dataModificacao;

    @CreatedBy
    @Column(name = "criado_por")
    private String criadoPor;

    @LastModifiedBy
    @Column(name = "modificado_por")
    private String modificadoPor;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prato prato = (Prato) o;
        return Objects.equals(id, prato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}