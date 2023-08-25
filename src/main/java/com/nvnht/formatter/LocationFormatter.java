/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.formatter;

import com.nvnht.pojo.Location;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author nghia
 */
public class LocationFormatter implements Formatter<Location>{

    @Override
    public String print(Location loca, Locale locale) {
        return String.valueOf(loca.getId());
    }

    @Override
    public Location parse(String locaId, Locale locale) throws ParseException {
        return new Location(Integer.parseInt(locaId));
    }
    
    
}
