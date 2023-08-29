package atl.bootcamp.e9.savorpot.service.reviews.util;

import atl.bootcamp.e9.savorpot.models.OrderStatus;

import java.util.HashMap;
import java.util.Map;

public final class ValidarOrderStatus {

    private final static Map<String, OrderStatus>  statusOrder = new HashMap<>(){{
        put("ACTIVE",OrderStatus.ACTIVE);
        put("COMPLETE",OrderStatus.COMPLETE);
        put("CANCELED",OrderStatus.CANCELED);
    }};

    public static boolean statusOfOrder(String status) {

        return (status.equals(OrderStatus.ACTIVE.toString()) ||
                    status.equals(OrderStatus.COMPLETE.toString()) ||
                    status.equals(OrderStatus.CANCELED.toString()));
    }

    public static OrderStatus getStatus(String status) {
        return statusOrder.get(status);
    }
}
