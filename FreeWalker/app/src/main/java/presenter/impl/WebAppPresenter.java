package presenter.impl;

import model.CommonModel;
import model.Impl.WebAppModelImpl;
import model.entity.WebApp;
import presenter.IWebAppPresenter;
import presenter.listen.OnWebAppListener;
import ui.view.IWebAppView;

/**
 * Created by zhangyanye on 2015/8/23
 * Description:
 */
public class WebAppPresenter implements IWebAppPresenter, OnWebAppListener {

    /*Presenter作为中间层，持有View和Model的引用*/
    private IWebAppView webAppView;
    private CommonModel webModel;

    public WebAppPresenter(IWebAppView webAppView) {
        this.webAppView = webAppView;
        webModel = new WebAppModelImpl();
    }
    @Override
    public void getApp(String id) {
        webAppView.showLoading();
        webModel.load(id, this, "test");
    }

    @Override
    public void onSuccess(WebApp webApp) {
        webAppView.hideLoading();
        webAppView.setWebApp(webApp);
    }

    @Override
    public void onError() {
        webAppView.hideLoading();
        webAppView.showError();
    }
}
