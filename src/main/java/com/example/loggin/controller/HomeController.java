package com.example.loggin.controller;

import com.example.loggin.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private  HomeService homeService;
    Logger logger= LoggerFactory.getLogger(HomeController.class);
    @Value("${custom.first}")
    private Double var1;
    @Value("${custom.second}")
    private Double var2;

    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        String welcome= "Bienvenidos";
        logger.info("This is a welcome text");
        return ResponseEntity.ok().body(welcome);
    }
    @GetMapping("/exp")
    public ResponseEntity<String> potencia(){
        logger.info("This is the power of these numbers");
        return ResponseEntity.ok().body(String.valueOf(homeService.potencia(var1,var2)));
    }
    @GetMapping("/get-errors")
    public ResponseEntity<String> mistake(){
        logger.error("This is a mistake text");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Is a mistake");
    }

}
