package com.test.myapplication.model;

import com.test.myapplication.model.Batter;

import java.util.ArrayList;
import java.util.List;

public class Batters {
    private List<Batter> batter = new ArrayList<Batter>();
    public List<Batter> getBatter() {
        return batter;
    }
    public void setBatter(List<Batter> batter) {
        this.batter = batter;
    }
}
