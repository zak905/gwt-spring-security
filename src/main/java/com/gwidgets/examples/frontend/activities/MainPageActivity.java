package com.gwidgets.examples.frontend.activities;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.gwidgets.examples.frontend.client.ClientFactory;
import com.gwidgets.examples.frontend.ui.MainPage;

public class MainPageActivity extends AbstractActivity  {
	
	MainPage mainPage;
	PlaceController controller;
	Place currentPlace;
	
	public MainPageActivity(ClientFactory factory, Place place) {
		this.mainPage = new MainPage();
		this.controller = factory.getPlaceController();
		this.currentPlace = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus bus) {
		panel.setWidget(mainPage);
	}
}