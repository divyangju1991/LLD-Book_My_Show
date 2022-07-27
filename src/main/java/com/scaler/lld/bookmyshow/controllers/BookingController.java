package com.scaler.lld.bookmyshow.controllers;

import com.scaler.lld.bookmyshow.dtos.CreateBookingDTO;
import com.scaler.lld.bookmyshow.models.Booking;
import com.scaler.lld.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/book", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Booking bookTicket(@RequestBody CreateBookingDTO createBookingDTO) {
            return bookingService.book(createBookingDTO);
    }
}
