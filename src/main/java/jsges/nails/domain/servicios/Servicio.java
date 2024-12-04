package jsges.nails.domain.servicios;

import jakarta.persistence.*;
import jsges.nails.domain.organizacion.Cliente;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Entity
public class Servicio {
    public final int ACTIVO = 0;
    public final int ELIMINADO = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(nullable = false)
    private LocalDateTime fechaRealizacion;

    @Column(nullable = false)
    private double total;

    @Column(columnDefinition = "INTEGER", nullable = false)
    private Integer estado;

    public void setEstado(int estado) {
        if (estado == ACTIVO || estado == ELIMINADO) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("El estado debe ser 0 (activo) o 1 (eliminado).");
        }
    }

    public String getEstadoString() {
        return this.estado == ACTIVO ? "Activo" : "Eliminado";
    }

    public Servicio() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public Servicio(Cliente cliente, LocalDateTime fechaRealizacion, double total) {
        this.cliente = cliente;
        this.fechaRealizacion = fechaRealizacion;
        this.total = total;
        this.fechaRegistro = LocalDateTime.now();
        this.estado = ACTIVO;
    }

    public void setFechaRealizacion(LocalDateTime fechaRealizacion) {
        if (fechaRealizacion.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha de realización no puede ser anterior a la fecha actual.");
        } else {
            this.fechaRealizacion = fechaRealizacion;
        }
    }

    public void setTotal(double total) {
        if (total <= 0) {
            throw new IllegalArgumentException("El total debe ser mayor a 0.");
        } else {
            this.total = total;
        }
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "id=" + id +
                ", cliente=" + cliente.getId() +
                ", fechaRegistro=" + fechaRegistro +
                ", fechaRealizacion=" + fechaRealizacion +
                ", total=" + total +
                ", estado=" + getEstadoString() +
                '}';
    }
}