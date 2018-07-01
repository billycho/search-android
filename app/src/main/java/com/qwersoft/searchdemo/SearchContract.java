package com.qwersoft.searchdemo;

import com.qwersoft.searchdemo.Model.MItem;

import java.util.List;

/**
 * Created by IT02106 on 01/07/2018.
 */

public interface SearchContract {
    interface View
    {
        void showSuggestion(List<MItem> mItemList);
    }

    interface Presenter
    {
        void loadSuggestion(String searchText);
    }
}
