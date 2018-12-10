package pl.umcs.services;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.umcs.model.Position;
import pl.umcs.repositories.PositionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {
    @Autowired
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }


    public Position save(Position position) {
        Position savedPosition = positionRepository.save(position);
        return savedPosition;
    }

    public Position find(Long id) {
        Optional<Position> position = positionRepository.findById(id);
        if (position.isPresent()) {
            return position.get();
        }
        return null;
    }

    public List<Position> findAll() {
        Iterable<Position> positionsIterable = positionRepository.findAll();
        List<Position> positionsList = Lists.newArrayList(positionsIterable);
        return positionsList;
    }

    public Position update(Position position) {
        Position updatedPosition = positionRepository.save(position);
        return updatedPosition;
    }

    public void deletePosition(Long id) {
        positionRepository.deleteById(id);
    }
}
