package com.example.demo.web.webservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.dto.ArticuloDTO;
import com.example.demo.service.ArticuloService;
import com.example.demo.web.controller.ArticuloController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/articulos") // Prefijo común para las rutas de este controlador
public class ArticuloRestController {

    private static final Logger log = LoggerFactory.getLogger(ArticuloRestController.class);

    @Autowired
    private ArticuloService articuloService;

    // Obtener todos los artículos (GET)
    @GetMapping("")
    public ResponseEntity<List<ArticuloDTO>> findAll() {
        log.info(ArticuloRestController.class.getSimpleName() + " -- Listando los artículos");
        List<ArticuloDTO> listaArticulosDTO = articuloService.findAll();
        return new ResponseEntity<>(listaArticulosDTO, HttpStatus.OK);
    }

    @GetMapping("/{idArticulo}")
    public ResponseEntity<ArticuloDTO> findById(@PathVariable("idArticulo") Long idArticulo) {
        log.info(ArticuloRestController.class.getSimpleName() + " -- Listando el arituclo " + idArticulo);
        ArticuloDTO articuloDTO = new ArticuloDTO();
        articuloDTO.setId(idArticulo);
        articuloDTO = articuloService.findById(articuloDTO);
        // Compramos que el articulo no vuelve vacio
        // si vuelve vacion, enviamos al front que no ha sido encontrado
        if (articuloDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Si lo hemos encontrado. Le devolvemos que se ha encontrado
        // y le mandamos el articulo
        return new ResponseEntity<>(articuloDTO, HttpStatus.OK);
    }

    // Faltaria pasarle el cliente, y meterlo en el articulo
    @PostMapping("")
    public ResponseEntity<ArticuloDTO> add(@RequestBody ArticuloDTO articuloDTO) {
        log.info(ArticuloRestController.class.getSimpleName() + " -- Añadir un articulo ");
        /**
         * ClienteDTO clienteDTO = new ClienteDTO();
         * // clienteDTO.setId(idCliente);
         * // articuloDTO.setCliente(clienteDTO);
         */
        // Almacenamos la devolucion del guardado que nos envia el servicio para
        // poder comprobar que ha funcionado
        articuloDTO = articuloService.save(articuloDTO);
        // Miro si lo q viene del service esta vacio o me devuelve el objeto insertado
        // Si vuelve vacion mandamos un mensaje al front de que ha ido mal
        if (articuloDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        // Si lo hemos insertadp. Le devolvemos que se ha insertado
        // y le mandamos el articulo
        return new ResponseEntity<>(articuloDTO, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<ArticuloDTO> update(@RequestBody ArticuloDTO articuloDTO) {
        log.info(ArticuloRestController.class.getSimpleName() + " -- Actualizamos el articulo " + articuloDTO.getId());
        // Primero veremos si el articulo existe, para ello, lo buscaremos por medio del
        // servicio
        ArticuloDTO articuloExDTO = new ArticuloDTO();
        articuloExDTO.setId(articuloDTO.getId());
        articuloExDTO = articuloService.findById(articuloExDTO);
        // una vez buscado en la bd, comprobamos si lo ha encontrado o no
        // si no lo ha encontrado, mandamos un mensaje de no encontrado al front
        if (articuloExDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Si lo hemos actualizamos. Le devolvemos que se ha realizado la operacion
        articuloDTO = articuloService.save(articuloDTO);
        return new ResponseEntity<>(articuloDTO, HttpStatus.OK);
    }

    // En nuetro caso no borramoss, desactivamos el articulo
    @DeleteMapping("/{idArticulo}")
    public ResponseEntity<String> delete(@PathVariable("idArticulo") Long idArticulo) {
        log.info(ArticuloRestController.class.getSimpleName() + " -- Borramos el articulo " + idArticulo);
        ArticuloDTO articuloDTO = new ArticuloDTO();
        articuloDTO.setId(idArticulo);
        articuloService.delete(articuloDTO);

        return new ResponseEntity<>("Cliente borrado satisfactoriamente", HttpStatus.OK);

    }
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<ArticuloDTO>> findByTipo(@PathVariable("tipo") String tipo) {
        log.info(ArticuloRestController.class.getSimpleName() + " -- Buscamos los artículos de tipo " + tipo);
        List<ArticuloDTO> listaArticulosDTO = articuloService.findByTipo(tipo);
        return new ResponseEntity<>(listaArticulosDTO, HttpStatus.OK);
    }
   
    

}
