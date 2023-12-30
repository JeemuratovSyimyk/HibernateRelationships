package org.example.oneToMany_ManyToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "authors")
@NoArgsConstructor
@Setter
@Getter
public class Author {
        @Id
        @GeneratedValue(
        generator = "authors gen",
        strategy = GenerationType.SEQUENCE )
        @SequenceGenerator(name = "authors gen",
        sequenceName = "authors seq",
        allocationSize = 1)

    private Long id;
    @Column(name = "author_name")
    private String authorName;
    @OneToMany(mappedBy = "author")
    private List<Book> books;
    @Override
    public String toString() {
        return "\nAuthor{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
