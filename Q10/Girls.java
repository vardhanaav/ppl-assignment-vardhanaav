public class Girls {
	String name;
	int attractiveness;
	double maintainencebudget;
	int intellilevel;
	String criterion; // usage TBD
	boolean committed;
	String boyfriend;

	Girls(String str[]) {	//constructor: to be read from file
		//int n = num+1;
		name = str[0];
		attractiveness = Integer.parseInt(str[1]);
		maintainencebudget = Double.parseDouble(str[2]);
		intellilevel = Integer.parseInt(str[3]);
		criterion = str[4];
		committed = false;		
		boyfriend = "";
	}

	Girls(int x) {
		name = "";
		attractiveness = 0;
		maintainencebudget = 0;
		intellilevel = 0;
		criterion = "";
		committed = false;		
		boyfriend = "";
	}
	/*public void display() {
		//System.out.println("Girls");
		System.out.println(name+"\n"+attractiveness+"\n"+maintainencebudget+"\n"+intellilevel+"\n"+criterion+"\n"+committed+"\n"+boyfriend+"\n");

	}*/
}
