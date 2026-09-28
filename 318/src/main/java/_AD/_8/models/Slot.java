package _AD._8.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
public class Slot {
    @GeneratedValue
    @Id

    Long ID;
    BigInteger SlotNumber;
    String Status;
    BigInteger ParkingID;


}
