package jsges.nails.service.articulos;

import jsges.nails.DTO.articulos.ArticuloVentaDTO;
import jsges.nails.domain.articulos.ArticuloVenta;
import jsges.nails.mappers.ArticuloMapper;
import jsges.nails.repository.articulos.ArticuloVentaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticuloVentaService implements IArticuloVentaService{

    private final ArticuloVentaRepository modelRepository;
    private static final Logger logger = LoggerFactory.getLogger(ArticuloVentaService.class);

    @Autowired
    public ArticuloVentaService(ArticuloVentaRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<ArticuloVentaDTO> listar() {
        List<ArticuloVenta> result = modelRepository.buscarNoEliminados();
        return result != null 
            ? result.stream().map(ArticuloMapper::toDTO).collect(Collectors.toList())
            : Collections.emptyList();
    }

    @Override
    public List<ArticuloVentaDTO> listarNoEliminados(String consulta) {
        List<ArticuloVenta> result = modelRepository.buscarNoEliminados(consulta);
        return result != null 
            ? result.stream().map(ArticuloMapper::toDTO).collect(Collectors.toList())
            : Collections.emptyList();
    }

    @Override
    public ArticuloVenta buscarPorId(Integer id) {
        return modelRepository.findById(id).orElse(null);
    }

    @Override
    public ArticuloVenta guardar(ArticuloVentaDTO modelDTO) {
        // Asumiendo que tienes una forma de obtener la línea a partir del DTO
        // Por ejemplo, podrías tener un servicio de Linea para obtenerla
        Linea linea = obtenerLineaPorId(modelDTO.getLinea());
        ArticuloVenta articulo = ArticuloMapper.toEntity(modelDTO, linea);
        return modelRepository.save(articulo);
    }

    @Override
    public void eliminar(int id) {
        ArticuloVenta articulo = modelRepository.findById(id).orElse(null);
        if (articulo != null) {
            articulo.asEliminado(); // Marca el artículo como eliminado
            modelRepository.save(articulo);
        } else {
            logger.warn("Intento de eliminar ArticuloVenta con id {} que no existe.", id);
        }
    }

    @Override
    public Page<ArticuloVentaDTO> getArticulos(Pageable pageable) {
        Page<ArticuloVenta> pageResult = modelRepository.findAll(pageable);
        List<ArticuloVentaDTO> dtoList = pageResult.stream()
                                                    .map(ArticuloMapper::toDTO)
                                                    .collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, pageResult.getTotalElements());
    }

    @Override
    public Page<ArticuloVentaDTO> findPaginated(Pageable pageable, List<ArticuloVentaDTO> listado) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<ArticuloVentaDTO> list;

        if (listado.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, listado.size());
            list = listado.subList(startItem, toIndex);
        }

        return new PageImpl<>(list, PageRequest.of(currentPage, pageSize), listado.size());
    }

    // Método auxiliar para obtener la línea (debes implementarlo según tu lógica)
    private Linea obtenerLineaPorId(Integer lineaId) {
        // Implementa la lógica para obtener la línea a partir del ID
        // Por ejemplo:
        // return lineaRepository.findById(lineaId).orElseThrow(() -> new ResourceNotFoundException("Linea no encontrada"));
        return null; // Placeholder
    }
}
