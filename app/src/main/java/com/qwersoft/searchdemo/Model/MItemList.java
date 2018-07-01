package com.qwersoft.searchdemo.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by IT02106 on 01/07/2018.
 */

public class MItemList {
    @SerializedName("items")
    private List<MItem> mItems;



    @SerializedName("total_count")
    public int totalCount;

    public List<MItem> getMItems()
    {
        return mItems;
    }

    public void setmItems(List<MItem> mItems)
    {
        this.mItems = mItems;
    }

    public MItemList(List<MItem> mItems)
    {
        this.mItems = mItems;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int total_count) {
        this.totalCount = total_count;
    }
}
