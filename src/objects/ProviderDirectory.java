package objects;

import objects.Service;
import java.util.*;

public class ProviderDirectory {
	//private Service service = new Service();
	private ArrayList<Service> services = new ArrayList<Service>();	//makes service ArrayList
	
	public ProviderDirectory() {
		services.add(new Service("Dietitian Session", 598470, 30));			//populates ArrayList
		services.add(new Service("Aerobics Exercise Session", 883948, 20));	//populates ArrayList
		services.add(new Service("Shock Therapy Session", 883949, 60));		//populates ArrayList
		services.add(new Service("Hypnosis Session", 883950, 80));			//populates ArrayList
		services.add(new Service("Cardio Exercse Session", 883951, 20));		//populates ArrayList
		services.add(new Service("Error: invalid code", 000000, 0));			//populates ArrayList
	}
	
	/**
	 * 
	 * 
	 * @param
	 * @return void
	 */
	public void email() {
		
	}
	
	/**
	 * This method finds a specific service in the service directory using its
	 * 	code then returns it.
	 * 
	 * @param code
	 * @return Service
	 */
	int i = 0;
	public Service getService(long code) {
		for(i = 0; i < 5; ++i) {						//loops through service directory
			if(services.get(i).getCode() == code) {	//if service code is the code being searched for
				return services.get(i);				//return service
			}
		}
		return services.get(5);						//service not found, return error service
	}
}
