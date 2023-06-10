package com.example.idear;

import com.example.idear.common.BaseResponse;
import com.example.idear.common.BaseResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/test")
public class TestController {
    @GetMapping("")
    public BaseResponse<String> test(){
        return new BaseResponse(BaseResponseStatus.SUCCESS, "succcess");
    }
}
