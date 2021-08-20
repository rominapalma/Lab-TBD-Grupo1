package cl.tbd.backend.repositories;
import java.util.ArrayList;
import java.util.Arrays;

import com.mongodb.client.AggregateIterable;
import org.bson.BsonNull;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.bson.Document;
@Repository
public class VolunteerMongoRepositoryImp implements VolunteerMongoRepository {
    @Autowired
    MongoDatabase database;

    @Override
    public float AvgSkillByVolunteer(){
        MongoCollection<Document> collection = database.getCollection("volunteerMongo");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$lookup", new Document("from", "skillMongo").append("localField", "skill").append("foreignField", "code").append("as", "skills")), new Document("$group", new Document("_id", "$_id").append("num_habilidades", new Document("$first", new Document("$size", "$skills")))), new Document("$group", new Document("_id", new BsonNull()).append("promedio", new Document("$avg", "$num_habilidades")))));

        ArrayList<Document> resultadoDocumento = new ArrayList<>(2);
        for (Document document : result) {
            resultadoDocumento.add(document);
        }
        String cadena = String.valueOf(resultadoDocumento.get(0));
        String[] auxiliar = cadena.split("=");
        String[] resultado =  auxiliar[2].split("}");

        return Float.parseFloat(resultado[0]);
    }
}







