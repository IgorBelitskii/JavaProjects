package tel_ran.networking.management;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tel_ran.networking.management.elements.Router;

/**
 * Routers � list<router>
Int interval
Boolean monitoring
Boolean Method addRouter(router Router)
Boolean Method removeRouter(String routername)
+activate method()

 * @author Igor
 *
 */
public class RoutersMonitoring {
	private Set<Router> routers=new HashSet<>();
	private int interval;
	private boolean monitoring;
	
	public void activate(){
		while(monitoring) {
			synchronized (routers) {
				for (Router router : routers) {
					System.out.println(router);
				}
			}
			try {
				Thread.sleep(interval*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean addRouter(String name, int nInterfaces) {
		synchronized (routers) {
			return routers.add(new Router(name, nInterfaces));
		}
		
	}
	
	public boolean removeRouter(String name) {
		synchronized (routers) {
			Router router = new Router(name, 0);
			return routers.remove(router);
		}
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public boolean isMonitoring() {
		return monitoring;
	}

	public void setMonitoring(boolean monitoring) {
		this.monitoring = monitoring;
	}
}
