package com.unifun;


import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@NoArgsConstructor
public class Json {
    public Json(Vector vector){
        JSONObject obj = new JSONObject();
        Map<String,Integer> map = new HashMap<>();
        map.put("xo",vector.getOx());
        map.put("yo",vector.getOy());
        map.put("x",vector.getX());
        map.put("y",vector.getY());

        obj.put("Vector", map);
        try (FileWriter file = new FileWriter("newfile.json")) {
            file.write(obj.toJSONString());
            file.flush();

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
