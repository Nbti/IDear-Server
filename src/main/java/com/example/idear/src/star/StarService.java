package com.example.idear.src.star;

import com.example.idear.src.star.Dao.Starred;
import com.example.idear.src.star.Dto.RequestDto.StarredRequestDto;
import com.example.idear.src.star.Dto.ResponseDto.StarredResponseDto;
import com.example.idear.src.user.UserRepository;
import com.example.idear.src.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StarService {

    private final StarRepository starRepository;
    private final UserRepository userRepository;

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
        starred.setUserId(user);
        starRepository.save(starred);

        StarredResponseDto starredResponseDto = new StarredResponseDto();
        starredResponseDto.setStarredId(starred.getStarId());
        starredResponseDto.setContent(starred.getContent());
        starredResponseDto.setRegdate(starred.getRegdate());
        starredResponseDto.setUserId(starred.getUserId());

        return starredResponseDto;
    }

    public List<Starred> getStarred(Long userId){
        Optional<User> optional = userRepository.findById(userId);
        User user = optional.get();
        List<Starred> list = starRepository.findByUserId(user);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        return list;
    }
}
