package model;

import presenter.listen.OnWebAppListener;

/**
 * Created by zhangyanye on 2015/8/23
 * Description:
 */
public interface CommonModel {
    void load(String id, OnWebAppListener listener,String tag);
}
