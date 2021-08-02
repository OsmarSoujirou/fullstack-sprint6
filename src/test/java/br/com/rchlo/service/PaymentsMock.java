package br.com.rchlo.service;

import br.com.rchlo.domain.Card;
import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class PaymentsMock {

    private static List<Payment> allPayments = new ArrayList<>();

    public static List<Payment> all() {

        Card card = new Card("MOCK1", "0000", YearMonth.now(), "666");

        Payment paymentMock1 = new Payment(6L, new BigDecimal("200.00"), card, PaymentStatus.CONFIRMED);
        Payment paymentMock2 = new Payment(6L, new BigDecimal("50.00"), card, PaymentStatus.CONFIRMED);

        allPayments.add(paymentMock1);
        allPayments.add(paymentMock2);

        return allPayments;
    }

    public static void empty() {
        allPayments = new ArrayList<>();
    }


}