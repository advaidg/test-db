package com.test.db.testDb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private YourService yourService;

    @Override
    public void run(String... args) throws Exception {
        List<YourEntity> entities = new ArrayList<>();
        for (int i = 0; i < 150000; i++) {
            YourEntity entity = new YourEntity();
            entity.setId((long) i);
            entity.setValue1("value1_" + i);
            entity.setValue2("value2_" + i);
            entity.setValue3("value3_" + i);
            entity.setValue4("value4_" + i);
            entity.setValue5("value5_" + i);
            entity.setValue6("value6_" + i);
            entity.setValue7("value7_" + i);
            entity.setValue8("value8_" + i);
            entity.setValue9("value9_" + i);
            entity.setValue10("value10_" + i);
            entity.setValue11("value11_" + i);
            entity.setValue12("value12_" + i);
            entity.setValue13("value13_" + i);
            entity.setValue14("value14_" + i);
            entity.setValue15("value15_" + i);
            entity.setValue16("value16_" + i);
            entity.setValue17("value17_" + i);
            entity.setValue18("value18_" + i);
            entity.setValue19("value19_" + i);
            entity.setValue20("value20_" + i);
            entities.add(entity);
        }

        int batchSize = 1000;
        int threadCount = 10;

        // Uncomment one of the following lines to test the different methods:

        // Using Spring Data JPA
        // yourService.parallelBatchSaveJPA(entities, batchSize, threadCount);

        // Using NamedParameterJdbcTemplate
        // yourService.parallelBatchSaveJdbcTemplate(entities, batchSize, threadCount);
    }
}
