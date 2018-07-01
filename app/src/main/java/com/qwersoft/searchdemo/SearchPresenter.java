package com.qwersoft.searchdemo;

import android.content.Context;
import android.util.Log;

import com.qwersoft.searchdemo.Model.MItem;
import com.qwersoft.searchdemo.Model.MItemList;
import com.qwersoft.searchdemo.rest.ApiClient;
import com.qwersoft.searchdemo.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by IT02106 on 01/07/2018.
 */

public class SearchPresenter implements SearchContract.Presenter{
    private final SearchContract.View searchView;
    Context mContext;

    public SearchPresenter(SearchContract.View searchView)
    {
        this.searchView = searchView;
    }

    public void loadSuggestion(final String searchText) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MItemList> call = apiService.getMItems(searchText+"+in:login");
        call.enqueue(new Callback<MItemList>() {


            @Override
            public void onResponse(Call<MItemList> call, Response<MItemList> response) {
                if(response.isSuccessful())
                {
                    if(response.body().getTotalCount() == 0)
                    {
                        Log.d("asdaxxx","Data not found");
                        List<MItem> mItems = new ArrayList<MItem>();
                        mItems.add(new MItem("Data not found","http://wfarm2.dataknet.com/static/resources/icons/set114/b4f29385.png"));
                        searchView.showSuggestion(mItems);
                    }
                    else
                    {
                        List<MItem> mItems = response.body().getMItems();
                        searchView.showSuggestion(mItems);

                    }

//                    //logging
//                    for(int i = 0;i<mItems.size();i++)
//                    {
//                        Log.d("asdaxxx",mItems.get(i).login);
//                    }
                }
                else
                {
                    Log.d("asdaxxx","failed");
                    List<MItem> mItems = new ArrayList<MItem>();
                    mItems.add(new MItem("API limit reachedbillyc","http://wfarm2.dataknet.com/static/resources/icons/set114/b4f29385.png"));
                    searchView.showSuggestion(mItems);
                }
            }

            @Override
            public void onFailure(Call<MItemList> call, Throwable t) {

            }
        });


    }
}
