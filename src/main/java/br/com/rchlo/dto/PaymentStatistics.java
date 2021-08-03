package br.com.rchlo.dto;

import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.util.Map;

public class PaymentStatistics  {

    private BigDecimal maximumAmountOfConfirmedPayment;
    private Map<PaymentStatus, Long> paymentsByStatus;

    public PaymentStatistics(BigDecimal maximumAmountOfConfirmedPayment, Map<PaymentStatus, Long> map) {
        this.maximumAmountOfConfirmedPayment = maximumAmountOfConfirmedPayment;
        this.paymentsByStatus = map;
    }

    public BigDecimal getMaximumAmountOfConfirmedPayment() {
        return maximumAmountOfConfirmedPayment;
    }

    public Map<PaymentStatus, Long> getQuantityOfPaymentsByStatus() {
        return this.paymentsByStatus;
    }

}
