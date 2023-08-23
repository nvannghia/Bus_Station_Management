/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.formatter;

import com.nvnht.pojo.Buscompanies;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author nghia
 */
public class BuscompaniesFormatter implements Formatter<Buscompanies>{

    @Override
    public String print(Buscompanies bus, Locale locale) {
        return String.valueOf(bus.getId());
    }

    @Override
    public Buscompanies parse(String busId, Locale locale) throws ParseException {
        return new Buscompanies(Integer.parseInt(busId));
    }
    
}
