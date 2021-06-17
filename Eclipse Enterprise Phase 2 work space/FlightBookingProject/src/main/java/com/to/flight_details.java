package com.to;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;

@Entity
@Table(name="flight_details")
public class flight_details {
	
	@Column(name="flight_id",nullable=false)
	@Id
	private String flight_id;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="fk_flight_id",foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (fk_flight_id) REFERENCES flight_details(flight_id) ON UPDATE CASCADE ON DELETE CASCADE")),
	inverseJoinColumns = @JoinColumn(name="fk_airline_id",foreignKey = @ForeignKey(foreignKeyDefinition = "FOREIGN KEY (fk_airline_id) REFERENCES airlines_list(airline_id) ON UPDATE CASCADE ON DELETE CASCADE"))
)
	private List<airlines_list> airline;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<source_list> source;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<destination_list> destination;
	
	@Column(nullable=false)
	private Date flight_date;
	
	@Column(nullable=false)
	private Date flight_departure_time;
	
	@Column(nullable=false)
	private Date flight_arrival_time;
	
	@Column(nullable=false)
	private int flight_price;

	
	public flight_details() {
		super();
		
	}


	
	
	
	public static void main(String[] args)
	{
		System.out.println("main begins");
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionfactory=cfg.buildSessionFactory();
		Session session=sessionfactory.openSession();
		System.out.println("Session Opened");
		session.beginTransaction();
		System.out.println("Transaction begin");
		
		airlines_list airline1=new airlines_list("airlineid1", "Indigo Airlines");
		airlines_list airline2=new airlines_list("airlineid2", "SpiceJet Airlines");
		airlines_list airline3=new airlines_list("airlineid3", "AirAsia Airlines");
		airlines_list airline4=new airlines_list("airlineid4", "JetBlue Airlines");
		System.out.println("airline_list object created "+airline1+airline2+airline3+airline4);
		source_list source1=new source_list("sourceid1", "Mumbai");
		source_list source2=new source_list("sourceid2", "Delhi");
		source_list source3=new source_list("sourceid3", "Kolkata");
		source_list source4=new source_list("sourceid4", "Chennai");
		System.out.println("source_list object created "+source1+source2+source3+source4);
		destination_list destination1=new destination_list("destinationid1", "delhi");
		destination_list destination2=new destination_list("destinationid2", "mumbai");
		destination_list destination3=new destination_list("destinationid3", "kolkata");
		destination_list destination4=new destination_list("destinationid4", "chennai");
		System.out.println("destination_list object created "+destination1+destination2+destination3+destination4);
		//@SuppressWarnings("deprecation")
		//flight_details f1=new flight_details("id1",airline1,source1,destination1,new Date(2021, 07, 03),new Date(2021,07,03,9,30,00),new Date(2021,07,03,11,00,00),5000);
		//System.out.println("flight_details object created "+f1);
		
 	    session.save(source1);session.save(source2);session.save(source3);session.save(source4);
		session.save(destination1);session.save(destination2);session.save(destination3);session.save(destination4);
		session.save(airline1);session.save(airline2);session.save(airline3);session.save(airline4);	
		//session.save(f1);
		//System.out.println("Saved f1 object "+f1);
		

		session.getTransaction().commit();
		System.out.println("transaction commited");
		session.close();
		System.out.println("session closed");
	
	}

	
	
	
}