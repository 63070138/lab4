package com.example.lab04_05f;

import org.springframework.web.bind.annotation.*;

@RestController
public class Calculator {
    @RequestMapping(value = "plus/{a}/{b}", method = RequestMethod.GET)
    public double myPlus(@PathVariable("a") double a, @PathVariable("b") double b){
        return a+b;
    }
    @RequestMapping(value = "minus/{a}/{b}", method = RequestMethod.GET)
    public double myMinus(@PathVariable("a") double a, @PathVariable("b") double b){
        return a-b;
    }
    @RequestMapping(value = "divide/{a}/{b}", method = RequestMethod.GET)
    public double myDivide(@PathVariable("a") double a, @PathVariable("b") double b){
        return a/b;
    }
    @RequestMapping(value = "multi/{a}/{b}", method = RequestMethod.GET)
    public double myMulti(@PathVariable("a") double a, @PathVariable("b") double b){
        return a*b;
    }
    @RequestMapping(value = "mod/{a}/{b}", method = RequestMethod.GET)
    public double myMod(@PathVariable("a") double a, @PathVariable("b") double b){
        return a%b;
    }
    @RequestMapping(value = "max", method = RequestMethod.POST)
    public double myMax(@RequestParam("num1") double a, @RequestParam("num2") double b){
        if (a > b){
            return a;
        }
        else {
            return b;
        }
    }



}
