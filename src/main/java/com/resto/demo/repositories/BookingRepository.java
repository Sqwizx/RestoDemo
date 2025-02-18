package com.resto.demo.repositories;

import com.resto.demo.entities.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Page<Booking> findAll(Pageable pageable);

    Booking save(Booking booking);

    Optional<Booking> findById(Long id);

    void deleteById(Long id);

    boolean existsByBookingDatetime(LocalDateTime bookingDatetime);
}