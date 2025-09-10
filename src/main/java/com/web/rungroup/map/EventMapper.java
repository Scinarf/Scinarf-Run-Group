package com.web.rungroup.map;

import com.web.rungroup.dto.EventDto;
import com.web.rungroup.model.Event;

public class EventMapper {
    public static Event mapToEvent(EventDto eventDto){
        return Event.builder()
                .name(eventDto.getName())
                .type(eventDto.getType())
                .endTime(eventDto.getEndTime())
                .updatedOn(eventDto.getUpdatedOn())
                .startTime(eventDto.getStartTime())
                .createdOn(eventDto.getCreatedOn())
                .photoUrl(eventDto.getPhotoUrl())
                .club(eventDto.getClub())
                .build();
    }

    public static EventDto mapToEventDto(Event event){
        return EventDto.builder()
                .name(event.getName())
                .type(event.getType())
                .endTime(event.getEndTime())
                .updatedOn(event.getUpdatedOn())
                .startTime(event.getStartTime())
                .createdOn(event.getCreatedOn())
                .photoUrl(event.getPhotoUrl())
                .club(event.getClub())
                .build();
    }
}
