package tel.ran.string.perfomance;

import tel.ran.string.remove.RemoveLetter;


public class RemovePerfomance {
int stringSize;
int nRuns;
public RemoveLetter removeLetter;

	public RemovePerfomance(int stringSize, int nRuns) {
	this.stringSize = stringSize;
	this.nRuns = nRuns;
}
	public void SetRemoveLetter(RemoveLetter removeLetter) {
		this.removeLetter=removeLetter;
	}
	public long run() {
		long time0, time1, time=0;
		String str = new String();
		for (int i = 0; i < stringSize; i++) {
		str+="z+";
		}
		removeLetter.setString(str);
		removeLetter.setLetter("+".charAt(0));
		time0=System.currentTimeMillis();
		for (int i = 0; i < nRuns; i++) {
			removeLetter.Run();
		}
		time1=System.currentTimeMillis();
		time=time1-time0;
		return time;
	}

}
