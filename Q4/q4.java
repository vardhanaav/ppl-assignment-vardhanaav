import java.io.*;
import java.util.*;

public class q4 extends q2 {  //inheritance
	/**
	* constructor calls the constructor of q2 (to exhibit inheritance)
	*/
	q4() throws IOException {
		new q2();
	}
	/**
	* @param args command line arguments
	*/
	public static void main(String args[]) throws IOException {
		q4 obj = new q4();
	}
}


