/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commissionscalculator.Services;

/**
 *
 * @author destas
 */
public abstract class CurrencyConverterAbstract {
    abstract double convert(double amount, String currency);
}
