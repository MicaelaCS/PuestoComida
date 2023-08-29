package atl.bootcamp.e9.savorpot.controllers;


import atl.bootcamp.e9.savorpot.service.*;
import atl.bootcamp.e9.savorpot.service.reviews.util.ValidarOrderStatus;
import atl.bootcamp.e9.savorpot.DTO.OrderRequestDTO;
import atl.bootcamp.e9.savorpot.DTO.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdenController {

   private final GetAllOrderByStatusService getAllOrderByStatusService;
   private final GetAllOrderService getAllOrderService;
   private  final GetOrderByIdService getOrderService;
   private final UpdateOrderStatusService updateOrderStatusService;
   private final SoftDeleteOrderStatusService softDeleteOrderStatusService;
   private final CreateOrderService createOrderService;

    public OrdenController(GetAllOrderByStatusService getAllOrderByStatusService,
                                       GetAllOrderService getAllOrderService,
                                       GetOrderByIdService getOrderService,
                                       UpdateOrderStatusService updateOrderStatusService,
                                       SoftDeleteOrderStatusService softDeleteOrderStatusService,
                                       CreateOrderService createOrderService) {

        this.getAllOrderByStatusService = getAllOrderByStatusService;
        this.getAllOrderService = getAllOrderService;
        this.getOrderService = getOrderService;
        this.updateOrderStatusService = updateOrderStatusService;
        this.softDeleteOrderStatusService = softDeleteOrderStatusService;
        this.createOrderService = createOrderService;
    }

    @PostMapping("/api/order")
    public ResponseEntity<String> createOrden(@RequestBody OrderRequestDTO orderRequestDTO){

        Long clientID = 1L;

        return createOrderService.createOrden(clientID, orderRequestDTO);
    }

    @GetMapping("/api/order")
    public List<OrderDTO> getAllOrder(@RequestParam(required = false) String status){

        Long userID = 1L;

        if (status != null && ValidarOrderStatus.statusOfOrder(status.toUpperCase())) {

            return getAllOrderByStatusService.getAllOrderByStatus(
                        userID,
                        ValidarOrderStatus.getStatus(status.toUpperCase())
            );
        }

        return getAllOrderService.getAllOrder(userID);
    }

    @GetMapping("/api/order/id/{id}")
    public OrderDTO getOrder(@PathVariable Long id) {

        Long userID = 1L;

        return getOrderService.getOrderbyId(id, userID);
    }

    @PutMapping("/api/order/{id}")
    public ResponseEntity<String> updateStateOrder(@PathVariable Long id) {

        Long userID = 1L;

        return updateOrderStatusService.updateOrder(userID, id);
    }

    @DeleteMapping("/api/order/{id}")
    public ResponseEntity<String> softDeleteStateOrder(@PathVariable Long id) {

        return softDeleteOrderStatusService.softDeleteOrder(id);
    }


}
