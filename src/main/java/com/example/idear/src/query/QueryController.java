package com.example.idear.src.query;

import com.example.idear.common.BaseResponse;
import com.example.idear.common.BaseResponseStatus;
import com.example.idear.src.query.dto.request.QueryReq;
import com.example.idear.src.query.dto.response.FirstQueryRes;
import com.example.idear.src.query.dto.response.QueriesRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/home/query")
@RequiredArgsConstructor
public class QueryController {
    private final QueryService queryService;
    private final QueryProvider queryProvider;


    // 첫 질문하기
    @PostMapping("")
    public BaseResponse<FirstQueryRes> query(
            @RequestBody QueryReq queryReq
    ){
        return new BaseResponse(BaseResponseStatus.SUCCESS, queryService.query(queryReq));
    }

    // 재질문하기
//    @PostMapping("/content/{contentId}")
//    public BaseResponse<QueryRes> requery(){
//
//    }

    // 글 목록 조회
//    @GetMapping("")
//    public BaseResponse<List<QueriesRes>> getQueries(
//            @RequestParam Long userId
//    ){
//        return new BaseResponse(BaseResponseStatus.SUCCESS, queryProvider)
//    }

}
