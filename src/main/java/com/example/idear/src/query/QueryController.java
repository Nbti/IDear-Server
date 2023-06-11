package com.example.idear.src.query;

import com.example.idear.common.BaseResponse;
import com.example.idear.common.BaseResponseStatus;
import com.example.idear.src.query.dto.request.QueryReq;
import com.example.idear.src.query.dto.request.RequeryReq;
import com.example.idear.src.query.dto.response.QueryRes;
import com.example.idear.src.query.dto.response.QueriesRes;
import com.example.idear.src.query.dto.response.QueryRes;
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
    public BaseResponse<QueryRes> query(
            @RequestBody QueryReq queryReq
    ){
        return new BaseResponse(BaseResponseStatus.SUCCESS, queryService.query(queryReq));
    }

    // 재질문하기
    @PostMapping("/{queryId}")
    public BaseResponse<QueryRes> requery(
            @PathVariable Long queryId,
            @RequestBody RequeryReq requeryReq
    ){
        return new BaseResponse(BaseResponseStatus.SUCCESS, queryService.requery(queryId, requeryReq));
    }

    // 글 목록 조회
    @GetMapping("/content")
    public BaseResponse<List<QueriesRes>> getQueries(
            @RequestParam Long userId
    ){
        return new BaseResponse(BaseResponseStatus.SUCCESS, queryProvider.getQueries(userId));
    }

    // 글 목록 조회
    @GetMapping("/content/{contentId}")
    public BaseResponse<String> getContent(@PathVariable("contentId") Long contentId){
        return new BaseResponse(BaseResponseStatus.SUCCESS, queryProvider.getContent(contentId));
    }

}
