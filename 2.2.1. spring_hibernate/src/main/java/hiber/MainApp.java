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

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        User myUser1 = new User("Ivan", "Ivanov", "Ivanov@gmail");
        Car car1 = new Car("BMV", 17, myUser1);
        myUser1.setCar(car1);

        User myUser2 = new User("Masha", "Mashina", "Mashina@mail");
        Car car2 = new Car("Lada", 14, myUser2);
        myUser2.setCar(car2);

        User myUser3 = new User("Vladimir", "Mosin", "Mosin@gmail");
        Car car3 = new Car("Audi", 777, myUser3);
        myUser3.setCar(car3);

        User myUser4 = new User("Larisa", "Ivanova", "Ivanova@gmail");
        Car car4 = new Car("BMV", 78, myUser4);
        myUser4.setCar(car4);

        userService.add(myUser1);
        userService.add(myUser2);
        userService.add(myUser3);
        userService.add(myUser4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
        }

        System.out.println(userService.getOwnersCar("Lada", 14));


        context.close();
    }
}
