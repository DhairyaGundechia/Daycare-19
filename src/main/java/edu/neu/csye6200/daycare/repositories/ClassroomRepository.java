package edu.neu.csye6200.daycare.repositories;

import edu.neu.csye6200.daycare.model.ClassSections;
import org.hibernate.Session;

public class ClassroomRepository {

    private final Session session = EntityManagerUtil.getSession();

    public ClassSections findTopByMinAgeBeforeAndMaxAgeAfterOrderByClassRoomId(int age1, int age2) {
        session.beginTransaction();

        ClassSections result = session.createQuery("SELECT c FROM classrooms c WHERE c.minAge < :age2 AND c.maxAge > :age1 ORDER BY c.classRoomId", ClassSections.class)
                .setParameter("age1", age1)
                .setParameter("age2", age2)
                .setMaxResults(1)
                .getSingleResult();

        session.getTransaction().commit();
        return result;
    }

    public ClassSections findTopByStudentIdsContaining(String studentId) {
        session.beginTransaction();

        ClassSections result = session.createQuery("SELECT c FROM classrooms c WHERE :studentId MEMBER OF c.studentIds", ClassSections.class)
                .setParameter("studentId", studentId)
                .setMaxResults(1)
                .getSingleResult();

        session.getTransaction().commit();
        return result;
    }

    // Add other methods as needed


    public void save(ClassSections classSections) {
        session.beginTransaction();
        session.persist(classSections);
        session.getTransaction().commit();
    }
}
