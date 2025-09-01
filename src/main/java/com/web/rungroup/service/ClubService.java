package com.web.rungroup.service;

import com.web.rungroup.dto.ClubDto;
import com.web.rungroup.model.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub (Club club);
    ClubDto findClubById(long clubId);

    void updateClub(ClubDto clubDto);
}
