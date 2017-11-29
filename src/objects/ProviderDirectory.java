package objects;

import objects.Service;
import java.util.*;

public class ProviderDirectory {
	//private Service service = new Service();
	private ArrayList<Service> services = new ArrayList<Service>();
	
	public ProviderDirectory() {
		services.add(new Service("Dietitian Session", 598470, 30));
		services.add(new Service("Aerobics Exercise Session", 883948, 20));
		services.add(new Service("Shock Therapy Session", 883949, 60));
		services.add(new Service("Hypnosis Session", 883950, 80));
		services.add(new Service("Cardio Exercse Session", 883951, 20));
		services.add(new Service("Error: invalid code", 000000, 0));
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
		for(i = 0; i < 5; ++i) {
			if(services.get(i).getCode() == code) {
				return services.get(i);
			}
		}
		return services.get(5);
	}
}
