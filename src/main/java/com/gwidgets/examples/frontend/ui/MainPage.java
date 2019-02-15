package com.gwidgets.examples.frontend.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.http.client.*;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;

public class MainPage extends Composite {
	@UiField
	SpanElement currentUser;

	@UiField
	ButtonElement logoutButton;
	
	private static MainPageUiBinder uiBinder = GWT
			.create(MainPageUiBinder.class);

	interface MainPageUiBinder extends UiBinder<Element, MainPage> {
	}

	public MainPage() {
		setElement(uiBinder.createAndBindUi(this));
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "/user");
		
		try {
			  builder.sendRequest(null, new RequestCallback() {
			    public void onError(Request request, Throwable exception) {
			      
			    }

			    public void onResponseReceived(Request request, Response response) {
			      if (200 == response.getStatusCode()) {
			    	  currentUser.setInnerText(response.getText());
			      } 
			    }
			  });
			} catch (RequestException e) {
			}



        Event.sinkEvents(logoutButton, Event.ONCLICK);
        Event.setEventListener(logoutButton, (e) -> {

            RequestBuilder logoutRequest = new RequestBuilder(RequestBuilder.POST, "/logout");
            String csrfToken = Cookies.getCookie("XSRF-TOKEN");
            logoutRequest.setHeader("X-XSRF-TOKEN", csrfToken);

            try {
                logoutRequest.sendRequest(null, new RequestCallback() {
                    public void onError(Request request, Throwable exception) {

                    }

                    public void onResponseReceived(Request request, Response response) {
                        if (200 == response.getStatusCode()) {
                            Window.Location.replace("/");
                        }
                    }
                });
            } catch (RequestException exception) {
            }
        });
	}
}