package org.example.Config;

import jakarta.persistence.EntityManagerFactory;
import org.example.Entity.Passport;
import org.example.Entity.Person;
import org.example.oneToMany_ManyToOne.Author;
import org.example.oneToMany_ManyToOne.Book;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class RelationshipConfiguration {
    public static EntityManagerFactory getEntityManager() {
      try {
          Properties properties = new Properties();
          properties.put(Environment.DRIVER, "org.postgresql.Driver");
          properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
          properties.put(Environment.USER, "postgres");
          properties.put(Environment.PASS, "postgres");
          properties.put(Environment.HBM2DDL_AUTO, "create");
          properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
          properties.put(Environment.SHOW_SQL, "true");
          properties.put(Environment.FORMAT_SQL, "true");

          Configuration configuration = new Configuration();
          configuration.addProperties(properties);
          configuration.addAnnotatedClass(Person.class);
          configuration.addAnnotatedClass(Passport.class);
          configuration.addAnnotatedClass(Author.class);
          configuration.addAnnotatedClass(Book.class);
          System.out.println("successfully connected");
          return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
      }catch (HibernateException e){
          System.out.println(e.getMessage());
      }
        return null;
    }
}