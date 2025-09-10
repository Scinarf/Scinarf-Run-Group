package com.web.rungroup.controller;

import com.web.rungroup.dto.ClubDto;
import com.web.rungroup.dto.EventDto;
import com.web.rungroup.model.Event;
import com.web.rungroup.service.EventService;
import com.web.rungroup.service.EventServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{eventId}/edit")
    public String editEventForm (@PathVariable("eventId") long eventId, Model model){
        EventDto event = eventService.findByEventId(eventId);
        model.addAttribute("event", event);
        return "events-edit";
    }

    @PostMapping("/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId, Model model, EventDto eventDto, BindingResult result){

        eventService.createEvent(clubId, eventDto);

        if (result.hasErrors()){
            model.addAttribute("event", eventDto);
            return "clubs-edit";
        }

        return "redirect:/clubs/" + clubId;
    }

    @PostMapping("/{eventId}/edit")
    public String updateEvent (@PathVariable("eventId") Long eventId,
                             @Valid @ModelAttribute("event")
                             EventDto eventDto,
                             BindingResult result, Model model){

        EventDto event = eventService.findByEventId(eventId);
        eventDto.setId(eventId);
        eventDto.setClub(event.getClub());
        eventService.updateEvent(eventDto);

        if (result.hasErrors()){
            model.addAttribute("event", eventDto);
            return "events-edit";
        }
        return "redirect:/events";
    }


    @GetMapping
    public String eventList(Model model){
        List<EventDto> events = eventService.findAllEvents();
        model.addAttribute("event", events);
        return "events-list";
    }

    @GetMapping("/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") long eventId){
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }

    @GetMapping("/{eventId}")
    public String viewEvent(@PathVariable("eventId") Long eventId, Model model){
        EventDto eventDto = eventService.findByEventId(eventId);
        model.addAttribute("events", eventDto);
        return "events-detail";
    }



}
