package mx.com.liverpool.framework.output.mongo.data;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("persons")
public class PersonEntity {

  private String id;
  private String name;
  private String email;

}
