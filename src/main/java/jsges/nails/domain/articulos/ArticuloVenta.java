package jsges.nails.domain.articulos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticuloVenta {
    public final int ACTIVO = 0;
    public final int ELIMINADO = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    @Size(max = 255, message = "La denominación no puede exceder los 255 caracteres.")
    private String denominacion;

    @Column(columnDefinition = "INTEGER", nullable = false)
    private Integer estado = ACTIVO;

    @Column(length = 500)
    @Size(max = 500, message = "La observación no puede exceder los 500 caracteres.")
    private String observacion;

    @ManyToOne(cascade = CascadeType.ALL)
    private Linea linea;

    public void asEliminado() {
        this.estado = ELIMINADO;
    }

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
}
