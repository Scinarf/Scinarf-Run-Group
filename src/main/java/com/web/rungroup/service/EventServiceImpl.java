package com.web.rungroup.service;

import com.web.rungroup.dto.EventDto;
import com.web.rungroup.model.Club;
import com.web.rungroup.model.Event;
import com.web.rungroup.repository.ClubRepository;
import com.web.rungroup.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.web.rungroup.map.EventMapper.mapToEvent;

@Service
public class EventServiceImpl implements EventService{
    private EventRepository eRepo;
    private ClubRepository cRepo;

    @Autowired
    public EventServiceImpl(EventRepository eRepo, ClubRepository cRepo) {
        this.eRepo = eRepo;
        this.cRepo = cRepo;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = cRepo.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
    }


}
