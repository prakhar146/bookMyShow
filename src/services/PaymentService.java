package services;

import models.Seat;

import java.util.List;

public interface PaymentService {
    boolean validatePayment(List<Seat> seats, int amount);
}
