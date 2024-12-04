package jsges.nails.DTO.servicios;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jsges.nails.domain.servicios.ItemServicio;
import jsges.nails.domain.servicios.Servicio;

public class ServicioDTO {

    public Integer id;
    public Integer cliente;
    public LocalDateTime fechaDocumento;
    public double total;
    public Set<ItemServicioDTO> listaItems = new HashSet<>();
    public String clienteRazonSocial;

    public ServicioDTO(Servicio elemento, List<ItemServicio> list) {
        this.id = elemento.getId();
        this.cliente = elemento.getCliente().getId();
        this.clienteRazonSocial = elemento.getCliente().getRazonSocial();
        this.fechaDocumento = elemento.getFechaRealizacion();
        this.total = elemento.getTotal();

        list.forEach((model) -> {
            this.listaItems.add(new ItemServicioDTO(model));
        });
    }

    public ServicioDTO(Servicio elemento) {
        this.id = elemento.getId();
        this.cliente = elemento.getCliente().getId();
        this.clienteRazonSocial = elemento.getCliente().getRazonSocial();
        this.fechaDocumento = elemento.getFechaRealizacion();
        this.total = elemento.getTotal();
    }
}