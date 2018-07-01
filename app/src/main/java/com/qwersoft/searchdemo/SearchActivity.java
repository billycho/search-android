package com.qwersoft.searchdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import com.qwersoft.searchdemo.Model.MItem;
import com.qwersoft.searchdemo.Model.MItemAdapter;
import com.qwersoft.searchdemo.Model.MItemList;
import com.qwersoft.searchdemo.R;
import com.qwersoft.searchdemo.rest.ApiClient;
import com.qwersoft.searchdemo.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, SearchContract.View {

    @BindView(R.id.listview)
    ListView listView;

    @BindView(R.id.searchView)
    SearchView searchView;

    MItemAdapter mItemAdapter;

    SearchPresenter searchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view = getSupportActionBar().getCustomView();

        ButterKnife.bind(this);

        searchPresenter = new SearchPresenter(this);

        searchView.setOnQueryTextListener(this);

        mItemAdapter = new MItemAdapter(this,R.layout.custom_row, new ArrayList<MItem>());
        listView.setAdapter(mItemAdapter);



    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        if(s.length()>0)
        searchPresenter.loadSuggestion(s);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        //if(s.length()>0)
        //searchPresenter.loadSuggestion(s);

        return false;
    }

    @Override
    public void showSuggestion(List<MItem> mItemList) {
        mItemAdapter.populateData(mItemList);
    }
}
