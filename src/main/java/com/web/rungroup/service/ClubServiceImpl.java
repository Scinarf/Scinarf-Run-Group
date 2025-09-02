package com.web.rungroup.service;

import com.web.rungroup.dto.ClubDto;
import com.web.rungroup.model.Club;
import com.web.rungroup.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService{
    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List <Club> clubs= clubRepository.findAll();
        return clubs.stream().map((Club) -> mapToClubDto(Club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto club) {
        Club clubs = mapToClub(club);
        return clubRepository.save(clubs);
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
    }

    @Override
    public void delete(long clubId) {
        clubRepository.deleteById(clubId);
    }

    private Club mapToClub(ClubDto c) {
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

    private ClubDto mapToClubDto(Club c){
        ClubDto clubDto = ClubDto.builder()
                .id(c.getId())
                .content(c.getContent())
                .createdOn(c.getCreatedOn())
                .photoUrl(c.getPhotoUrl())
                .title(c.getTitle())
                .updatedOn(c.getUpdatedOn())
                .build();
        return clubDto;
    }

}