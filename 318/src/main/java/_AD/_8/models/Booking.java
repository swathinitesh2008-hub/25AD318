package _AD._8.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.math.BigInteger;

@Entity
@Data
public class Booking {
    @GeneratedValue
    @Id

    Long ID;
    String VehicleNumber;
    BigInteger SlotID;
    BigInteger StartTime;
    BigInteger EndTime;
    String Status;

}
