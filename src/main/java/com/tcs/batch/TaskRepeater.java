package com.tcs.batch;

import com.tcs.batch.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskRepeater {

    @Autowired
    private TransactionServiceImpl transactionService;

    @Scheduled(fixedDelay = 60000)
    public void repeat(){
        transactionService.processTransactions();
    }
}
