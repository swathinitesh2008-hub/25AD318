package _AD._8.controllers;

import _AD._8.Repository.SlotRepository;
import _AD._8.models.Slot;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Slots")
public class SlotController {
    private final SlotRepository repository;
    public SlotController(SlotRepository repository) {
        this.repository = repository;
    }

    // Add a new slot
    @PostMapping
    public Slot createSlot(@RequestBody Slot slot) {
        return repository.save(slot);
    }

    // Get all slots
    @GetMapping
    public List<Slot> getAllSlots() {
        return repository.findAll();
    }

    // Get slot by ID
    @GetMapping("/{id}")
    public Slot getSlotById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Delete slot
    @DeleteMapping("/{id}")
    public String deleteSlot(@PathVariable Long id) {
        repository.deleteById(id);
        return "Slot deleted";
    }


}
