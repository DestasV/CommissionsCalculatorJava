/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commissionscalculator.Entities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author valdemaras
 */
public class Cache {
   private final Map<Integer, Double> cache;

    public Cache() {
        this.cache = new HashMap<>();
    }
   
   public Map getCache() {
       return this.cache;
   }
   
   public void updateAmount(int clientId, double amount) {
        synchronized(cache) {
            if (!this.cache.containsKey(clientId)) {
                cache.put(clientId, amount);
            } else {
                double cachedAmount = cache.get(clientId);
                cache.put(clientId, amount += cachedAmount);
            }
        }
   }
}
