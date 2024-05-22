package mx.com.liverpool.framework.output.mongo.repository.jpa;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.com.liverpool.framework.output.mongo.data.PersonEntity;

public interface PersonManagementRepository extends MongoRepository<PersonEntity, String> {

}
