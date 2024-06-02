package memorybehaviorarrayslists.entities;

public class Student {
	private String name;
	private double firstNote;
	private double secondNote;
	
	public Student(String name, double firstNote, double secondNote) {
		this.name = name;
		this.firstNote = firstNote;
		this.secondNote = secondNote;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFirstNote() {
		return firstNote;
	}
	public void setFirstNote(double firstNote) {
		this.firstNote = firstNote;
	}
	public double getSecondNote() {
		return secondNote;
	}
	public void setSecondNote(double secondNote) {
		this.secondNote = secondNote;
	}

	

}
