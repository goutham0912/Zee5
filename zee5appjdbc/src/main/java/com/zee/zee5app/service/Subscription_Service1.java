package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.exception.NameNotFound;

public interface Subscription_Service1 {
	public String addSubscription(Subscriptions s);
	public String deleteSubscription(String id) throws NameNotFound;
	public Optional<Subscriptions> getSubscription(String id) throws NameNotFound;
	public Optional<ArrayList<Subscriptions>> getallSubscription();
	public String updatesubscription(String id,Subscriptions s) throws NameNotFound;
}
