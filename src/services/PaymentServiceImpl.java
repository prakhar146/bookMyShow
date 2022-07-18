package services;

import models.Seat;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean validatePayment(List<Seat> seats, int amount) {
        return true;
    }
}
