package com.web.rungroup.service;

import com.web.rungroup.dto.ClubDto;
import com.web.rungroup.model.Club;
import com.web.rungroup.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.web.rungroup.map.ClubMapper.mapToClub;
import static com.web.rungroup.map.ClubMapper.mapToClubDto;

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

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

}