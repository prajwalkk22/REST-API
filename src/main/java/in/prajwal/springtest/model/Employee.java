package in.prajwal.springtest.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
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

    @NotEmpty(message = "Name should not be null")
    private String name;

    //@JsonIgnore//to avoid in http
    @Column(name="age")
    private Long age = 0L;

   //@Column(name="location")
    //private String location;

    @Column(name="email")
    @Email
    private String email;

    @Column(name="department")
    @NotNull(message = "department should not be null")
    private String department;

    @CreationTimestamp
    @Column(name="create_At",nullable=false,updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updated_At")
    private Date updateAt;
}

//@NotBlank to avoid space inside name, @NotEmpty to avoid empty name,@NotNull to avoid null value