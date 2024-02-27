package ru.alishev.springcourse.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Person;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {

    private final EntityManager entityManager;
@Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNplus1(){
        Session session = entityManager.unwrap(Session.class);


//        List<Person> people = session.createQuery("select p from Person p", Person.class)
//                .getResultList();
//
//        for (Person person : people)
//            System.out.println("pidor "+ person.getName() + "has"+ person.getItems());

        Set<Person> people = new HashSet<Person>(session.createQuery("select p from Person p LEFT join FETCH p.items")
                .getResultList());

        for (Person person : people)
           System.out.println("pidor "+ person.getName() + "has"+ person.getItems());
    }
}
