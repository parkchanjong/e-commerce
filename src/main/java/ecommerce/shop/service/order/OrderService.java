package ecommerce.shop.service.order;

import ecommerce.shop.domain.order.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderService {

    private final OrdersRepository ordersRepository;
}
