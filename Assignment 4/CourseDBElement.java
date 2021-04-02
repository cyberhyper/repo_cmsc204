package assignment4;

public class CourseDBElement<T> implements Comparable<T>  {
	
	int crnCourse;
	int cred;
	String idCourse;
	String num;
	String name;
	
	public CourseDBElement(String id, int crn, int credits, String room, String instructor) 
	{
		crnCourse = crn;
		cred = credits;
		idCourse = id;
		num = room;
		name = instructor;
	}
	
	public CourseDBElement()
	{
	}

	public String getID()
	{
		return idCourse;
	}
	
	public int getCRN()
	{
		return crnCourse;
	}
	
	public int getCredits()
	{
		return cred;
	}
	
	public String getRoom()
	{
		return num;
	}
	
	public String getIntructor()
	{
		return name;
	}
	
	public void setID(String id)
	{
		idCourse = id;
	}
	
	public void setCRN(int crn)
	{
		crnCourse = crn;
	}
	
	public void setCredits(int credits)
	{
		cred = credits;
	}
	
	public void setRoom(String room)
	{
		num = room;
	}
	
	public void setIntructor(String intructor )
	{
		name = intructor;
	}
	
	public int hashCode()
	{
		return String.valueOf(crnCourse).hashCode();
	}
	
	public String toString()
	{
		String str =  "\nCourse:" + idCourse + " CRN:" + crnCourse + " Credits:"
				+ cred + " Instructor:" + name + " Room:" + num;
		return str;
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
}