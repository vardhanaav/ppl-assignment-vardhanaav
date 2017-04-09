import java.io.*;
import java.util.*;

public class Custom{
	/**
	* function to display best k boys and girls
	* @param b array of objects of Boys
	* @param g array of objects of Girls
	*/
	public void display(Boys []b, Girls []g){
		//Scanner sc = new Scanner(System.in);
		//int hlen = h.length;
		int blen = b.length;
		int glen = g.length;
		int min = (glen > blen)? blen : glen;
		//min = (min > glen)? glen : min;
		//int k = min;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter k from 1 to "+min);
		int k = sc.nextInt();
		k = (k>min)?min:k;
		//min = k;
		System.out.println("\nk best boys are:");
		for (int i=0; i<min; i++) {
			//System.out.println("k best boys are:\n");
			System.out.println(b[min-1-i].name);
		}
		System.out.println("\nk best girls are:");
		for (int i=0; i<min; i++) {
			System.out.println(g[min-1-i].name);
		}
		/*System.out.println("k best couples are:\n");
		for (int i=0; i<min; i++) {
			System.out.println(h[min-1-i]);
		}*/
	}
}
		
		

