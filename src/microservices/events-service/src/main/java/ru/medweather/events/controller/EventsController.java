package ru.medweather.events.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.medweather.events.model.*;
import ru.medweather.events.service.EventsService;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventsController {

    private final EventsService eventsService;

    @GetMapping("/health")
    public Health getHealth() {
        return new Health(true);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedResponse createUser(@RequestBody User user) {
        eventsService.createUser(user);
        return new CreatedResponse("success");
    }

    @PostMapping("/payment")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedResponse createPayment(@RequestBody Payment payment) {
        eventsService.createPayment(payment);
        return new CreatedResponse("success");
    }

    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedResponse createMovie(@RequestBody Movie movie) {
        eventsService.createMovie(movie);
        return new CreatedResponse("success");
    }
}
