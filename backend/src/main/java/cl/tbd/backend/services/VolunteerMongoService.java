package cl.tbd.backend.services;

import cl.tbd.backend.models.VolunteerSkill;
import cl.tbd.backend.repositories.VolunteerMongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class VolunteerMongoService {
    public final VolunteerMongoRepository volunteerMongoRepository;

    public VolunteerMongoService(VolunteerMongoRepository volunteerMongoRepository) {
        this.volunteerMongoRepository = volunteerMongoRepository;
    }

    @GetMapping("/avgSkillVolunteerMongo")
    public float AvgSkillByVolunteer() {
        return volunteerMongoRepository.AvgSkillByVolunteer();
    }
}
