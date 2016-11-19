package tel_ran.service;

import tel_ran.generation.Generator;
import tel_ran.queues.EmptyQueueException;
import tel_ran.queues.LimitedQueue;
import tel_ran.queues.OutOfLimitException;

public class Controller {
	public static int probability=75, minDuration=10, maxDuration=150, END_TIME=10000, LIMIT=1000, N_TASKS=10;
	public static void main(String[] args) {
		Task[] arrT;
		Task t;
		int iddletime=0,rejected=0, executed=0,sumTime=0;
		Generator generator = new Generator(minDuration,maxDuration,probability);
		Service service = new Service(N_TASKS);
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
			arrT = service.takeTask(i);
			try{
			if (arrT.length>0) {
				for (int j = 0; j < arrT.length; j++) {
						sumTime+=arrT[j].getStartTime()-arrT[j].getEnterTime(); 
						executed+=1;
				}
			}
			} catch (NullPointerException e) {}
			
			if (service.isEmpty()) {
				try {
					service.addTask(queue.offer(), i);
				} catch (EmptyQueueException e) {
					// TODO Auto-generated catch block
					
				}
				iddletime+=1;
			}
				
			
			}
	//	System.out.println(probability+" min "+ minDuration+"max: "+maxDuration+"endtime "+END_TIME+" lim:"+ LIMIT+" rej:"+ rejected+" exec:"+ executed+" sumtime:"+sumTime);
		// //prints waiting time=sumtime/exec, idle time, number of the rejected tasks
		System.out.println("Sumtime/executed= "+sumTime/executed+", idle time: "+iddletime+", rejected tasks: "+rejected);	//take task service // опредл время ожидания если взяли задачув

		}
	}

