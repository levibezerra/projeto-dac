package com.levi.easy_delivery.entity;

import com.levi.easy_delivery.enums.StatusPedido;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_total", nullable = false, columnDefinition = "decimal(7,2)")
    private BigDecimal valorTotal;

    @Column(name = "endereco_de_entrega", nullable = false, length = 100)
    private String enderecoEntrega;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_pedido", nullable = false, length = 25)
    private StatusPedido status;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_id", nullable = false, unique = true)
    private Pagamento pagamento;

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
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}