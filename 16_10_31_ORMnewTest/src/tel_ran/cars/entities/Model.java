package tel_ran.cars.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Model {
@Id
String modelName;
String vender;
int volume;
int year;
@OneToMany(mappedBy="model")
Set<Car> cars;
public String getModelName() {
	return modelName;
}
public void setModelName(String modelName) {
	this.modelName = modelName;
}
public String getVender() {
	return vender;
}
public void setVender(String vender) {
	this.vender = vender;
}
public int getVolume() {
	return volume;
}
public void setVolume(int volume) {
	this.volume = volume;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public Set<Car> getCars() {
	return cars;
}
public void setCars(Set<Car> cars) {
	this.cars = cars;
}
public Model(String modelName, String vender, int volume, int year) {
	super();
	this.modelName = modelName;
	this.vender = vender;
	this.volume = volume;
	this.year = year;
}
public Model() {
	super();
}
@Override
public String toString() {
	return "Model [modelName=" + modelName + ", vender=" + vender + ", volume=" + volume + ", year=" + year + "]";
}

}
