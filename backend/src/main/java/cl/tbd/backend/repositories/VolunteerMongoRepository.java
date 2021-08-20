package cl.tbd.backend.repositories;

import cl.tbd.backend.models.VolunteerMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


public interface VolunteerMongoRepository {
    public float AvgSkillByVolunteer();
}