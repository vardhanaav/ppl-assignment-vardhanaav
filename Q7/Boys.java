import java.util.*;
import java.io.*;
public class Boys {

	String name, girlfriend;
	int attractiveness;
	double maintainencebudget;
	int intellilevel;
	/**
	* minimum attractiveness requirement rest are self explanatory*/
	int minattractreq;
	boolean committed;
	/**
	* miser or generous or geek*/
	String type; //miser|generous|geek
	double happiness;

	/**
	* constructor
	* @param str contains the line to be read
	*/
	public Boys(String str[]) {	//constructor: to be read from file
		//int n = num+1;
		name = str[0];
		attractiveness = Integer.parseInt(str[1]);
		maintainencebudget = Double.parseDouble(str[2]);
		//int idx = str[2].indexOf(".");
		//String ll = str[2].substring(0, idx);
		//maintainencebudget = Double.parseDouble(ll);
		intellilevel = Integer.parseInt(str[3]);
		minattractreq = Integer.parseInt(str[4]);
		committed = false;
		girlfriend = "";
		type = str[5];
	}

	/*public void display() {
		//System.out.println("Display Boys");
		System.out.println(name+"\n"+attractiveness+"\n"+maintainencebudget+"\n"+intellilevel+"\n"+minattractreq+"\n"+committed+"\n"+girlfriend+"\n");
	}*/
}

