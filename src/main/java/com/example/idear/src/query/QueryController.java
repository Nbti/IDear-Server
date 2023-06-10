package com.example.idear.src.query;

import com.example.idear.common.BaseResponse;
import com.example.idear.common.BaseResponseStatus;
import com.example.idear.src.query.dto.request.QueryReq;
import com.example.idear.src.query.dto.response.QueryRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/home/query")
@RequiredArgsConstructor
public class QueryController {
    private final QueryService queryService;

    // 첫 질문하기
    @PostMapping("")
    public BaseResponse<QueryRes> query(
            @RequestBody QueryReq queryReq
    ){
        return new BaseResponse(BaseResponseStatus.SUCCESS, queryService.query(queryReq));
    }

    // 재질문하기
//    @PostMapping("/content/{contentId}")
//    public BaseResponse<QueryRes> requery(){
//
//    }

}
