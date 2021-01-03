package pl.javastart.spring5diboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.javastart.spring5diboot.config.profiles.DevProfile;
import pl.javastart.spring5diboot.config.profiles.ProdProfile;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    @Profile("default")
    public DatabaseDatasource getDefaultDatasource(){
        return (() -> Arrays.asList("KasiaDefault","BartekDefault"));
    }

    @Bean
    @DevProfile
    public DatabaseDatasource getH2Datasource(){
        return (() -> Arrays.asList("KasiaTest","BartekTest","AniaTest","KrzysztofTest"));
    }

    @Bean
    @ProdProfile
    public DatabaseDatasource getMySqlDatasource(){
        return new DatabaseDatasource() {
            @Override
            public List<String> getDatabase() {
                try{
                    Path path = new File(getClass().getResource("/data.txt").toURI()).toPath();
                    List<String> allLine = Files.readAllLines(path);
                    return allLine;
                } catch (IOException | URISyntaxException error){
                    error.printStackTrace();
                }
                return new ArrayList<>();
            }
        };
    }

}
