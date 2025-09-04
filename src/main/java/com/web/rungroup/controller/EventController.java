package com.web.rungroup.controller;

import com.web.rungroup.dto.EventDto;
import com.web.rungroup.model.Event;
import com.web.rungroup.service.EventService;
import com.web.rungroup.service.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") Long clubId, Model model){
        Event event = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", event);
        return "events-create";
    }

    @PostMapping("/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId, Model model, EventDto eventDto){
        eventService.createEvent(clubId, eventDto);
        return "redirect:/clubs/" + clubId;
    }



}
