package br.com.rchlo.service;

import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PaymentsMock {

    private static List<Payment> allPayments = new ArrayList<>();

    public static Map<PaymentStatus, Long> totalByStatus() {

        Map<PaymentStatus, Long> totalByStatus = new LinkedHashMap<>();

        totalByStatus.put(PaymentStatus.CONFIRMED, 2L);

        return totalByStatus ;
    }

    public static void empty() {
        allPayments = new ArrayList<>();
    }


    public static BigDecimal maxByStatus(PaymentStatus status) {
        return new BigDecimal("200.00");
    }


}