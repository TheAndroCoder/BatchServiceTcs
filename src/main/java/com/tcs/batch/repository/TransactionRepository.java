package com.tcs.batch.repository;

import com.tcs.batch.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    @Query(nativeQuery = true,value = "select * from transaction where status='pending'")
    public List<Transaction> findAllByStatus();

}
