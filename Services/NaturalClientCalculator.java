/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commissionscalculator.Services;

import commissionscalculator.Entities.Cache;
import commissionscalculator.Entities.Transaction;

/**
 *
 * @author destas
 */
public class NaturalClientCalculator extends CommissionsCalculatorAbstract implements Runnable {
    private final Transaction transaction;
    private Cache cache = new Cache();
        
    public NaturalClientCalculator(Transaction transaction, Cache cache) {
        this.transaction = transaction;
        this.cache = cache;
    }
    
    @Override
    public void run() {
        calculate(transaction);
    }
        
    @Override
    public void calculate(Transaction transaction) {
        double transactionAmount = 0.00;
        String transactionType;
        transactionType = transaction.getType();

        if (transactionType.equals(Transaction.CASH_IN)) {
            transactionAmount = this.calculateCashInCommissions(transaction);
            System.out.println(transactionAmount);
            cache.updateAmount(transaction.getClient().getId(), transaction.getSum().getAmount());
            return;
        }
        
        cache.updateAmount(transaction.getClient().getId(), transaction.getSum().getAmount());
        System.out.println(this.calculateCashOutCommissions(transaction));
    }

    private double calculateCashInCommissions(Transaction transaction) {
        double amount;
        double calculatedCommisions;
        String currency;
        amount = transaction.getSum().getAmount();
        currency = transaction.getSum().getCurrency();

        calculatedCommisions = amount * this.DEPOSIT_COST;
        calculatedCommisions = this.currencyConverter.convert(calculatedCommisions, currency);

        if (calculatedCommisions > this.CASH_IN_COMMISSION_FEE_MAX) {
            calculatedCommisions = this.CASH_IN_COMMISSION_FEE_MAX;
        }

        return calculatedCommisions;
    }

    private double calculateCashOutCommissions(Transaction transaction) {
        double amount;
        double calculatedCommisions;
        String currency;
        amount = transaction.getSum().getAmount();
        currency = transaction.getSum().getCurrency();

        calculatedCommisions = amount * this.CASH_OUT_COMMISSION_FEE;
        calculatedCommisions = this.currencyConverter.convert(calculatedCommisions, currency);

        if (calculatedCommisions < this.CASH_OUT_COMMISSION_FEE_MIN) {
            calculatedCommisions = this.CASH_OUT_COMMISSION_FEE_MIN;
        }

        return calculatedCommisions;
    }
}
