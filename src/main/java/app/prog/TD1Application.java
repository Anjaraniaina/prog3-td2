package app.prog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;

@SpringBootApplication
public class TD1Application {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        SpringApplication.run(TD1Application.class, args);
        // Class c = Class.forName("app.prog.model.Player");
        // c.getName();
        // Field f = c.getDeclaredField("name");
        // f.set(String.class, "hey");
    }
}
