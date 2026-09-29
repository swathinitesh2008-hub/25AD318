package _AD._8.services;

import _AD._8.Repository.ParkingLotRepository;
import _AD._8.models.ParkingLot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ParkingLotServices {
    private final ParkingLotRepository repository;

    public ParkingLotServices(ParkingLotRepository repository) {
        this.repository = repository;
    }

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        return repository.save(parkingLot);
    }

    public List<ParkingLot> getAllParkingLots() {
        return repository.findAll();
    }

    public ParkingLot getParkingLotById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteParkingLot(Long id) {
        repository.deleteById(id);
    }

}
