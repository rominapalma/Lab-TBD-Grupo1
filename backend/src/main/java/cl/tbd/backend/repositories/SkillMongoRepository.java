package cl.tbd.backend.repositories;

import cl.tbd.backend.models.SkillMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "SkillMongo", path = "SkillMongo")
public interface SkillMongoRepository extends MongoRepository<SkillMongo, String> {
    List<SkillMongo> findByName(@Param("name") String name);
}
