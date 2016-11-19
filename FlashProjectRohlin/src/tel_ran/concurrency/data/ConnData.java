package tel_ran.concurrency.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConnData {
		int id;
		Date startDate;
		Date finishDate;
		private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:SSS");
		
		public ConnData(int id, Date startDate) {
			super();
			this.id = id;
			this.startDate = startDate;
		}
		public Date getFinishDate() {
			return finishDate;
		}
		public void setFinishDate(Date finishDate) {
			this.finishDate = finishDate;
		}
		public Date getStartDate() {
			return startDate;
		}
		public int getId() {
			return id;
		}
		@Override
		public String toString() {
			return "ConnData [id=" + id + ", startDate=" + format.format(startDate) + ", finishDate=" + (finishDate == null?"undefined":format.format(finishDate)) + "]";
		}
		
		
}
