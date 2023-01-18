package jpabook.jpashop.repository.order.query;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class OrderItemQueryDto {

    @JsonIgnore
    private Long orderId;
    private String itemname;
    private int orderPrice;
    private int count;

    public OrderItemQueryDto(Long orderId, String itemname, int orderPrice, int count) {
        this.orderId = orderId;
        this.itemname = itemname;
        this.orderPrice = orderPrice;
        this.count = count;
    }
}
