package tel_ran.service;

import tel_ran.generation.Generator;
import tel_ran.queues.EmptyQueueException;
import tel_ran.queues.LimitedQueue;
import tel_ran.queues.OutOfLimitException;

public class Controller {
	public static int probability=60, minDuration=50, maxDuration=100, END_TIME=100000, LIMIT=100, rejected, executed,sumTime;
	public static void main(String[] args) {
		Task t;
		int wtime=0, iddletime=0;
		Generator generator = new Generator(minDuration,maxDuration,probability);
		Service service = new Service();
		LimitedQueue<Task> queue = new LimitedQueue<Task>(LIMIT);
		for (int i = 0; i < END_TIME; i++) {
			try {
				t=generator.generate(i);
				if (t!=null)  { 
					queue.add(t);	
				}		
			} catch (OutOfLimitException e) {
				// TODO Auto-generated catch block
				rejected++;
			}
			t = service.takeTask(i);
			if (t!=null) {
				sumTime+=t.getStartTime()-t.getEnterTime(); 
				executed+=1;

				}
			if (service.isEmpty()) {
				try {
					service.addTask(queue.offer(), i);
				} catch (EmptyQueueException e) {
					// TODO Auto-generated catch block
					iddletime+=1;
				}
			}
				
			
			}
		System.out.println(probability+" min "+ minDuration+"max: "+maxDuration+"endtime "+END_TIME+" lim:"+ LIMIT+" rej:"+ rejected+" exec:"+ executed+" sumtime:"+sumTime);
			// //prints waiting time=sumtime/exec, idle time, number of the rejected tasks
		System.out.println("Sumtime/executed time= "+sumTime/executed+", idle time: "+iddletime+", rejected tasks: "+rejected);
		}
	}

