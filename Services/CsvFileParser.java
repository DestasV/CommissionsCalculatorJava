/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commissionscalculator.Services;

import commissionscalculator.Exceptions.InvalidFileFormatException;
import commissionscalculator.Entities.Client;
import commissionscalculator.Interfaces.FileParserInterface;
import commissionscalculator.Entities.Money;
import commissionscalculator.Entities.Transaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author destas
 */
public class CsvFileParser implements FileParserInterface {
    
    private final List<Transaction> transactions = new ArrayList<>();
    private final String splitBy = ",";
    private String line = "";
    
    @Override
    public List<Transaction> parse(String pathToFile) throws InvalidFileFormatException
    {
         try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            while ((line = br.readLine()) != null) {
                String[] splittedTransaction = line.split(splitBy);
                
                Transaction transaction;
                transaction = new Transaction(
                        splittedTransaction[0], 
                        new Client(Integer.parseInt(splittedTransaction[1]), splittedTransaction[2]), 
                        splittedTransaction[3], 
                        new Money(Double.parseDouble(splittedTransaction[4]), splittedTransaction[5]));
                
                transactions.add(transaction);
            }

        } catch (Exception e) {
            throw new InvalidFileFormatException(e.getMessage());
        }
        
         return transactions;
    }
}
