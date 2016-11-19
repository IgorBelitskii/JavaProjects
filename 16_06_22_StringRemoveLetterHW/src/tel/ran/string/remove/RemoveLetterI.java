package tel.ran.string.remove;

public class RemoveLetterI extends RemoveLetter {

	public RemoveLetterI(String string, char letter) {
		super(string, letter);
		// TODO Auto-generated constructor stub
	}
	public void Run() {
		String str1="";
		int len=string.length();
			for (int i = 0; i < len; i++) {
				if (string.charAt(i)!=letter) {
				str1=str1+string.charAt(i);
				}
			}		

	}
}
