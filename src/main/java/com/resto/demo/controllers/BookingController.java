package com.resto.demo.controllers;

import com.resto.demo.dtos.BookingDto;
import com.resto.demo.services.BookingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<Page<BookingDto>> findAllBookings(Pageable pageable) {
        return ResponseEntity.ok(bookingService.findAllBookings(pageable));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<BookingDto> findBookingById(@PathVariable Long id) {
        Optional<BookingDto> bookingDto = bookingService.findBookingById(id);
        return bookingDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<BookingDto> saveBooking(@RequestBody BookingDto bookingDto) {
        return ResponseEntity.ok(bookingService.saveBooking(bookingDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookingById(@PathVariable Long id) {
        bookingService.deleteBookingById(id);
        return ResponseEntity.ok("Successfully deleted booking with id:" + id);
    }
}
