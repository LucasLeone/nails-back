package jsges.nails.domain.servicios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@ToString
public class ItemServicio {
    public final int ACTIVO = 0;
    public final int ELIMINADO = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String observacion;

    @ManyToOne()
    private TipoServicio tipoServicio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Servicio servicio;

    @Column(nullable = false)
    private Double total;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ItemServicio that = (ItemServicio) o;
        return this.getEstado() == that.getEstado() && Objects.equals(id, that.id)
                && Objects.equals(observacion, that.observacion) && Objects.equals(tipoServicio, that.tipoServicio)
                && Objects.equals(servicio, that.servicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estado, observacion, tipoServicio, servicio);
    }

    public ItemServicio() {

    }

    public ItemServicio(Servicio servicio, TipoServicio tipo, Double precio, String observacion) {
        this.setServicio(servicio);
        this.setTipoServicio(tipo);
        this.setTotal(precio);
        this.setObservacion(observacion);
        this.setEstado(ACTIVO);
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        if (total <= 0) {
            throw new IllegalArgumentException("El total debe ser mayor que cero.");
        }
        this.total = total;
    }
}
