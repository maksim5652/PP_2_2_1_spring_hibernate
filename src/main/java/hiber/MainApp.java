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


      userService.add (new User("Максим", "Борис", "mvboryx@mail.ru", new Car("VolsWagen", 716)));
      userService.add (new User("Светлана", "Молоток", "molotok@mail.ru", new Car("Toyota Camry", 876)));
      userService.add (new User("Сергей", "Иванов", "ivanov@mail.ru", new Car("BMW 3", 345)));
      userService.add (new User("Екатерина", "Петрова", "petrova@mail.ru", new Car("Haval", 7)));


      List<User> users = userService.listUsers();
      users.forEach(user -> System.out.println(user.toString()));

      System.out.println(userService.getUserByModelAndSeries("VolsWagen",716));

      context.close();
   }
}

