/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.formatter;

import com.nvnht.pojo.Trips;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author nghia
 */
public class TripsFormatter implements Formatter<Trips>{

    @Override
    public String print(Trips trip, Locale locale) {
        return String.valueOf(trip.getId());
    }

    @Override
    public Trips parse(String tripId, Locale locale) throws ParseException {
        return new Trips(Integer.parseInt(tripId));
    }
    
}
