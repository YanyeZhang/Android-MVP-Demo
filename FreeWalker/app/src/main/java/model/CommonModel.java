package model;

import presenters.listen.OnStringListener;

/**
 * Created by zhangyanye on 2015/8/23
 * Description:
 */
public interface CommonModel {
    void load(String url,OnStringListener listener);

    void load(String url);
}
