package br.com.rchlo.service;

import br.com.rchlo.data.PaymentRepository;
import br.com.rchlo.domain.PaymentStatus;
import br.com.rchlo.dto.PaymentStatistics;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Map;

class PaymentStatisticsCalculatorTest {

    private PaymentStatisticsCalculator paymentStatisticsCalculator;
    private PaymentStatistics paymentStatistics;

    @Mock
    private PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(paymentRepository.all()).thenReturn(PaymentsMock.all());
        paymentStatisticsCalculator = new PaymentStatisticsCalculator(paymentRepository);
    }
    @AfterEach
    void empty() {
        PaymentsMock.empty();
    }

    @Test
    void shouldCalculateMaximumAmountOfConfirmedPayment() {
        PaymentStatistics paymentStatistics = paymentStatisticsCalculator.calculate();
        BigDecimal maximumAmountOfConfirmedPayment = paymentStatistics.getMaximumAmountOfConfirmedPayment();
        Assertions.assertThat(maximumAmountOfConfirmedPayment).isEqualTo(new BigDecimal("200.00"));
    }

    @Test
    void deveConsiderarQuantidadeDePagamentoPorStatus() {
        paymentStatistics = paymentStatisticsCalculator.calculate();
        Map<PaymentStatus, Long> quantityOfPaymentsByStatus = paymentStatistics.getQuantityOfPaymentsByStatus();
        Assertions.assertThat(quantityOfPaymentsByStatus)
                .containsEntry(PaymentStatus.CONFIRMED, 2L);
    }

}