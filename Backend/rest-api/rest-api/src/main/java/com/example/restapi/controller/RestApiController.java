package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;
@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping(path = "/hello")
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";
        return html;
    }

    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(@PathVariable(name = "message") String msg, @PathVariable int age, @PathVariable boolean isMan){
        System.out.println("echo message : " + msg);
        System.out.println("echo age : " + age);
        System.out.println("echo isMan : " + isMan);

        // TODO 대문자로 변환해서 RETURN => toUpperCase
        // String 타입의 변수 외에 다른 타입 받아보기(boolean, integer로)

        return msg.toUpperCase();
    }

    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(@RequestParam String category, @RequestParam String issuedYear, @RequestParam(name = "issued-month") String issuedMonth, @RequestParam(name = "issued_day") String issuedDay){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);

    }
    // http://localhost:8080/api/book2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
    @GetMapping(path = "/book2")
    public void queryParamDTO(BookQueryParam bookQueryParam){
        System.out.println(bookQueryParam);
    }

    // TODO Parameter 2가지 받습니다. int 형태로 받아서 두 수의 덧셈, 곱셈을 리턴하는 메서드
    @GetMapping(path = "/result/int1/{int1}/int2/{int2}")
    public String result(@PathVariable int int1, @PathVariable int int2){
        int sum = int1 + int2; int product = int1 * int2;
        System.out.println("sum : " + sum);
        System.out.println("product : " + product);

        return "Complete";
    }
    // TODO String 타입과 boolean 타입도 받아보기
    @GetMapping(path = "/result2/string/{string}/boolean/{boolean}")
    public String result2(@PathVariable(name = "string") String str, @PathVariable(name = "boolean") Boolean bool){
        System.out.println("String : " + str);
        System.out.println("Boolean : " + bool);

        return "Complete";
    }

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
        }
    )
    public void delete(
        @PathVariable String userName
    ){
        log.info("user-name : {}", userName);
    }

}
