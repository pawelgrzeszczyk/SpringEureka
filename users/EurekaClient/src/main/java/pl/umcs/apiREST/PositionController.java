package pl.umcs.apiREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.umcs.model.Position;
import pl.umcs.services.PositionService;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@Component
@RequestMapping("/position")
public class PositionController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private final PositionService positionService;
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Position> getPosition() {
        List<Position> positions = positionService.findAll();
        log.info("Retrieve objects {}", positions);
        return positions;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Position save(@RequestBody Position position) {
        Position savedPosition = positionService.save(position);
        log.info("Add position {}", savedPosition);
        return savedPosition;
    }

    @GetMapping("/{id}")
    public Position find(@PathVariable Long id) {
        return positionService.find(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePosition(@PathVariable Long id) {
        positionService.deletePosition(id);
        log.info("Delete position with id {}", id);
        return new ResponseEntity(NO_CONTENT);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Position update(@RequestBody Position position) {
        Position updatedPosition = positionService.update(position);
        log.info("Updated position {}", updatedPosition);
        return updatedPosition;
    }
}
