package com.resto.demo.services.implementation;

import com.resto.demo.dtos.BookingDto;
import com.resto.demo.dtos.CustomerDto;
import com.resto.demo.entities.Booking;
import com.resto.demo.entities.Customer;
import com.resto.demo.mappers.BookingMapper;
import com.resto.demo.mappers.CustomerMapper;
import com.resto.demo.repositories.BookingRepository;
import com.resto.demo.repositories.CustomerRepository;
import com.resto.demo.services.BookingService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper, CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Page<BookingDto> findAllBookings(Pageable pageable) {

        // Return paged booking to dto
        return bookingRepository.findAll(pageable).map(bookingMapper::toDto);
    }

    @Transactional
    @Override
    public BookingDto saveBooking(BookingDto bookingDto) {

        // Validate booking
        validateBookingDatetime(bookingDto.getBookingDatetime());

        // Validate if update / create
        Booking booking = (bookingDto.getId() != null && bookingRepository.existsById(bookingDto.getId()))
                ? updateBooking(bookingDto)
                : createBooking(bookingDto);

        // Save the booking
        Booking savedBooking = bookingRepository.save(booking);

        // Return the saved booking as DTO
        return bookingMapper.toDto(savedBooking);
    }

    // Validate booking helper function
    private void validateBookingDatetime(LocalDateTime bookingDatetime) {

        // Validate if the datetime is in the past
        if (bookingDatetime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Booking datetime cannot be in the past.");
        }

    }
    // Update booking helper function
    private Booking updateBooking(BookingDto bookingDto) {

        // Fetch existing booking
        Booking booking = bookingRepository.findById(bookingDto.getId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // Fetch and update the customer
        Customer existingCustomer = customerRepository.findById(booking.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Update booking details
        bookingMapper.partialUpdate(bookingDto, booking);

        // Update customer details if provided
        if (bookingDto.getCustomer() != null) {
            customerMapper.partialUpdate(bookingDto.getCustomer(), existingCustomer);
            customerRepository.save(existingCustomer);
        }

        return booking;
    }

    // Create booking helper function
    private Booking createBooking(BookingDto bookingDto) {

        // Get customer from dto
        CustomerDto customerDto = bookingDto.getCustomer();

        // Validate if the requested time is already booked
        if (bookingRepository.existsByBookingDatetime(bookingDto.getBookingDatetime())) {
            throw new IllegalArgumentException("A booking already exists for the requested time.");
        }

        // Validate if customer is provided
        if (customerDto == null) {
            throw new IllegalArgumentException("Customer information is required for a new booking.");
        }

        // Map DTO to entity
        Booking booking = bookingMapper.toEntity(bookingDto);

        // Validate whether customer exists
        Customer foundCustomer = customerRepository.findByNameAndEmailAndPhone(
                customerDto.getName(), customerDto.getEmail(), customerDto.getPhone());

        if (foundCustomer != null) {

            // Set found customer
            booking.setCustomer(foundCustomer);
        } else {

            // Create new customer
            Customer customer = customerMapper.toEntity(customerDto);
            customer = customerRepository.save(customer);
            booking.setCustomer(customer);
        }

        // Default status
        booking.setStatus("Confirmed");

        return booking;
    }

    @Override
    public Optional<BookingDto> findBookingById(Long id) {

        // Return found booking to dto
        return bookingRepository.findById(id).map(bookingMapper::toDto);
    }

    @Override
    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }
}
