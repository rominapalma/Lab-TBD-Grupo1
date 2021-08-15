package cl.tbd.backend.repositories;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {
    @Value("${database.url}")
    private String dbUrl;

    @Value("${database.user}")
    private String dbUser;

    @Value("${database.password}")
    private String dbPassword;

    @Value("${spring.data.mongodb.database}")
    private String dbMongo;

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(dbUrl, dbUser, dbPassword);
    }

    @Bean
    MongoDatabase database(){
        //Configuracion de codec para parsear POJO
        CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();
        CodecRegistry fromProvider = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry, fromProvider);

        //Cliente de base de datos
        MongoClient mongoClient =  MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase(dbMongo).withCodecRegistry(pojoCodecRegistry);
        return database;
    }
}
