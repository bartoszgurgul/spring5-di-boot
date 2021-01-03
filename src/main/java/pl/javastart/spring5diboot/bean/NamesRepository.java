package pl.javastart.spring5diboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.javastart.spring5diboot.config.DatabaseDatasource;


import java.util.List;

@Component
public class NamesRepository {

    private DatabaseDatasource databaseDatasource;

    @Autowired
    public NamesRepository(DatabaseDatasource databaseDatasource){
        this.databaseDatasource = databaseDatasource;
    }

    public List<String> getAll(){
        return databaseDatasource.getDatabase();
    }
}
