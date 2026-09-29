package _AD._8.services;

import _AD._8.Repository.CheckInOutRepository;
import _AD._8.models.CheckInOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInOutServices {
    private final CheckInOutRepository repository;

    public CheckInOutServices(CheckInOutRepository repository) {
        this.repository = repository;
    }

    public CheckInOut createCheckInOut(CheckInOut checkInOut) {
        return repository.save(checkInOut);
    }

    public List<CheckInOut> getAllCheckInOut() {
        return repository.findAll();
    }

    public CheckInOut getCheckInOutById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteCheckInOut(Long id) {
        repository.deleteById(id);
    }
}
