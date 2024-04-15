package com.example.loggin.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class HomeService {
   private final Logger logger = LoggerFactory.getLogger(HomeService.class);

    public double potencia(Double var1,Double var2){
        logger.debug("La potencia de {} y {}");
        double result= Math.pow(var1,var2);
        logger.debug("El resultado de la potencia. Result : {}");
        return result;
    }
}
