package _AD._8.Repository;

import _AD._8.models.Booking;
import _AD._8.models.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findBySlotID(BigInteger slotID);
}
