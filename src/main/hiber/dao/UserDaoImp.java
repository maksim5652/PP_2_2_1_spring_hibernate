package hiber.dao;


import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   @Autowired
   public UserDaoImp (SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }


   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User", User.class);
      return query.getResultList();
   }


   @Override
   public User getUserByModelAndSeries(String model, int series) {
      String query = "from User user where user.car.model = :model and user.car.series = :series";
      TypedQuery<User> typedQuery = sessionFactory.getCurrentSession().createQuery(query, User.class);
      typedQuery.setParameter("model", model).setParameter("series", series);
      return typedQuery.getSingleResult();
   }
}