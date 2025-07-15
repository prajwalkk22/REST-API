package in.prajwal.springtest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class Employee {
    //@JsonProperty("fullName") alias
    private String name;

    //@JsonIgnore//to avoid in http
    private Long age;

    private String location;

    private String email;

    private String department;
}
