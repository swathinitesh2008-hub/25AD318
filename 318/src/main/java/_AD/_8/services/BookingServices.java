package _AD._8.services;

import _AD._8.Repository.BookingRepository;
import _AD._8.models.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServices {
    private final BookingRepository repository;

    public BookingServices(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking createBooking(Booking booking) {
        return repository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    public Booking getBookingById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteBooking(Long id) {
        repository.deleteById(id);
    }
}
