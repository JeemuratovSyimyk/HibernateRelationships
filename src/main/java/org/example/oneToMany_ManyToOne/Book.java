package org.example.oneToMany_ManyToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Setter
@Getter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(
            generator = "books gen",
            strategy = GenerationType.SEQUENCE )
    @SequenceGenerator(name = "books gen",
            sequenceName = "books seq",
            allocationSize = 1)
    private Long id;
   @Column(name = "books")
    private String bookName;
   @ManyToOne
    private Author author;
    @Override
    public String toString() {
        return "\nBook{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
