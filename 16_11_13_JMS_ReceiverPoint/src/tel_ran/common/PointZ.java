package tel_ran.common;

public class PointZ extends Point {
int z;

public int getZ() {
	return z;
}

public PointZ(int z) {
	super();
	this.z = z;
}

public PointZ() {
	super();
	// TODO Auto-generated constructor stub
}

public PointZ(int x, int y) {
	super(x, y);
	// TODO Auto-generated constructor stub
}


public PointZ(int x, int y, int z) {
	super(x,y);
	this.z = z;
}

@Override
public String toString() {
	return "PointZ [z=" + z + ", x=" + x + ", y=" + y + "]";
}

}
