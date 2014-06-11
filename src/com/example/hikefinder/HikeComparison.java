package com.example.hikefinder;

import java.util.Comparator;

public class HikeComparison implements Comparator<Hike>{
	@Override
    public int compare(Hike hike1, Hike hike2) {
        return hike2.getRating() - hike1.getRating();
    }
}


