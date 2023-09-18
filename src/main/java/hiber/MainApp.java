package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("VolsWagen", 716);
      Car car2 = new Car("Toyota Camry", 876);
      Car car3 = new Car("BMW 3", 345);
      Car car4 = new Car("Haval", 7);

      User user1 = new User("Максим", "Борис", "mvboryx@mail.ru");
      User user2 = new User("Светлана", "Молоток", "molotok@mail.ru");
      User user3 = new User("Сергей", "Иванов", "ivanov@mail.ru");
      User user4 = new User("Екатерина", "Петрова", "petrova@mail.ru");
      user1.setCar(car4);
      user2.setCar(car2);
      user3.setCar(car1);
      user4.setCar(car3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
      }

      userService.getUserByModelAndSeries("VolsWagen", 716);
      userService.getUserByModelAndSeries("Haval", 7);
      userService.getUserByModelAndSeries("BMW 3", 345);
      userService.getUserByModelAndSeries("VW", 567);

      context.close();

   }
}

