package com.tcs.batch.repository;

import com.tcs.batch.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    @Query(nativeQuery = true,value = "select * from account where accountid=?1")
    public Account getAccountById(int accountId);
}
