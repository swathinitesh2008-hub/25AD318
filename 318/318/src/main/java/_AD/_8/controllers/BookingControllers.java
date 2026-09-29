package _AD._8.controllers;

import _AD._8.Repository.BookingRepository;
import _AD._8.models.Booking;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Booking")
public class BookingControllers {
    private final BookingRepository repository;

    public BookingControllers(BookingRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return repository.save(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }


    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        repository.deleteById(id);
        return "Booking deleted successfully";
    }

}
