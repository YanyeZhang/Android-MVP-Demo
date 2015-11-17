package presenter.listen;

import model.entity.WebApp;

public interface OnWebAppListener {
    /**
     * 成功时回调
     *
     * @param webApp
     */
    void onSuccess(WebApp webApp);
    /**
     * 失败时回调，简单处理，没做什么
     */
    void onError();
}