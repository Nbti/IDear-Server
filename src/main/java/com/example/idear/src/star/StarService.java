package com.example.idear.src.star;

import com.example.idear.src.star.Dao.Starred;
import com.example.idear.src.star.Dto.RequestDto.StarredRequestDto;
import com.example.idear.src.star.Dto.ResponseDto.StarredResponseDto;
import com.example.idear.src.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StarService {

//    private final ContentRepository contentRepository;dd
    private final StarRepository starRepository;

    public StarredResponseDto setStarred(StarredRequestDto starredRequestDto){
        Starred starred = new Starred();
        starred.setContent(starredRequestDto.getContent());

        //임의로 User 생성
        User user = new User();
        user.setId(1L);
        user.setName("test");
        user.setEmail("test");
        user.setPassword("test");

        System.out.println();

        // user 저장하기
        starred.setUser_id(user);
        starRepository.save(starred);

        StarredResponseDto starredResponseDto = new StarredResponseDto();
        starredResponseDto.setStarredId(starred.getStarId());
        starredResponseDto.setContent(starred.getContent());
        starredResponseDto.setRegdate(starred.getRegdate());
        starredResponseDto.setUserId(starred.getUser_id());

        return starredResponseDto;
    }
}
