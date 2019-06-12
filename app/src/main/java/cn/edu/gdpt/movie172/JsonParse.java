package cn.edu.gdpt.movie172;

import java.lang.reflect.Type;
import java.util.List;

public class JsonParse {
    private static JsonParse instance;
    private JsonParse() {
    }
    public static JsonParse getInstance() {
        if (instance == null) {
            instance = new JsonParse();
        }
        return instance;
    }
    public List<MovieBean> getPythonList(String json){
        Gson gson=new Gson();
        Type ListType=new TypeToken<List<MovieBean>>(){}.getType();
        List<MovieBean> MovieList=gson.fromJson(json,ListType);
        return  MovieList;
    }
}
