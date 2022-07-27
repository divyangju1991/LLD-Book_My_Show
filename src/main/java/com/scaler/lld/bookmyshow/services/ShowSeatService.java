package com.scaler.lld.bookmyshow.services;

import com.scaler.lld.bookmyshow.models.ShowSeat;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {

    public boolean isOccupied(ShowSeat showSeat) {
        return false;
    }

    public void book(ShowSeat showSeat) {
    }

}
