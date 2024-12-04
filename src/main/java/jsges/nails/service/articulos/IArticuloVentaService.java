package jsges.nails.service.articulos;

import jsges.nails.DTO.articulos.ArticuloVentaDTO;
import jsges.nails.domain.articulos.ArticuloVenta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IArticuloVentaService {

    public List<ArticuloVentaDTO> listar();

    public List<ArticuloVentaDTO> listarNoEliminados(String consulta);

    public ArticuloVenta buscarPorId(Integer id);

    public ArticuloVenta guardar(ArticuloVentaDTO model);

    public void eliminar(int id);

    public Page<ArticuloVentaDTO> getArticulos(Pageable pageable);

    public Page<ArticuloVentaDTO> findPaginated(Pageable pageable, List<ArticuloVentaDTO> list);
}
