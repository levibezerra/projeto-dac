package com.levi.easy_delivery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "item_pedidos")
@EntityListeners(AuditingEntityListener.class)
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantidade_pedidos", nullable = false)
    private int quantidade;

    @Column(name = "preco_unitario", nullable = false, columnDefinition = "decimal(7,2)")
    private BigDecimal precoUnitario;

    @Column(name = "sub_total", nullable = false, columnDefinition = "decimal(7,2)")
    private BigDecimal subTotal;

    @ManyToOne
    @JoinColumn(name = "prato_id", nullable = false)
    private Prato prato;

    @ManyToOne
    @JoinColumn(name = "pedido-id", nullable = false)
    private Pedido pedido;

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
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}