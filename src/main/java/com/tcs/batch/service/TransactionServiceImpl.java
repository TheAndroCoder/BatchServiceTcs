package com.tcs.batch.service;

import com.tcs.batch.model.Account;
import com.tcs.batch.model.Transaction;
import com.tcs.batch.repository.AccountRepository;
import com.tcs.batch.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServiceImpl implements  TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void processTransactions() {
        System.out.println("Trying to Process Transactions");
        List<Transaction> list=transactionRepository.findAllByStatus();
        System.out.println("Pending Transaction count = "+list.size());
        list.stream().forEach(transaction->{
            System.out.println("Running...");
            int from = transaction.getFromAccountId();
            int to=transaction.getToAccountId();
            double amount = transaction.getAmount();
            Account debitAccount =accountRepository.getAccountById(from);
            Account creditAccount = accountRepository.getAccountById(to);
            //System.out.println(debitAccount.toString());
            if(debitAccount==null || creditAccount==null){
                transaction.setStatus("failed");
                transaction.setResult("Account does not exist");
                transactionRepository.save(transaction);
                return;
            }
            double AmountInDebitAccount = debitAccount.getBalance();
            //System.out.println(AmountInDebitAccount);
            if(AmountInDebitAccount<=amount+2000){
                transaction.setStatus("failed");
                transaction.setResult("Insufficient Balance");
            }else{
                transaction.setResult("Processed Successfully");
                transaction.setStatus("success");
                debitAccount.setBalance(debitAccount.getBalance()-amount);
                creditAccount.setBalance(creditAccount.getBalance()+amount);
                accountRepository.save(debitAccount);
                accountRepository.save(creditAccount);
            }
            transactionRepository.save(transaction);
        });
    }
}
