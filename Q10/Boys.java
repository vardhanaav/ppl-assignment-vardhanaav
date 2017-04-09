//import java.util.*;
public class Boys {

	String name, girlfriend;
	int attractiveness;
	double maintainencebudget;
	int intellilevel;
	int minattractreq;
	boolean committed;

	Boys(String str[]) {	//constructor: to be read from file
		//int n = num+1;
		name = str[0];
		attractiveness = Integer.parseInt(str[1]);
		maintainencebudget = Integer.parseInt(str[2]);
		intellilevel = Integer.parseInt(str[3]);
		minattractreq = Integer.parseInt(str[4]);
		committed = false;
		girlfriend = "";
	}
	
	Boys(int x) {
		name = "";
		attractiveness = 0;
		maintainencebudget = 0;
		intellilevel = 0;
		minattractreq = 0;
		committed = false;
		girlfriend = "";
	}

	/*public void display() {
		//System.out.println("Display Boys");
		System.out.println(name+"\n"+attractiveness+"\n"+maintainencebudget+"\n"+intellilevel+"\n"+minattractreq+"\n"+committed+"\n"+girlfriend+"\n");
	}*/
}

