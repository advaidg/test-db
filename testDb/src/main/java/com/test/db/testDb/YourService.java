package com.test.db.testDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class YourService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void batchSaveJdbcTemplate(List<YourEntity> entities, int batchSize) {
        String sql = "INSERT INTO your_table (id, value1, value2, value3, value4, value5, value6, value7, value8, value9, " +
                "value10, value11, value12, value13, value14, value15, value16, value17, value18, value19, value20) " +
                "VALUES (:id, :value1, :value2, :value3, :value4, :value5, :value6, :value7, :value8, :value9, :value10, " +
                ":value11, :value12, :value13, :value14, :value15, :value16, :value17, :value18, :value19, :value20)";

        List<MapSqlParameterSource> params = entities.stream().map(entity -> {
            MapSqlParameterSource param = new MapSqlParameterSource();
            param.addValue("id", entity.getId());
            param.addValue("value1", entity.getValue1());
            param.addValue("value2", entity.getValue2());
            param.addValue("value3", entity.getValue3());
            param.addValue("value4", entity.getValue4());
            param.addValue("value5", entity.getValue5());
            param.addValue("value6", entity.getValue6());
            param.addValue("value7", entity.getValue7());
            param.addValue("value8", entity.getValue8());
            param.addValue("value9", entity.getValue9());
            param.addValue("value10", entity.getValue10());
            param.addValue("value11", entity.getValue11());
            param.addValue("value12", entity.getValue12());
            param.addValue("value13", entity.getValue13());
            param.addValue("value14", entity.getValue14());
            param.addValue("value15", entity.getValue15());
            param.addValue("value16", entity.getValue16());
            param.addValue("value17", entity.getValue17());
            param.addValue("value18", entity.getValue18());
            param.addValue("value19", entity.getValue19());
            param.addValue("value20", entity.getValue20());
            return param;
        }).collect(Collectors.toList());

        int totalBatches = (params.size() + batchSize - 1) / batchSize;
        for (int i = 0; i < totalBatches; i++) {
            int start = i * batchSize;
            int end = Math.min(start + batchSize, params.size());
            List<MapSqlParameterSource> batchParams = params.subList(start, end);
            namedParameterJdbcTemplate.batchUpdate(sql, batchParams.toArray(new MapSqlParameterSource[0]));
        }
    }
}
