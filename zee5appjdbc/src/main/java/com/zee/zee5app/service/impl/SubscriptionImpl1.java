package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.repository.SubscriptionInterface;
import com.zee.zee5app.repository.impl.SubscriptionImpl;
import com.zee.zee5app.service.impl.SubscriptionImpl1;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.service.Subscription_Service1;
@Service
public class SubscriptionImpl1 implements Subscription_Service1 {
	SubscriptionInterface service1=null;
	private static Subscription_Service1 service;
	public SubscriptionImpl1() throws IOException
	{
		
	}
//	public static Subscription_Service1 getInstance() throws IOException
//	{
//		if(service==null)
//		{
//			service=new SubscriptionImpl1();
//			return service;
//		}
//		return service;
//	}
	@Override
	public String addSubscription(Subscriptions s) {
		// TODO Auto-generated method stub
		return service1.addSubscription(s);
	}

	@Override
	public String deleteSubscription(String id) throws NameNotFound {
		// TODO Auto-generated method stub
		return service1.deleteSubscription(id);
	}

	@Override
	public Optional<Subscriptions> getSubscription(String id) throws NameNotFound {
		// TODO Auto-generated method stub
		return service1.getSubscription(id);
	}

	@Override
	public Optional<ArrayList<Subscriptions>> getallSubscription() {
		// TODO Auto-generated method stub
		return service1.getallSubscription();
	}

	@Override
	public String updatesubscription(String id, Subscriptions s) throws NameNotFound {
		// TODO Auto-generated method stub
		return service1.updatesubscription(id, s);
	}

}
