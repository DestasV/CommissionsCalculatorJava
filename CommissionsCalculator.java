/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commissionscalculator;

import commissionscalculator.Exceptions.InvalidFileFormatException;
import commissionscalculator.Entities.Cache;
import commissionscalculator.Entities.Client;
import commissionscalculator.Entities.Transaction;
import commissionscalculator.Services.CsvFileParser;
import commissionscalculator.Interfaces.FileParserInterface;
import commissionscalculator.Services.LegalClientCalculator;
import commissionscalculator.Services.NaturalClientCalculator;
import java.util.ArrayList;

/**
 *
 * @author Valdemar Karasevič
 */
public class CommissionsCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Path to file is missing");
            System.exit(0);
        }
        
        String pathToFile = args[0];
        FileParserInterface fileParser = new CsvFileParser();                
        Cache cache = new Cache();
        ArrayList<Transaction> transactions = new ArrayList<>();
        
        try {
            transactions = (ArrayList<Transaction>) fileParser.parse(pathToFile);
        } catch (InvalidFileFormatException exception) {
            System.out.println("Error: File parsing: " + exception.getMessage());
            System.exit(1);
        }
        

        for (Transaction transaction : transactions) {
            if (transaction.getClient().getType().equals(Client.TYPE_LEGAL)) {
                LegalClientCalculator legalCalculator = new LegalClientCalculator(transaction, cache);
                Thread thread = new Thread(legalCalculator);
                thread.start();
            }
            if (transaction.getClient().getType().equals(Client.TYPE_NATURAL)) {
                NaturalClientCalculator naturalCalculator = new NaturalClientCalculator(transaction, cache);
                Thread thread = new Thread(naturalCalculator);
                thread.start();
            }
        }
        
        cache.getCache().forEach((k, v) -> cache.printClientAmount(k));
}
}
