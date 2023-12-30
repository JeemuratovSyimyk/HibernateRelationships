package org.example.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "people")
@Setter
@Getter
@NoArgsConstructor
public class Person {
   @Id
   @GeneratedValue(
           generator = "person gen",
           strategy = GenerationType.SEQUENCE )
   @SequenceGenerator(name = "person gen",
           sequenceName = "person seq",
           allocationSize = 1)
    private Long id;
    private Long INN;
   @OneToOne
    private Passport passport;

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", INN=" + INN +
                '}';
    }
}
