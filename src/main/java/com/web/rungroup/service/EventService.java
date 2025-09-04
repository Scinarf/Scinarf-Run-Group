package com.web.rungroup.service;


import com.web.rungroup.dto.EventDto;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);
}
