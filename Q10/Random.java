import java.io.*;
import java.util.*;

public class Random{
	/**
	* function to display best k boys
	* @param b array of objects of Boys
	*/
	public Boys randomboy(Boys []b) {
		//Scanner sc = new Scanner(System.in);
		//int hlen = h.length;
		int blen = b.length;
		//int glen = g.length;
		//int min = (glen > blen)? blen : glen;
		//min = (min > glen)? glen : min;
		//int k = min;
		int min = blen;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter k from 1 to "+min);
		int k = sc.nextInt();
		k = (k>min)?min:k;
		int random = (int)Math.random()*10;
		random %= k;
		return b[random]; 
		//min = k;
		/*System.out.println("\nk best boys are:");
		for (int i=0; i<min; i++) {
			//System.out.println("k best boys are:\n");
			System.out.println(b[min-1-i].name);
		}
		System.out.println("\nk best girls are:");
		for (int i=0; i<min; i++) {
			System.out.println(g[min-1-i].name);
		}*/
		/*System.out.println("k best couples are:\n");
		for (int i=0; i<min; i++) {
			System.out.println(h[min-1-i]);
		}*/
	}

	/**
	* function to display best k girls
	* @param g array of objects of Girls
	*/
	public Girls randomgirl(Girls []g) {
		//Scanner sc = new Scanner(System.in);
		//int hlen = h.length;
		//int blen = b.length;
		int glen = g.length;
		//int min = (glen > blen)? blen : glen;
		//min = (min > glen)? glen : min;
		//int k = min;
		int min = glen;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter k from 1 to "+min);
		int k = sc.nextInt();
		k = (k>min)?min:k;
		int random = (int)Math.random()*10;
		random %= k;
		return g[random]; 
		//min = k;
		/*System.out.println("\nk best boys are:");
		for (int i=0; i<min; i++) {
			//System.out.println("k best boys are:\n");
			System.out.println(b[min-1-i].name);
		}
		System.out.println("\nk best girls are:");
		for (int i=0; i<min; i++) {
			System.out.println(g[min-1-i].name);
		}*/
		/*System.out.println("k best couples are:\n");
		for (int i=0; i<min; i++) {
			System.out.println(h[min-1-i]);
		}*/
	}
}
		
		

