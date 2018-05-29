/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commissionscalculator.Interfaces;

import commissionscalculator.Exceptions.InvalidFileFormatException;
import commissionscalculator.Entities.Transaction;
import java.util.List;

/**
 *
 * @author destas
 */
public interface FileParserInterface {
    public List<Transaction> parse (String pathToFile) throws InvalidFileFormatException;
}
