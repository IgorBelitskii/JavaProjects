package tel_ran.tag.entities;

public class Settings {
int K=10;
int L=60;
int M=30;
public Settings() {
	super();
	// TODO Auto-generated constructor stub
}
public int getK() {
	return K;
}
public void setK(int k) {
	K = k;
}
public int getL() {
	return L;
}
public void setL(int l) {
	L = l;
}
public int getM() {
	return M;
}
public void setM(int m) {
	M = m;
}
public Settings(int k, int l, int m) {
	super();
	K = k;
	L = l;
	M = m;
}

}
