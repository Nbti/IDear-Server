package com.example.idear.src.query;

import com.example.idear.src.content.ContentProvider;
import com.example.idear.src.query.dto.response.QueriesRes;
import com.example.idear.src.query.model.MyQuery;
import com.example.idear.utils.TimestampFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryProvider {
    private final QueryRepository queryRepository;
    private final ContentProvider contentProvider;

    public List<QueriesRes> getQueries(Long userId){
        List<MyQuery> myQueryList = queryRepository.findAllByUserId(userId);
        List<QueriesRes> queriesResList = new ArrayList<>();

        for(MyQuery myQuery : myQueryList){
            QueriesRes queriesRes = QueriesRes.builder()
                    .dear(myQuery.getDear())
                    .type(myQuery.getType())
                    .createdAt(myQuery.getCreatedAt())
                    .contentResList(contentProvider.getContentResList(myQuery.getId()))
                    .build();
            queriesResList.add(queriesRes);
        }

        return queriesResList;
    }
}
