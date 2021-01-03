package pl.javastart.spring5diboot;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.spring5diboot.bean.NamesRepository;

import java.util.List;

@SpringBootApplication
public class Spring5DiBootApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(Spring5DiBootApplication.class, args);

        NamesRepository namesRepository = context.getBean(NamesRepository.class);
        List<String> all = namesRepository.getAll();
        all.forEach(System.out::println);

        context.close();
    }

}
