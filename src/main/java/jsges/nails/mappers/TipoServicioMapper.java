package jsges.nails.mappers;

import jsges.nails.DTO.servicios.TipoServicioDTO;
import jsges.nails.domain.servicios.TipoServicio;

public abstract class TipoServicioMapper {
    public static TipoServicioDTO toDTO(TipoServicio tipoServicio) {
        TipoServicioDTO tipoServicioDTO = new TipoServicioDTO();
        tipoServicioDTO.setId(tipoServicio.getId());
        tipoServicioDTO.setDenominacion(tipoServicio.getDenominacion());

        return tipoServicioDTO;
    }

    public static TipoServicio toEntity(TipoServicioDTO tipoServicioDTO) {
        TipoServicio tipoServicio = new TipoServicio();
        tipoServicio.setId(tipoServicioDTO.getId());
        tipoServicio.setDenominacion(tipoServicioDTO.getDenominacion());

        return tipoServicio;
    }
}
