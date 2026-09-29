package _AD._8.controllers;

import _AD._8.models.Slot;
import _AD._8.Repository.SlotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/slots")
public class SlotController {

    private final SlotRepository repository;

    public SlotController(SlotRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Slot createSlot(@RequestBody Slot slot) {
        return repository.save(slot);
    }

    @GetMapping
    public List<Slot> getAllSlots() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Slot getSlotById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteSlot(@PathVariable Long id) {
        repository.deleteById(id);
        return "Slot deleted successfully";
    }
}