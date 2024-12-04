package jsges.nails.DTO.articulos;

import jsges.nails.DTO.TipoObjetoDTO;
import jsges.nails.domain.articulos.ArticuloVenta;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ArticuloVentaDTO extends TipoObjetoDTO {

    private Integer linea;

    public ArticuloVentaDTO(ArticuloVenta model) {
        this.id = model.getId();
        this.denominacion = model.getDenominacion();
        this.linea = model.getLinea().getId();
    }

    public ArticuloVentaDTO() {
    }
}