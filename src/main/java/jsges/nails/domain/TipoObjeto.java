package jsges.nails.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TipoObjeto implements Serializable {
    public final int ACTIVO = 0;
    public final int ELIMINADO = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_objeto_id_seq")
    @SequenceGenerator(name = "tipo_objeto_id_seq", sequenceName = "tipo_objeto_id_seq", allocationSize = 1)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String denominacion;

    @Column(columnDefinition = "INTEGER", nullable = false)
    private Integer estado;

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoObjeto other = (TipoObjeto) obj;
        return Objects.equals(this.id, other.id);
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