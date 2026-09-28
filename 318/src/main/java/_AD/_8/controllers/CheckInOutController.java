package _AD._8.controllers;

import _AD._8.Repository.CheckInOutRepository;
import _AD._8.models.CheckInOut;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkinout")
public class CheckInOutController {

    private final CheckInOutRepository repository;

    public CheckInOutController(CheckInOutRepository repository) {
        this.repository = repository;
    }

    // Create check-in/check-out record
    @PostMapping
    public CheckInOut createCheckInOut(@RequestBody CheckInOut checkInOut) {
        return repository.save(checkInOut);
    }

    // Get all records
    @GetMapping
    public List<CheckInOut> getAllCheckInOut() {
        return repository.findAll();
    }

    // Get record by ID
    @GetMapping("/{id}")
    public CheckInOut getCheckInOutById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete record
    @DeleteMapping("/{id}")
    public String deleteCheckInOut(@PathVariable Long id) {
        repository.deleteById(id);
        return "Check-in/check-out record deleted successfully";
    }
}