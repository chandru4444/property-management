package com.mycompany.property_management.controller;


import com.mycompany.property_management.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1") // class level mapping of url to a controller class
public class CalculatorController {


//    http://localhost:8080/api/v1/add/99?num1=95.5&num2=87.6 (when i combines the both path and parameter we need to give value before the ? in the postman
    //http://localhost:8080//api/v1/ca?num111=95,5&num222=87.6
    //http://localhost:8080/api/v1/add/add?num111=95.5&num222=87.6 ( bro this is even consider the  reqmaping and getmapping so its add/add)
    //http://localhost:8080/api/v1/add?num1=95.5&num2=87.6


    @GetMapping("/add/{num33}")  //method level mapping of url to a controller function

    public Double add(@RequestParam("num1") Double num1,@RequestParam("num2") Double num2 , @PathVariable("num33") Double num3){
        return num1+num2+num3;



    }

    @GetMapping("/sub/{num11}/{num2}")

    public Double sub(@PathVariable("num11") Double num1,@PathVariable("num2") Double num2){
        Double      result=0.0;
        if(num1>num2){
            result=num1-num2;
        }
        else{
            result=num2-num1;
        }
        return result;
    }
    //we are doing this  solve over use of parameter values and the security

    @PostMapping("/mul")


    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
       Double result =null;

       result=calculatorDTO.getNum1()*calculatorDTO.getNum2()*calculatorDTO.getNum3()*calculatorDTO.getNum4();

        ResponseEntity<Double>  responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return  responseEntity ;

       // here we changed from returning double and result to the response entity to give status-id with code
    }


}
