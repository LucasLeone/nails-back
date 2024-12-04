package jsges.nails.service.articulos;

import jsges.nails.DTO.articulos.LineaDTO;
import jsges.nails.domain.articulos.Linea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILineaService {

    public List<LineaDTO> listar();

    public Linea buscarPorId(Integer id);

    public Linea guardar(Linea model);

    public void eliminar(Linea model);

    public List<LineaDTO> listarNoEliminados(String consulta);

    public Page<LineaDTO> getLineas(Pageable pageable);

    public Page<LineaDTO> findPaginated(Pageable pageable, List<LineaDTO> lineas);

    public List<LineaDTO> buscar(String consulta);

    public Linea newModel(LineaDTO model);
}
