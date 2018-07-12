package com.niks.hibernateTest.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.niks.hibernateTest.model.Channel;  
import com.niks.hibernateTest.model.Package;  
  
public class HibernateMain {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		Package p = new Package();
		p.setPackageName("Package1");
		
		Package p1 = new Package();
		p1.setPackageName("Package2");
		
	    Channel channel1 = new Channel();    
	    Channel channel2 = new Channel();
	    Channel channel3 = new Channel();
	    Channel channel4 = new Channel();
	    List<Channel> channels = new ArrayList<Channel>();
	    
	    List<Channel> channels2 = new ArrayList<Channel>();
	    
	    
	    channel1.setPckage(p);
	    channel1.setChannelName("First Channel");
	    
	    channel2.setPckage(p);
	    channel2.setChannelName("Second Channel");
	    
	    channel3.setPckage(p1);
	    channel3.setChannelName("Third Channel");
	    channel4.setChannelName("Fourth Channel");
	    
	    
	    channels.add(channel1);
	    channels.add(channel2);
	    channels2.add(channel3);
	    channels2.add(channel4);
	    
	    p1.setChannels(channels);
	    p.setChannels(channels2);
	    
	    try {
		    /*session.save(channel1);
		    session.save(channel2);
		    session.save(channel3);
		    */
		    session.save(p);
		    System.out.println("Saving 2");
		    session.save(p1);
		    
		    t.commit();  
		    System.out.println("successfully saved");    
	    } finally {
	    	factory.close();  
	    	session.close();
	    }
	    double a = 0.1; 
	    double b = 0.1; 
	    double x = a*b; 
	    System.out.println(x);    	
	}

}
