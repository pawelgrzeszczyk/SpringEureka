package pl.umcs.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.umcs.model.Position;
@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {
}
