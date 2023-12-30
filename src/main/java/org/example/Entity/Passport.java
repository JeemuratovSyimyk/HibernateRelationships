package org.example.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
 @Entity
 @Table(name = "passports")
 @Setter
 @Getter
 @NoArgsConstructor
public class Passport {
 @Id
 @GeneratedValue(
         generator = "passports gen",
         strategy = GenerationType.SEQUENCE )
         @SequenceGenerator(name = "passports gen",
         sequenceName = "passports seq",
         allocationSize = 1)

    private Long id;
   @Column(name = "first_name")
    private String firstName;
   @Column(name = "last_name")
    private String lastName;
    private String country;
   @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
  @OneToOne(mappedBy = "passport")
    private Person person;
     @Override
     public String toString() {
         return "\nPassport{" +
                 "id=" + id +
                 ", firstName='" + firstName + '\'' +
                 ", lastName='" + lastName + '\'' +
                 ", country='" + country + '\'' +
                 ", dateOfBirth=" + dateOfBirth +
                 '}';
     }
 }
