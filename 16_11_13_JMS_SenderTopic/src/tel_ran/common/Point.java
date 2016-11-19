package tel_ran.common;

import java.io.Serializable;

public class Point implements Serializable{
int x,y;

public int getX() {
	return x;
}

public int getY() {
	return y;
}

public Point() {
	super();
	// TODO Auto-generated constructor stub
}

public Point(int x, int y) {
	super();
	this.x = x;
	this.y = y;
}

}
