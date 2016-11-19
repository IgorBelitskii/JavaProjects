package tel_ran.service;

public class Service {
	Task[] arrTasks;

	public Service(int number) {
		this.arrTasks = new Task[number];
	}

	public boolean isEmpty(){
		try{
		for (int i = 0; i < arrTasks.length; i++) {
			if (arrTasks[i]==null) return true;
		}
		} catch (NullPointerException e) { return true;}
		return false;
	}
	
	public Task[] takeTask(int time) {
		int finished=0,k=0;
		Task returned[];
		try {
		for (int i = 0; i < arrTasks.length; i++) {
		if (arrTasks[i]!=null) { 
			if ((arrTasks[i].startTime+arrTasks[i].duration)<=time) finished++;
			}
		}	
		} catch (NullPointerException e) {}
		if (finished>0) {
			returned = new Task[finished]; 
			for (int i = 0; i < arrTasks.length; i++) {
				if (arrTasks[i]!=null) { 
					if ((arrTasks[i].startTime+arrTasks[i].duration)<=time) {
						returned[k] = arrTasks[i];
						returned[k++].setInService(false);
						arrTasks[i]=null; //
					}
				}	
			}
			return returned;
		}
		return null;
	}
		
	
	public boolean addTask(Task task, int time) {
	//	if (!isEmpty()) return false;
		
		for (int i = 0; i < arrTasks.length; i++) {
			if (arrTasks[i]==null) {
				arrTasks[i]=task;
				arrTasks[i].setStartTime(time);
				arrTasks[i].setInService(true);
				return true;
			}
		}
		return false;
	}
}
