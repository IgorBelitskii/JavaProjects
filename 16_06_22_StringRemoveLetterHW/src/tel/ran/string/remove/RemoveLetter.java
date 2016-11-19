package tel.ran.string.remove;

public abstract class RemoveLetter {

	String string;
	char letter;
	public RemoveLetter(String string, char letter) {
		this.string = string;
		this.letter = letter;
	}
	public void setString(String string) {
		this.string = string;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	public String getString() {
		return string;
	}
	public void Run() {
	}

}
