import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.time.*;
import java.time.temporal.*;


public class GiftSelector {
	
	/**
	 * line-wise reading of text file
	 * @param fileName the file to be read
	 * @return the list containing the contents of file line-by-line
	 */
	public List<String> readTextFileByLines(String fileName) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(fileName));
		return lines;
	}

	/**
	 * search for a girlfriend continues
	 * @param girlfriend name of the girlfriend
	 * @param g the array of object Girls
	 * @return the index of the corresponding gf
	 */
	public int search(String girlfriend, Girls []g) {
		for (int i=0; i<g.length; i++) {
			if (g[i].name.equals(girlfriend)) return i;
		}
		return 0;
	}
	/**
	 * driver-function
	 * @param b the array of object Boys
	 * @param g the array of object Girls
	 * @param happinessarray an array of Object Happyfy: stores the happiness of couples
	 */
	public void giftifyoptimized(Boys []b, Girls []g, Happyfy happinessarray[]) throws IOException {
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
}
