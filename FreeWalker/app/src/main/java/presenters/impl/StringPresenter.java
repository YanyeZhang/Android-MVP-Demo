package presenters.impl;

import com.android.volley.VolleyError;

import de.greenrobot.event.EventBus;
import event.StringEvent;
import model.CommonModel;
import model.Impl.StringModleImpl;
import presenters.StringModlePresenter;
import presenters.listen.OnStringListener;
import views.impl.StringView;

/**
 * Created by zhangyanye on 2015/11/19
 * Description:Presenter作为中间层，持有View和Model的引用
 */
public class StringPresenter implements StringModlePresenter, OnStringListener {

    private StringView stringView;
    private CommonModel commonModel;

    public StringPresenter(StringView stringView) {
        this.stringView = stringView;
        commonModel = new StringModleImpl();
      //  EventBus.getDefault().register(this);

    }

    @Override
    public void setUrl(String url) {
        stringView.showLoding();
        commonModel.load(url, this);
       // commonModel.load(url);
    }

    //modle 回调
    @Override
    public void onSuccess(String result) {
        stringView.hideLoding();
        stringView.showString(result);
    }
    //modle 回调
    @Override
    public void onError(VolleyError error) {
        stringView.showString(error.getMessage());
        stringView.hideLoding();
    }

    /**
     * 不用用OnStringlisten 也可以用回调的方式
     *
     * @param event
     */
    public void onEventMainThread(StringEvent event) {
        stringView.hideLoding();
        stringView.showString(event.result);
        EventBus.getDefault().unregister(this);
    }
}
