package model.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by zhangyanye on 2015/8/28
 * Description:
 */
public class BaseEntity {
    protected static Gson gson = new GsonBuilder()
            .serializeNulls()
            .disableHtmlEscaping()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public String toJsonString() {
        return gson.toJson(this);
    }
}
