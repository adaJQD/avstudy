package com.adajqd.audiodemo.base;

/**
 * @author jqd
 * @date 2018/3/8
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void startRecord();

    void stopRecord();

    void playRecord();

}
