package views.impl;

import views.MVPView;

/**
 * Created by zhangyanye on 2015/8/23
 * Description:获取String时，定义的行为
 */
public interface StringView extends MVPView {

    void showString(String result);

    void showLoding();

    void hideLoding();

}
