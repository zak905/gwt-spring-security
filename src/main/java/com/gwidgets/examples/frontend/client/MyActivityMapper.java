package com.gwidgets.examples.frontend.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.gwidgets.examples.frontend.activities.MainPageActivity;


public class MyActivityMapper implements ActivityMapper {
	
	ClientFactory factory;
	
	MainPageActivity activity;
	
	public MyActivityMapper(ClientFactory factory ){
		this.factory = factory;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if(activity == null){
			
			activity = new MainPageActivity(factory, place);
		}

		return activity;
	}
}
