public class OrderProcessor {

    private OrderService orderService;

    public OrderProcessor(OrderService orderService) {
        this.orderService = orderService;
    }

    public void processOrder() {
        orderService.login();
        orderService.placeOrder();
        orderService.logout();
    }
}