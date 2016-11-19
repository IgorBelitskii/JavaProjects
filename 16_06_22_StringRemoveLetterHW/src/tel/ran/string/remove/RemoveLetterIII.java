package tel.ran.string.remove;

public class RemoveLetterIII extends RemoveLetter {

	public RemoveLetterIII(String string, char letter) {
		super(string, letter);
		// TODO Auto-generated constructor stub
	}
	public void Run() {
		int len=string.length(), k=0;
		char[] charArray, charArray1= new char[len];
			charArray = string.toCharArray();
			for (int i = 0; i < len; i++) {
				if (charArray[i]!=letter) {
					charArray1[k]=charArray[i];
					k++;
				}
			String strnew = new String(charArray1);
		}
	}
}
