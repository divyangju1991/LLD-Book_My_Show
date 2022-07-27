package com.scaler.lld.bookmyshow.services;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.scaler.lld.bookmyshow.dtos.CreateBookingDTO;
import com.scaler.lld.bookmyshow.models.Booking;
import com.scaler.lld.bookmyshow.models.Customer;
import com.scaler.lld.bookmyshow.models.ShowSeat;
import com.scaler.lld.bookmyshow.repositories.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingService {

    @Autowired
    private ShowSeatService showSeatService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BookingRepository bookingRepository;

    private static Lock lock = new ReentrantLock(false);

    /*
     * Step -1 : Validate If booking is open
     * Step -2 : Check If Seats are available
     * Step -3 : Mark the seat as FILLED
     * Step-4 : Create and persist booking
     */
    public Booking book(CreateBookingDTO bookingRequest) {

        //Step -1 : Validate If booking is open
        if (!bookingRequest.getShow().isShowPending()) {
            throw new RuntimeException("Booking for this movie is closed!");
        }
        
        Booking booking;
        try {
            lock.lock();
            //Step -2 : Check If Seats are available
            boolean isOccupied = checkIfOccupied(bookingRequest.getShowSeats());
                    
            if (isOccupied) {
                throw new RuntimeException("Seat are already booked!");
            }

            //Step-3 : Go ahead and book
            //Mark the seat as FILLED
            for (ShowSeat showSeat : bookingRequest.getShowSeats()) {
                showSeat.setOccupied(true);
                showSeatService.book(showSeat);
            }

            //Step-4 : Create and persist booking
            Customer customer = customerService.getCustomer(bookingRequest.getCustomerId());
            booking = new Booking(customer, bookingRequest.getShow());
            booking.setSeatsBooked(bookingRequest.getShowSeats());
            bookingRepository.save(booking);
        } finally {
            lock.unlock();
        }
        // todo: release lock
        return booking;
    }

    private boolean checkIfOccupied(List<ShowSeat> showSeats) {
        for (ShowSeat showSeat : showSeats) {
            if (showSeatService.isOccupied(showSeat)) {
                return true;
            }
        }
        return false;
    }
}
