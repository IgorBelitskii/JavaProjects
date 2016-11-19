package tel.ran.string.remove;

public class RemoveLetterII extends RemoveLetter {

	public RemoveLetterII(String string, char letter) {
		super(string, letter);
		// TODO Auto-generated constructor stub
	}
	public void Run() {
			string.replace(letter, '\0');
	}
}
