package com.restaurante.reviews.service.impl;

import com.restaurante.reviews.DTO.OrderDTO;
import com.restaurante.reviews.models.Order;
import com.restaurante.reviews.models.User;
import com.restaurante.reviews.repository.*;
import com.restaurante.reviews.service.GetAllOrderService;
import com.restaurante.reviews.service.impl.util.ListOrdersService;
import com.restaurante.reviews.service.impl.util.ValidateUserType;

import java.util.List;

public class GetAllOrderServiceImpl implements GetAllOrderService {
    private final OrderRepository orderRepository;
    private final ListOrdersService listOrdersService;

    public GetAllOrderServiceImpl(OrderRepository orderRepository, OrderFoodsRepository orderFoodsRepository) {
        this.orderRepository = orderRepository;
        this.listOrdersService = new ListOrdersService(orderFoodsRepository);
    }

    @Override
    public List<OrderDTO> getAllOrder(Long id, FoodStellRepository foodStallRepository,
                                                        ClientRepository clientRepository) {

        User user = ValidateUserType.userType(id,foodStallRepository, clientRepository);
        List<Order> modelOrder;

        if(user.getUserType().toString().equals("FOOD_STALL")) {
            modelOrder = orderRepository.findOrdersByFoodStall_Id(user.getId());
        }else{
            modelOrder = orderRepository.findOrdersByClient_Id(user.getId());
        }

        return listOrdersService.listOrder(modelOrder);
    }
}