package ecommerce.shop.service.order;

import ecommerce.shop.domain.order.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrdersRepository ordersRepository;
}
