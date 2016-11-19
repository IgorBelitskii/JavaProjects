package tel.ran.strings.tests;

import tel.ran.strings.model.StringsJoin;

public class StringsJoinPerfomance {
int arraySize;
int nRuns;
public StringsJoin stringsJoin;

	public StringsJoinPerfomance(int arraySize, int nRuns) {
	this.arraySize = arraySize;
	this.nRuns = nRuns;
}
	public void SetStringsJoin(StringsJoin stringsJoin) {
		this.stringsJoin=stringsJoin;
	}
	public long run() {
		long time0, time1, time=0;
		String[] array = new String[arraySize];
		for (int i = 0; i < arraySize; i++) {
		array[i]="hello";
		}
		stringsJoin.setStrings(array);
		stringsJoin.setDelimeter(" ");
		time0=System.currentTimeMillis();
		for (int i = 0; i < nRuns; i++) {
			stringsJoin.join();
		}
		time1=System.currentTimeMillis();
		time=time1-time0;
		return time;
	}

}
