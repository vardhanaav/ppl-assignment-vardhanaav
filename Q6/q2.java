/**
 * @author Ashwin Aishvarya Vardhan
 */

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.time.*;
import java.time.temporal.*;

public class q2 extends q1{ //inheritance
	//line-wise reading of text file
	DataOutputStream dos;
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
	 * function to write to file the content with append
	 * @param data the content to be written to file
	 */
	public void write(String data) {
		FileWriter fw = null;

		//try {
		BufferedWriter bw = null;

		try {
			File fileName = new File("log.txt");
			if (!fileName.exists()) {
				fileName.createNewFile();
			}

			fw = new FileWriter(fileName.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	} 

	public void createTextFile() throws IOException{
		dos = new DataOutputStream(new FileOutputStream("log.txt"));
	}

	/** 
	 * function to copy source file to destination file
	 * @param s1 source file name
	 * @param s2 destination file name
	 */
	public void ftof(String s1, String s2)throws IOException {
		FileOutputStream fos = new FileOutputStream(s2);// Destination
		DataOutputStream dos = new DataOutputStream(fos);//where to write
		FileInputStream fis = new FileInputStream(s1);//source
		DataInputStream dis = new DataInputStream(fis);//from where to read
		String st;
		while((st = dis.readLine()) != null) {
			//									  	|
			//									   EOF
			dos.writeBytes(st);
			dos.writeBytes("\n");
		}
	}

	/**
	 * search for a girlfriend continues
	 * @param girlfriend name of the girlfriend
	 * @param g the array of object Girls
	 * @return the index of the corresponding gf
	 */
	int search(String girlfriend, Girls []g) {
		for (int i=0; i<g.length; i++) {
			if (g[i].name.equals(girlfriend)) return i;
		}
		return 0;
	}


	/**
	 * function to search for corresponding boyfriend  
	 * @param boyfriend name of the boyfriend
	 * @param b the array of object Boys
	 * @return the index of the corresponding bf
	 */
	int searchbf(String boyfriend, Boys []b) {
		for (int i=0; i<b.length; i++) {
			if (b[i].name.equals(boyfriend)) return i;
		}
		return 0;
	}

	//driver-function
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
						//dos.writeBytes(b[i].name+" gifts "+strarr[4]+" to "+b[i].girlfriend+" on "+LocalDate.now()+" "+LocalTime.now()+"\n");
						String content = new String(b[i].name+" gifts "+strarr[4]+" to "+b[i].girlfriend+" on "+LocalDate.now()+" "+LocalTime.now()+"\n");
						write(content);
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



	/**
	 * driver-function
	 * @param b the array of object Boys
	 * @param g the array og object Girls
	 */
	public void couplify(Boys []b, Girls []g) throws IOException{
		int j=0;
		//		System.out.println("Couplify");
		//DataOutputStream dos = new DataOutputStream(new FileOutputStream("log.txt")); //created in the current directory, no path specs reqd
		for (int i=0; i<g.length; i++) {
			if (g[i].maintainencebudget < b[j].maintainencebudget && g[i].committed == false && b[j].committed == false) {
				g[i].boyfriend = b[j].name;
				g[i].committed = true;
				b[j].girlfriend = g[i].name;
				b[j].committed = true;				
				//dos.writeBytes(g[i].name+" got committed to "+b[j].name+" on "+LocalDate.now()+" "+LocalTime.now()+"\n");
				String content = new String(g[i].name+" got committed to "+b[j].name+" on "+LocalDate.now()+" "+LocalTime.now()+"\n");
				write(content);
				j++;
			} else if (g[i].maintainencebudget > b[j].maintainencebudget && g[i].committed == false && b[j].committed == false) {
				j++;
				i--;
			}

		}
	}

	//create a copy function : done
	/** 
	 * function for breaking the engagement before marriage
	 * @param b Array of objects of Boys
	 * @param g Array of objects of Girls
	 * @param h Array of objects of Happyfy
	 */
	public void breakify(Boys []b, Girls []g, Happyfy h[]) throws IOException{
		int len, k=2; //k breakups
		len = h.length; //h->happinessarray
		//DataOutputStream dos = new DataOutputStream(new FileOutputStream("log4.txt"));
		for (int i=0; i<k; i++) {
			String boyName, girlName;
			boyName = h[len-1-i].boyfriend;
			//System.out.println(boyName);
			girlName = h[len-1-i].girlfriend;
			//System.out.println(girlName);
			int bidx = searchbf(boyName, b); //use search function
			int gidx = search(girlName, g);
			while (!(b[bidx].name.equals(boyName))) {
				bidx++;
			}
			//b[bidx].committed = false; //do it later on
			b[bidx].girlfriend = "";
			b[bidx].committed = false;

			while (!(g[gidx].name.equals(girlName))) {
				gidx++;
			}
			g[gidx].committed = false;
			g[gidx].boyfriend = "";
			//dos.writeBytes(g[gidx].name+" broke up with "+b[bidx].name+" on "+LocalDate.now()+" "+LocalTime.now()+"\n");
			String content = new String(g[gidx].name+" broke up with "+b[bidx].name+" on "+LocalDate.now()+" "+LocalTime.now()+"\n");
			write(content);
		}	
	}

	//start of main
	/**
	 * constructor doing all the job, my bro constructor
	 */
	q2() throws IOException{
		//createTextFile();
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
		/**
		 * number of days the gifting occurs, will be taken as 2 by default
		 */
		int t;
		nb = 7; ng = 5; k = 0; z = 0; num_happ_coup = 3; t = (int)Math.random()*30+1; //nb = no.of boys, ng = no.of girls, num_happ_coup = no.of happiest couples to be found
		Boys b[] = new Boys[nb];
		Girls g[] = new Girls[ng];
		Happyfy happinessarray[] = new Happyfy[ng];		
		//q2 FilesUtil = new q2();

		//File fileName1 = new File("laussan.txt");



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
		while (t-- > 0) {
			couplify(b, g); //need this for real
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
			breakify(b, g, happinessarray);
			couplify(b, g);

			//DataOutputStream dos = new DataOutputStream(new FileOutputStream("log2.txt"));
			//}
			//ftof("log.txt", "log3.txt");
			//try to use writetotextfile


			for (int i=0; i<nb; i++) {
				if (b[i].girlfriend.length() == 0) {
					b[i].committed = false;
				}
			}

			//breakify(b, g, happinessarray);	
			//couplify(b, g);
			//DataOutputStream dos = new DataOutputStream(new FileOutputStream("log2.txt"));
			//dos.writeBytes("Happiest "+num_happ_coup+" couples are\n");
			String content = new String("Happiest "+num_happ_coup+" couples are\n");
			write(content);
			for (int i=0; i<num_happ_coup; i++) {
				//dos.writeBytes(happinessarray[i].boyfriend+" and "+happinessarray[i].girlfriend+"\n");
				content = new String(happinessarray[i].boyfriend+" and "+happinessarray[i].girlfriend+"\n");
				write(content);
			}
			//breakify(b, g, happinessarray);
			//couplify(b, g);
	}
	}
}
