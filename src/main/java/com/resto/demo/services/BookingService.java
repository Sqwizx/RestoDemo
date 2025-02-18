package com.resto.demo.services;

import com.resto.demo.dtos.BookingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface BookingService {
    Page<BookingDto> findAllBookings(Pageable pageable);

    BookingDto saveBooking(BookingDto bookingDto);

    Optional<BookingDto> findBookingById(Long id);

    void deleteBookingById(Long id);
}
