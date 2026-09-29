package _AD._8.services;

import _AD._8.Repository.BookingRepository;
import _AD._8.Repository.SlotRepository;
import _AD._8.models.Booking;
import _AD._8.models.Slot;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class BookingServices {
    private final BookingRepository repository;
    private final SlotRepository slotRepository;

    public BookingServices(BookingRepository repository, SlotRepository slotRepository) {
        this.repository = repository;
        this.slotRepository = slotRepository;
    }

    // Create booking and automatically find an available slot
    public Booking createBooking(Booking booking) {

        // 1. Check booking time
        if (booking.getStartTime().compareTo(booking.getEndTime()) >= 0) {
            throw new RuntimeException("Start time must be before end time");
        }

        // 2. Get all slots in the requested parking lot
        List<Slot> slots =
                slotRepository.findByParkingID(booking.getParkingID());

        // 3. Check each slot
        for (Slot slot : slots) {

            // 4. Check whether this slot has an overlapping booking
            if (!hasOverlap(
                    slot.getSlotNumber(),
                    booking.getStartTime(),
                    booking.getEndTime())) {

                // 5. Assign the available slot
                booking.setSlotID(slot.getSlotNumber());

                // 6. Confirm booking
                booking.setStatus("CONFIRMED");

                // 7. Save booking
                return repository.save(booking);
            }
        }

        // 8. No slot available
        throw new RuntimeException(
                "No available slots for the selected time");
    }

    // Check whether a slot already has an overlapping booking
    public boolean hasOverlap(BigInteger slotID,
                              BigInteger startTime,
                              BigInteger endTime) {

        List<Booking> bookings = repository.findBySlotID(slotID);

        for (Booking existing : bookings) {

            if (startTime.compareTo(existing.getEndTime()) < 0 &&
                    endTime.compareTo(existing.getStartTime()) > 0) {

                return true;
            }
        }

        return false;
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    // Get booking by ID
    public Booking getBookingById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete booking
    public void deleteBooking(Long id) {
        repository.deleteById(id);
    }
}