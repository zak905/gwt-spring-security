package com.gwidgets.examples.frontend.client;



import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.gwidgets.examples.frontend.places.ContactPlace;
import com.gwidgets.examples.frontend.places.HomePlace;
import com.gwidgets.examples.frontend.places.UsersPlace;


@WithTokenizers({ContactPlace.Tokenizer.class, HomePlace.Tokenizer.class, UsersPlace.Tokenizer.class})
public interface MyHistoryMapper extends PlaceHistoryMapper  {

}

