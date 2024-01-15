/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import model.Transaction;

/**
 *
 * @author sonho
 */
public class PaymentRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    public Transaction saveAuthor(Transaction payment) {
        if(payment.getId() == null) {
            entityManager.persist(payment);
        } else {
            payment = entityManager.merge(payment);
        }
        return payment;
    }

    public List<Transaction> getAllPayments() {
       return entityManager.createQuery("SELECT * FROM payment", Transaction.class).getResultList();
    }

    public Optional<Transaction> getById(Long id) {
        Transaction payment = entityManager.find(Transaction.class, id);
        return Optional.ofNullable(payment);
    }
}
