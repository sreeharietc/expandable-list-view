package com.example.qbclct.expandableview.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by QBCLCT on 9/8/16.
 */
public class SubTopicsModel {

    String id;
    String name;
    @SerializedName("is_selected")
    private Integer isSelected;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Integer isSelected) {
        this.isSelected = isSelected;
    }
}
