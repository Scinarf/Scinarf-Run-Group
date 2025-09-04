package com.web.rungroup.map;

import com.web.rungroup.dto.ClubDto;
import com.web.rungroup.model.Club;

import java.util.stream.Collectors;

import static com.web.rungroup.map.EventMapper.mapToEventDto;

public class ClubMapper {

    public static Club mapToClub(ClubDto c) {
        Club club = Club.builder()
                .id(c.getId())
                .content(c.getContent())
                .createdOn(c.getCreatedOn())
                .photoUrl(c.getPhotoUrl())
                .title(c.getTitle())
                .updatedOn(c.getUpdatedOn())
                .build();
        return club;
    }

    public static ClubDto mapToClubDto(Club c){
        ClubDto clubDto = ClubDto.builder()
                .id(c.getId())
                .content(c.getContent())
                .createdOn(c.getCreatedOn())
                .photoUrl(c.getPhotoUrl())
                .title(c.getTitle())
                .updatedOn(c.getUpdatedOn())
                .events(c.getEvents().stream().map(event -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }

}
