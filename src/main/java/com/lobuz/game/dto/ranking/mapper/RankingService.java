package com.lobuz.game.dto.ranking.mapper;

import com.lobuz.game.config.GameProperties;
import com.lobuz.game.dto.ranking.model.RankingModel;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class RankingService {


    private final RankingMapper rankingMapper;
    private final GameProperties properties;

    public RankingService(RankingMapper rankingMapper, GameProperties properties) {
        this.rankingMapper = rankingMapper;
        this.properties = properties;
    }

    public List<RankingModel> getRanking() {

        System.out.println(Arrays.asList(rankingMapper.fromFile(properties.getRankingPath(), RankingModel[].class)).get(0));
        return Arrays.asList(rankingMapper.fromFile(properties.getRankingPath(), RankingModel[].class));
    }

    public void saveRecord(String name, int points) {

        log.info("save to json file: " + name + " : "+ points);
        JSONObject record = new JSONObject();
        record.put("name", name);
        record.put("points", points);

        JSONArray recordList = new JSONArray();
        recordList.add(record);

        try (FileWriter fileWriter = new FileWriter(properties.getRankingPath())) {
            fileWriter.write(recordList.toJSONString());
            fileWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
