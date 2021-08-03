package br.com.rchlo.data;

import br.com.rchlo.domain.Card;
import br.com.rchlo.domain.Payment;
import br.com.rchlo.domain.PaymentStatus;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PaymentRepository {

    public List<Payment> all() {

        List<Payment> allPayments = new ArrayList<>();
        String query = "select id, amount, card_holder_name, card_number, card_expiration" +
                ", card_verification_code, status from payment";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                long id = resultSet.getLong("id");
                BigDecimal amount = resultSet.getBigDecimal("amount");

                String cardHolderName = resultSet.getString("card_holder_name");
                String cardNumber = resultSet.getString("card_number");
                YearMonth cardExpiration = YearMonth.parse(resultSet.getString("card_expiration"));
                String cardVerificationCode = resultSet.getString("card_verification_code");

                var card = new Card(cardHolderName, cardNumber, cardExpiration, cardVerificationCode);
                var status = PaymentStatus.valueOf(resultSet.getString("status"));
                var payment = new Payment(id, amount, card, status);

                allPayments.add(payment);
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("Error retrieving payments", ex);
        }

        return allPayments;
    }

    public Map<PaymentStatus, Long> totalByStatus() {

        Map<PaymentStatus, Long> totalByStatus = new LinkedHashMap<>();
        String query = "select status, COUNT(*) as total from payment group by status";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                totalByStatus.put(
                        PaymentStatus.valueOf(resultSet.getString("status")),
                        resultSet.getLong("total")
                );
            }
        } catch (SQLException ex) {
            throw new IllegalStateException("Error retrieving payments by status", ex);
        }

        return totalByStatus;
    }

    public BigDecimal maxByStatus(PaymentStatus status) {
        BigDecimal maximumValue = null;
        String query = "select max(amount) from payment where status='" + status.toString() +"'";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                maximumValue = resultSet.getBigDecimal("MAX(amount)");
            }
             return maximumValue;
        } catch (SQLException ex) {
            throw new IllegalStateException("Error retrieving payments max by status", ex);
        }

    }

}
