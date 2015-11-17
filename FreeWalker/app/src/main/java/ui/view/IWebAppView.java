package ui.view;

import model.entity.WebApp;

/**
 * Created by zhangyanye on 2015/8/23
 * Description:
 */
public interface IWebAppView {
    void showLoading();

    void hideLoading();

    void showError();

    void setWebApp(WebApp webApp);
}
