package com.zee.zee5app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.service.Subscription_Service1;
import com.zee.zee5app.service.impl.MoviesImpl1;
import com.zee.zee5app.service.impl.SubscriptionImpl1;

public class Subscription_Main {
public static void main(String[] args) {
	Subscriptions s=new Subscriptions("s000006","2021-08-10","2022-08-10",6000,"CREDIT","ACTIVE","YEARLY","True","goutham1");
	Subscription_Service1 service=null;
	try {
		service=SubscriptionImpl1.getInstance();
		String result=service.addSubscription(s);
		
		System.out.println(result);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//get movie details
	try {
		service=SubscriptionImpl1.getInstance();
		Optional<Subscriptions> result=service.getSubscription("s000005");
		if(result.isPresent())
		{
			System.out.println(result.get());
		}
		else {
			System.out.println("Subscription Not found");
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NameNotFound e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		service=SubscriptionImpl1.getInstance();
		Optional<ArrayList<Subscriptions>> result1=service.getallSubscription();
		if(result1.isPresent())
		{
			result1.get().forEach(e->System.out.println(e));
		}
		
		else {
			System.out.println("Subscription Not found");
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	//delete a movie
	try {
		service=SubscriptionImpl1.getInstance();
		String result=service.deleteSubscription("s000006");
		
		System.out.println(result);
		
	} catch (IOException | NameNotFound e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
}
}
}
