package com.example.restapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.Data; // lombok 사용시 내가 직접 생성자와 get set 메소드를 만들지 않아도 자동빵으로 생성된다
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookQueryParam {
    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;
}
