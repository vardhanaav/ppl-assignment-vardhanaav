import java.io.*;
import java.util.*;

/**
	* @author AAV
	* this class is specially created for inheritance
	*/ 
public class q3 extends q2 {
	/**
	* constructor to call constructor of q2 (inheritance)
	*/  
	q3() throws IOException {
		new q2();
	}
	/**
	* @param args command line arguments
	*/
	public static void main(String args[]) throws IOException {
		q3 obj = new q3();
	}
}


