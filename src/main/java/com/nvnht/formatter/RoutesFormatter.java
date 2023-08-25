/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nvnht.formatter;

import com.nvnht.pojo.Routes;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author nghia
 */
public class RoutesFormatter implements Formatter<Routes>{

    @Override
    public String print(Routes route, Locale locale) {
        return String.valueOf(route.getId());
    }

    @Override
    public Routes parse(String routeId, Locale locale) throws ParseException {
        return new Routes(Integer.parseInt(routeId));
    }
    
}
