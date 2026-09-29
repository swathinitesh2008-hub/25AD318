package _AD._8.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
public class CheckInOut {
    @GeneratedValue
    @Id

    Long ID;
    BigInteger BookingID;
    BigInteger StartTime;
    BigInteger EndTime;
    BigInteger OverStay;
    BigInteger Penalty;
}
