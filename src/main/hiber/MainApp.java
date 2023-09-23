package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      userService.add (new User("Макс", "Борис", "Mvboris@mail.com", new Car("VW", 6)));
      userService.add (new User("Светлана", "Молоток", "molotok@mail.ru", new Car("Toyota Camry", 876)));
      userService.add (new User("Сергей", "Иванов", "ivanov@mail.ru", new Car("BMW 3", 345)));
      userService.add (new User("Екатерина", "Петрова", "petrova@mail.ru", new Car("Haval", 7)));
      User vw = userService.getUserByModelAndSeries("BMW 3", 345);
      System.out.println(vw.getFirstName());

      System.out.println("Список пользователей");
      userService.listUsers().forEach(System.out::println);

      context.close();
   }
}

