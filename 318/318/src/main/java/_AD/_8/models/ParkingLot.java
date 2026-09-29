package _AD._8.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Entity
@Data
public class ParkingLot {
   @Id
    @GeneratedValue

    Long ID;
    String Name;
    String Location;
    BigInteger TotalSlot;


}
