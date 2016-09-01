package com.example.qbclct.expandableview.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by QBCLCT on 9/8/16.
 */
public class TopicModel {
    String id;
    String name;
    @SerializedName("is_selected")
    private Integer isSelected;
    @SerializedName("sub_topics")
    private ArrayList<SubTopicsModel> subTopics;

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

    public ArrayList<SubTopicsModel> getSubTopics() {
        return subTopics;
    }

    public void setSubTopics(ArrayList<SubTopicsModel> subTopics) {
        this.subTopics = subTopics;
    }
}
