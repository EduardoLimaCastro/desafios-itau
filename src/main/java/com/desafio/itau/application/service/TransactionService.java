package com.desafio.itau.application.service;

import com.desafio.itau.domain.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    private final List<Transaction> transactions = new ArrayList<>();

    public ResponseEntity<Void> create(Transaction transaction) {
        transactions.add(transaction);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
