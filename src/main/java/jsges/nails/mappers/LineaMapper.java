package jsges.nails.mappers;

import jsges.nails.DTO.articulos.LineaDTO;
import jsges.nails.domain.articulos.Linea;

public abstract class LineaMapper {
    public static LineaDTO toDTO(Linea linea) {
        LineaDTO lineaDTO = new LineaDTO();
        lineaDTO.setId(linea.getId());
        lineaDTO.setDenominacion(linea.getDenominacion());
        return lineaDTO;
    }

    public static Linea toEntity(LineaDTO lineaDTO) {
        Linea linea = new Linea();
        linea.setId(lineaDTO.getId());
        linea.setDenominacion(lineaDTO.getDenominacion());
        return linea;
    }
}
