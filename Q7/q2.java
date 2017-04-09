import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.time.*;
import java.time.temporal.*;
import java.util.Map.Entry;

/**
 * @author Ashwin Aishvarya Vardhan
 */

public class q2 implements Array, SortedArray, hashtable{
	/**
	 * Scanner for input
	 */
	//Scanner sc = new Scanner(System.in);

	Boys array[];
	String stringarr[];
	Hashtable<String, String> ht = new Hashtable<String, String>();
	
	/**
	 * line-wise reading of text file
	 * @param fileName the file to be read
	 * @return the list containing the contents of file line-by-line
	 */

	public List<String> readTextFileByLines(String fileName) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(fileName));
		return lines;
	}

	//write to txt file
	/*public void writeToTextFile(String fileName, String content) throws IOException {
	  Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.CREATE);
	  }*/


	/**
	* Function to store committed boys in linear array
	* @param b array of object Boys containing the details of all boys
	*/
	public void store1(Boys []b) {
		int x = 0;
		stringarr = new String[6];
		for (int i=0; i<b.length; i++) {
			if (b[i].committed == true) {
				stringarr[0] = b[i].name;
				stringarr[1] = String.valueOf(b[i].attractiveness);
				//System.out.println(stringarr[0]+"-"+stringarr[1]);
				stringarr[2] = String.valueOf((int)b[i].maintainencebudget);
				stringarr[3] = String.valueOf(b[i].intellilevel);
				stringarr[4] = String.valueOf(b[i].minattractreq);
				//System.out.println(stringarr[0]+"-"+stringarr[1]+"-"+stringarr[2]+"-"+stringarr[3]);
				//stringarr[x].committed = b[i].committed;
				//stringarr[x].girlfriend = b[i].girlfriend;
				stringarr[5] = b[i].type;
				array[x] = new Boys(stringarr);
				array[x].committed = b[i].committed;
				array[x].girlfriend = b[i].girlfriend;
				x++;
			}
		}
		/*for (int i=0; i<array.length; i++) {
			System.out.println(array[i].name+"-"+array[i].committed+"-"+array[i].type);
		}*/
	}

	/**
	* function to search linearly the boy and his gf
	* @param nameb name of the boy to be searched
	*/
	public void search1(String nameb) {
		int flag = 0;
		//System.out.println("lauda"+nameb);
		for (int i=0; i<array.length; i++) {
			if (nameb.equalsIgnoreCase(array[i].name)) {
				System.out.println(array[i].name+" has a girlfriend named "+array[i].girlfriend);
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			System.out.println(nameb+" is single");
	}

	/**
	 * search for a girlfriend continues with search function
	 * @param girlfriend name of the girlfriend
	 * @param g the array of object Girls
	 */

	int search(String girlfriend, Girls []g) {
		for (int i=0; i<g.length; i++) {
			if (g[i].name.equals(girlfriend)) return i;
		}
		return 0;
	}
	
	/**
	* function to store committed boys in sorted array
	* @param b array of object Boys containing list of all boys
	*/
	public void store2(Boys []b) {
		int x = 0;
		stringarr = new String[6];
		for (int i=0; i<b.length; i++) {
			if (b[i].committed == true) {
				stringarr[0] = b[i].name;
				stringarr[1] = String.valueOf(b[i].attractiveness);
				//System.out.println(stringarr[0]+"-"+stringarr[1]);
				stringarr[2] = String.valueOf((int)b[i].maintainencebudget);
				stringarr[3] = String.valueOf(b[i].intellilevel);
				stringarr[4] = String.valueOf(b[i].minattractreq);
				//System.out.println(stringarr[0]+"-"+stringarr[1]+"-"+stringarr[2]+"-"+stringarr[3]);
				//stringarr[x].committed = b[i].committed;
				//stringarr[x].girlfriend = b[i].girlfriend;
				stringarr[5] = b[i].type;
				array[x] = new Boys(stringarr);
				array[x].committed = b[i].committed;
				array[x].girlfriend = b[i].girlfriend;
				x++;
			}
		}
		/*for (int i=0; i<array.length; i++) {
			System.out.println(array[i].name+"-"+array[i].committed+"-"+array[i].type);
		}*/
	}

	/**
	* function to binary search the name of boy
	* @param nameb name of the boy to be searched
	*/ 
	public void search2(String nameb) {
		int flag = 0;
		//System.out.println("lauda"+nameb);
		for (int i=0; i<array.length; i++) {
			if (nameb.equalsIgnoreCase(array[i].name)) {
				System.out.println(array[i].name+" has a girlfriend named "+array[i].girlfriend);
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			System.out.println(nameb+" is single");
	}


	/**
	* function to store the list of committed boys in hashtable
	* @param barr list of committed boys to be stored
	*/
	public void store3(Boys []barr) {
		for (int i=0; i<barr.length; i++) {
			ht.put(barr[i].name, barr[i].girlfriend);
		}	
	}
	
	/**
	* function to search from hashtable
	* @param nameb name of the boy to be searched
	*/ 
	public void search3(String nameb) {
		int flag = 0;
		for (Iterator<Entry<String, String>> iterator = ht.entrySet().iterator(); iterator.hasNext();) {
			Entry<String, String> m = iterator.next();
			if (nameb.equals(m.getKey())) {
				System.out.println(nameb+" has a girlfriend named "+m.getValue());
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			System.out.println(nameb+" is single.");
		}
	}	
	/**
	 * driver-function
	 * @param b the array of object Boys
	 * @param g the array og object Girls
	 */
	public void couplify(Boys []b, Girls []g) throws IOException{
		int j=0;
		//		System.out.println("Couplify");
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("log.txt")); //created in the current directory, no path specs reqd
		for (int i=0; i<g.length; i++) {
			if (g[i].maintainencebudget < b[j].maintainencebudget && g[i].committed == false && b[j].committed == false) {
				g[i].boyfriend = b[j].name;
				g[i].committed = true;
				b[j].girlfriend = g[i].name;
				b[j].committed = true;				
				dos.writeBytes(g[i].name+" got committed to "+b[j].name+" on "+LocalDate.now()+" "+LocalTime.now()+"\n");
				j++;
			} else if (g[i].maintainencebudget > b[j].maintainencebudget && g[i].committed == false && b[j].committed == false) {
				j++;
				i--;
			}

		}
	}

	/**
	 * driver-function
	 * @param b the array of object Boys
	 * @param g the array of object Girls
	 * @param happinessarray an array of Object Happyfy: stores the happiness of couples
	 */

	public void giftify(Boys []b, Girls []g, Happyfy happinessarray[]) throws IOException {
		int i, j=0;
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("log1.txt"));
		for (i=0; i<b.length; i++) {
			if (b[i].committed == true) {
				double sumval = 0, sumcost = 0;
				while (sumcost <= b[i].maintainencebudget) {
					List<String> gift = readTextFileByLines("Gifts.txt");
					Object arrgift[] = gift.toArray();
					for (int k=0; k<arrgift.length; k++) {
						String str = arrgift[k].toString();
						if (str.length() == 0) {        //ignore new-line                       
							continue;
						}
						String strarr[] = str.split(",");
						sumval = sumval + Double.parseDouble(strarr[2]);
						sumcost = sumcost + Double.parseDouble(strarr[3]);
						dos.writeBytes(b[i].name+" gifts "+strarr[4]+" to "+b[i].girlfriend+" on "+LocalDate.now()+" "+LocalTime.now()+"\n");
					}
				}
				int idx = search(b[i].girlfriend, g);
				if (b[i].type.equals("miser"))
					b[i].happiness = b[i].maintainencebudget-sumcost;
				else if (b[i].type.equals("generous"))
					b[i].happiness = g[idx].happiness; //search for girlfriend via search function
				else //if(b[i].type.equals("geek")
					b[i].happiness = g[idx].intellilevel;

				if (g[idx].type.equals("normal"))
					g[idx].happiness = b[i].maintainencebudget-sumcost;
				else if (g[idx].type.equals("choosy"))
					g[idx].happiness = Math.log(sumcost);
				else //desperate
					g[idx].happiness = Math.exp(sumcost);

				happinessarray[j++] = new Happyfy(b[i].name, g[idx].name, b[i].happiness + g[idx].happiness);
			}
		}
	}

	//start of main
	/**
	 * constructor
	 */
	public q2() throws IOException{
		/**
		 * number of boys*/ 
		int nb;
		/**
		 * number of girls*/
		int ng;
		/**
		 * index variable for boys array*/
		int k;
		/**
		 * index variable for girls array*/ 
		int z;
		/**
		 * number of happiest couples*/
		int num_happ_coup;
		/**
		 * choice 0 for first couplify, 1 for new couplify
		 */
		int choice;
		/**
		 * choice 0 for array, 1 for sorted, 2 for hash table
		 */
		int newchoice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the choice 0 for normal array, 1 for sorted array or 2 for hash table");
		newchoice = sc.nextInt(); 
		nb = 7; ng = 5; k = 0; z = 0; num_happ_coup = 3; //nb = no.of boys, ng = no.of girls, num_happ_coup = no.of happiest couples to be found
		Boys b[] = new Boys[nb];
		array = new Boys[5];	
		/*for (int i=0; i<nb; i++) {
			array[i].name = "";
		}*/
		Girls g[] = new Girls[ng];
		Happyfy happinessarray[] = new Happyfy[ng];	
		choice = (int)(Math.random()*10)%2; //0 for q1, 1 for q5	
		//q2 FilesUtil = new q2();		
		List<String> alb = readTextFileByLines("Boys_data.txt"); //read Boys_data
		Object arrb[] = alb.toArray(); //convert list to array
		for (int i=0; i<arrb.length; i++) {
			String str = arrb[i].toString(); //convert Object to String
			if (str.length() == 0) {	//ignore new-line			
				continue;
			}

			String strarr[] = str.split(",");
			b[k++] = new Boys(strarr); //constructor call
		}
		List<String> alg = readTextFileByLines("Girls_data.txt"); //refer to above comments
		Object arrg[] = alg.toArray();
		for (int i=0; i<arrg.length; i++) {
			String str = arrg[i].toString();
			if (str.length() == 0) {
				continue;
			}
			String strarr[] = str.split(",");
			g[z++] = new Girls(strarr);
		}
		switch(choice) {
			case 0: couplify(b, g); //need this for real
				break;

			case 1: couplify(b, g);
				break;

			default : break;
		}

		giftify(b, g, happinessarray);
		for (int i=0; i<ng-1; i++) {
			for (int j=0; j<ng-1-i; j++) {
				if (happinessarray[j].happiness < happinessarray[j+1].happiness) {
					String tempbf = happinessarray[j].boyfriend;
					String tempgf = happinessarray[j].girlfriend;
					double temphap = happinessarray[j].happiness;
					happinessarray[j].boyfriend = happinessarray[j+1].boyfriend;
					happinessarray[j].girlfriend = happinessarray[j+1].girlfriend;
					happinessarray[j].happiness = happinessarray[j+1].happiness;
					happinessarray[j+1].boyfriend = tempbf;
					happinessarray[j+1].girlfriend = tempgf;
					happinessarray[j+1].happiness = temphap;
				}
			}
		}
		/**
		 * Data output stream*/
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("log2.txt"));
		dos.writeBytes("Happiest "+num_happ_coup+" couples are\n");
		for (int i=0; i<num_happ_coup; i++) {
			dos.writeBytes(happinessarray[i].boyfriend+" and "+happinessarray[i].girlfriend+"\n");
		}
		System.out.println("Enter the name of boy to search");
		String naam = sc.next();
		store1(b);
		switch(newchoice) {
			case 0: 
				search1(naam);
				break;
	
			case 1:
				search2(naam);
				break;
		
			/*case 2:
				search3(naam);
				break;*/ 

			default:
				search1(naam);
				break;

		}
	}
}
