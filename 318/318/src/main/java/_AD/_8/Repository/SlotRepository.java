package _AD._8.Repository;

import _AD._8.models.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot,Long> {

    List<Slot> findByParkingID(BigInteger parkingID);

}
