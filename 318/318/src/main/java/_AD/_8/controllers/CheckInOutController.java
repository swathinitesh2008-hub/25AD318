package _AD._8.controllers;

import _AD._8.Repository.CheckInOutRepository;
import _AD._8.models.CheckInOut;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/checkinout")
public class CheckInOutController {

    private final CheckInOutRepository repository;

    public CheckInOutController(CheckInOutRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public CheckInOut createCheckInOut(@RequestBody CheckInOut checkInOut) {
        return repository.save(checkInOut);
    }

    @GetMapping
    public List<CheckInOut> getAllCheckInOut() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public CheckInOut getCheckInOutById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }


    @DeleteMapping("/{id}")
    public String deleteCheckInOut(@PathVariable Long id) {
        repository.deleteById(id);
        return "Check-in/check-out record deleted successfully";
    }
}