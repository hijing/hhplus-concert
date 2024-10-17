package io.hhplus.concert.interfaces.controller.payment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointDTO {
    private Long id;
    private int price;

    public void chargePoint(int amount) {
        this.price += amount;
    }
}
