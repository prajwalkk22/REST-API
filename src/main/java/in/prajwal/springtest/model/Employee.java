package in.prajwal.springtest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_employee")
public class Employee {
//no need of column notaion if column name is same as field name
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    //@JsonProperty("fullName") alias

    @NotNull
    private String name;

    //@JsonIgnore//to avoid in http
    @Column(name="age")
    private Long age = 0L;

   //@Column(name="location")
    //private String location;

    @Column(name="email")
    private String email;

    @Column(name="department")
    @NotNull
    private String department;

    @CreationTimestamp
    @Column(name="create_At",nullable=false,updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_At")
    private Date updateAt;
}
