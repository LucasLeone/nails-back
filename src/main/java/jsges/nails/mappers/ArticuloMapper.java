package jsges.nails.mappers;

import jsges.nails.DTO.articulos.ArticuloVentaDTO;
import jsges.nails.domain.articulos.ArticuloVenta;
import jsges.nails.domain.articulos.Linea;

public abstract class ArticuloMapper {
    public static ArticuloVentaDTO toDTO(ArticuloVenta articulo) {
        ArticuloVentaDTO articuloVentaDTO = new ArticuloVentaDTO(articulo);
        return articuloVentaDTO;
    }

    public static ArticuloVenta toEntity(ArticuloVentaDTO articuloVentaDTO, Linea linea) {
        ArticuloVenta articuloVenta = new ArticuloVenta();
        articuloVenta.setId(articuloVentaDTO.getId());
        articuloVenta.setDenominacion(articuloVentaDTO.getDenominacion());
        articuloVenta.setLinea(linea);
        return articuloVenta;
    }
}
