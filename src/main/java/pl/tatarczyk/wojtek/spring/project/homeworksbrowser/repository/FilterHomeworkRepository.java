package pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository;

import org.springframework.stereotype.Repository;
import pl.tatarczyk.wojtek.spring.project.homeworksbrowser.repository.entity.HomeworkEntity;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class FilterHomeworkRepository {
    private static final Logger LOGGER = Logger.getLogger(FilterHomeworkRepository.class.getName());

    private final EntityManager entityManager;

    public FilterHomeworkRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void filter(String title) {
        LOGGER.info("filter(" + title + ")");

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<HomeworkEntity> criteriaQuery = criteriaBuilder.createQuery(HomeworkEntity.class);
        Root<HomeworkEntity> entityRoot = criteriaQuery.from(HomeworkEntity.class);

        Predicate titlePredicate = criteriaBuilder.equal(entityRoot.get("title"), title);

        criteriaQuery.where(criteriaBuilder.and(titlePredicate));
        List<HomeworkEntity> homeworkEntities = entityManager.createQuery(criteriaQuery.select(entityRoot)).getResultList();

        LOGGER.info("filter(...) = " + homeworkEntities);

//        LocalDate today = new LocalDate();
//
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
//        Root<Customer> root = query.from(Customer.class);
//
//        Predicate hasBirthday = builder.equal(root.get(Customer_.birthday), today);
//        Predicate isLongTermCustomer = builder.lessThan(root.get(Customer_.createdAt), today.minusYears(2);
//        query.where(builder.and(hasBirthday, isLongTermCustomer));
//        em.createQuery(query.select(root)).getResultList();
    }
}
