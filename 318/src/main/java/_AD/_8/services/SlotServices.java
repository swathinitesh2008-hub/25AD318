package _AD._8.services;

import _AD._8.Repository.SlotRepository;
import _AD._8.models.Slot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotServices {
    private final SlotRepository repository;

    public SlotServices(SlotRepository repository) {
        this.repository = repository;
    }

    public Slot createSlot(Slot slot) {
        return repository.save(slot);
    }

    public List<Slot> getAllSlots() {
        return repository.findAll();
    }

    public Slot getSlotById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteSlot(Long id) {
        repository.deleteById(id);
    }
}
