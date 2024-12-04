package jsges.nails.DTO.articulos;

import jsges.nails.DTO.TipoObjetoDTO;
import jsges.nails.domain.articulos.ArticuloVenta;

public class ArticuloVentaDTO extends TipoObjetoDTO {

    private Integer id;
    private String denominacion;
    private Integer linea;

    public ArticuloVentaDTO(ArticuloVenta model) {
        this.id = model.getId();
        this.denominacion = model.getDenominacion();
        this.linea = model.getLinea().getId();
    }

    public ArticuloVentaDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }
}