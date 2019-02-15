package com.gwidgets.examples.frontend.client;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.gwidgets.examples.frontend.ui.MainPage;


public interface ClientFactory {
     MainPage getMainPageView();
     EventBus getEventBus();
     PlaceController getPlaceController();
}
