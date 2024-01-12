/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import model.Payment;

/**
 *
 * @author sonho
 */
public class PaymentRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    public Payment saveAuthor(Payment payment) {
        if(payment.getId() == null) {
            entityManager.persist(payment);
        } else {
            payment = entityManager.merge(payment);
        }
        return payment;
    }

    public List<Payment> getAllPayments() {
       return entityManager.createQuery("SELECT * FROM payment", Payment.class).getResultList();
    }

    public Optional<Payment> getById(Long id) {
        Payment payment = entityManager.find(Payment.class, id);
        return Optional.ofNullable(payment);
    }
}
