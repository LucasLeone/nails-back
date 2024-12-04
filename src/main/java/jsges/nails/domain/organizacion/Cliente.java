package jsges.nails.domain.organizacion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente implements Serializable {
    public final int ACTIVO = 0;
    public final int ELIMINADO = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String razonSocial;

    @Column(columnDefinition = "TEXT")
    private String letra;

    @Column(columnDefinition = "TEXT")
    private String contacto;

    @Column(columnDefinition = "TEXT")
    private String celular;

    @Column(columnDefinition = "TEXT")
    private String mail;

    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false)
    private Date fechaNacimiento;

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
}