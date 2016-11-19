package tel_ran.service;

public class Service {
	
	Task task;

	public boolean isEmpty(){
		
		return !(this.task!=null);
	}
	
	public Task takeTask(int time) {
		if (task==null) return null;
		if ((task.startTime+task.duration)<=time) {
			Task newTask = this.task;
			newTask.setInService(false);
			this.task=null; // возвращаем задачу и устанавливаем ноль
			return newTask;
		}
		
		return null;
		
	}
	
	public boolean addTask(Task task, int time) {
		if (!isEmpty()) return false;
		this.task=task;
		this.task.setStartTime(time);
		this.task.setInService(true);
		return true;
	}
}
