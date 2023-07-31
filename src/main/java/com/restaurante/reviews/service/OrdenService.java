package com.restaurante.reviews.service;

import com.restaurante.reviews.models.*;
import com.restaurante.reviews.models.models_auxiliar.ComidaEnOrden;
import com.restaurante.reviews.models.models_auxiliar.OrdenRequest;
import com.restaurante.reviews.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class OrdenService {

    private final OrdenRepository ordenRepository;
    private final ClienteRepository clienteRepository;
    private final ComestiblesRepository comestiblesRepository;
    private final RestauranteRepository restauranteRepository;
    private final OrdenComesRepository ordenComesRepository;

    public OrdenService(OrdenRepository ordenRepository,
                        ClienteRepository clienteRepository,
                        ComestiblesRepository comestiblesRepository,
                        RestauranteRepository restauranteRepository,
                        OrdenComesRepository ordenComesRepository) {

        this.ordenRepository = ordenRepository;
        this.clienteRepository = clienteRepository;
        this.comestiblesRepository = comestiblesRepository;
        this.restauranteRepository = restauranteRepository;
        this.ordenComesRepository = ordenComesRepository;
    }

    public ResponseEntity<String> crearOrden(OrdenRequest ordenRequest) {

        Orden nuevaOrden = new Orden();


        Long idCliente = 1L;
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        Restaurante restaurante = restauranteRepository.findById(ordenRequest.getIdRestaurante()).orElse(null);

        nuevaOrden.setCliente(cliente);
        nuevaOrden.setEstado(ordenRequest.getEstado());
        nuevaOrden.setFechaHora(LocalDateTime.of(LocalDate.now(), LocalTime.now()) );
        nuevaOrden.setTiempoEntrega(ordenRequest.getTiempoEntrega());
        nuevaOrden.setPrecioTotal(ordenRequest.getTotal());
        nuevaOrden.setRestaurante(restaurante);

        nuevaOrden = ordenRepository.save(nuevaOrden);

        for(ComidaEnOrden comidaEnOrden : ordenRequest.getComidas()) {

            OrdenComestibles ordenComestibles = new OrdenComestibles();
            Comestibles comestibles = comestiblesRepository.findById(comidaEnOrden.getIdComida()).orElse(null);

            if (comestibles != null) {
                ordenComestibles.setOrden(nuevaOrden);
                ordenComestibles.setComestibles(comestibles);
                ordenComestibles.setCantidad(comidaEnOrden.getCantidad());

                ordenComesRepository.save(ordenComestibles);
              // nuevaOrden.getOrdenComestiblesList().add(ordenComestibles);
            }
        }
     //   ordenRepository.save(nuevaOrden);
        return ResponseEntity.ok("Orden creada exitosamente.");
    }

    public List<Orden> getOrdenes() {
        return (List<Orden>) ordenRepository.findAll();
    }

    public List<OrdenComestibles> getOrden(Long id) {
        return ordenComesRepository.findByOrden_Id(id);
    }
}
