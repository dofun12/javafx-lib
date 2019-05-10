package org.lemanoman.javafx;

import java.util.HashMap;
import java.util.Map;

public class Parameters {
    private Map<String,Object> parameters;
    public Parameters(){
        parameters = new HashMap<String, Object>();
    }
    public void add(String key,Object object){
        parameters.put(key,object);
    }

    public Object get(String key){
        return parameters.get(key);
    }

    public <T> T get(String key,Class<T> type){
        return (T)parameters.get(key);
    }
}
