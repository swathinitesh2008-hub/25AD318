package _AD._8.controllers;

import _AD._8.Repository.ParkingLotRepository;
import _AD._8.models.ParkingLot;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/parkinglots")
public class ParkingLotController {

    private final ParkingLotRepository repository;

    public ParkingLotController(ParkingLotRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ParkingLot createParkingLot(@RequestBody ParkingLot parkingLot) {
        return repository.save(parkingLot);
    }

    @GetMapping
    public List<ParkingLot> getAllParkingLots() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ParkingLot getParkingLotById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete a parking lot
    @DeleteMapping("/{id}")
    public String deleteParkingLot(@PathVariable Long id) {
        repository.deleteById(id);
        return "Parking lot deleted successfully";
    }
}