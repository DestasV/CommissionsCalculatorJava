/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commissionscalculator.Services;

import commissionscalculator.Entities.Transaction;

/**
 *
 * @author destas
 */
public abstract class CommissionsCalculatorAbstract {
    protected final double DEPOSIT_COST = 0.0003;
    protected final double CASH_IN_COMMISSION_FEE_MAX = 5.00;
    protected final double CASH_OUT_COMMISSION_FEE = 0.03;
    protected final double CASH_OUT_COMMISSION_FEE_MIN = 0.50;
    
    protected CurrencyConverter currencyConverter;

    public CommissionsCalculatorAbstract() {
        this.currencyConverter = new CurrencyConverter();
    }
    abstract void calculate(Transaction transaction);
}
