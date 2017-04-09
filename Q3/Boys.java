//import java.util.*;
public class Boys {

	String name, girlfriend;
	int attractiveness;
	double maintainencebudget;
	int intellilevel;	
	/**
	* minimum attractive requirement of boy, erst are self-explanatory
	*/
	int minattractreq;
	boolean committed;
	/**	
	* miser | generous | geek
	*/
	String type; //miser|generous|geek
	double happiness;

	/**
	* @param str contains the boys' details line by line
	*/
	public Boys(String str[]) {	//constructor: to be read from file
		//int n = num+1;
		name = str[0];
		attractiveness = Integer.parseInt(str[1]);
		maintainencebudget = Integer.parseInt(str[2]);
		intellilevel = Integer.parseInt(str[3]);
		minattractreq = Integer.parseInt(str[4]);
		committed = false;
		girlfriend = "";
		type = str[5];
	}

/*	public void display() {
		//System.out.println("Display Boys");
		System.out.println(name+"\n"+attractiveness+"\n"+maintainencebudget+"\n"+intellilevel+"\n"+minattractreq+"\n"+committed+"\n"+girlfriend+"\n");
	}*/
}

