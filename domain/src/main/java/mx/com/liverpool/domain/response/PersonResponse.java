package mx.com.liverpool.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {

  private String id;// we should leave this field as string if in the feature we will change, string can contains string and number values
  private String name;
  private String email;
}
