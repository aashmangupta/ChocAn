package objects;
import java.util.*;

public class ProviderDirectory {
	private Service service = new Service();
	
	ArrayList<Service> services = new ArrayList<Service>(5);
	
	services.add(new Service("Dietitian Session", 598470, 30));
	services.add(new Service("Aerobics Exercise Session", 883948, 20));
	services.add(new Service("", 883948, 20));
	services.add(new Service("", 883948, 20));
	services.add(new Service("", 883948, 20));
	
	public ProviderDirectory() {
	}
	
	/**
	 * 
	 * 
	 * @param
	 * @return void
	 */
	public void email() {
		
	}
	
	int i = 0;
	public Service getService(long code) {
		for(i = 0; i < 5; ++i) {
			if(services.get(i).getCode() == code) {
				return services.get(i);
			}
		}
	}
}
