/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commissionscalculator.Services;

import commissionscalculator.Entities.Currency;

/**
 *
 * @author destas
 */
public class CurrencyConverter extends CurrencyConverterAbstract {

    /**
     * @param amount
     * @param currency
     * @return
     */
    @Override
    public double convert(double amount, String currency) {
        
        if (currency.equals(Currency.JPN)) {
            return amount / Currency.RATE_JPN;
        }
        
        if (currency.equals(Currency.USD)) {
            return amount / Currency.RATE_USD;
        }
        
        return amount;
    }
}
