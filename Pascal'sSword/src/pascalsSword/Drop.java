package pascalsSword;

import java.math.BigInteger;
import java.util.ArrayList;

public class Drop {
	ArrayList<ArrayList<Integer>> DroppedDie = new ArrayList<>();
	ArrayList<Integer> TempDie = new ArrayList<>();
	ArrayList<Integer> Adders = new ArrayList<>();
	String[] DropValues;
	BigInteger[] Rolls;
	String temp;
	boolean Checker;
	
	
	public Drop() {
// pass
//use neg1 for neg nums
	}
	public ArrayList<ArrayList<Integer>> CalcDrop(ArrayList<ArrayList<Integer>>Die,String Info) {	
		//checks if we are adding or subtracting
		for(int Operation = 0;Die.size()>Operation;Operation++) {
			if(Die.get(Operation).size()==1) {
				Adders.add(Die.get(Operation).get(0));
				Die.get(Operation).set(0,0);
			}
		}
		//System.out.println("Info: "+Info);
		temp = Info;
		temp = temp.replaceAll("erop","");temp = temp.replaceAll("reroll","");temp = temp.replaceAll("neg","-");
		//System.out.println(temp);
		DropValues = temp.split(",");
		//System.out.println("Info is equal to: "+temp);
		if(temp.equals("")) {
			Die.add(Adders);
			return Die;
		}
		//System.out.println("Drop Values: "+Arrays.toString(DropValues));
		//System.out.println(Die.size());
		for(int Dice=0;Die.size()>Dice;Dice++) {
			//System.out.println("Check1");
			DroppedDie.add(new ArrayList<>()); //change stuff HERE
			for(int sides = 0;Die.get(Dice).size()>sides;sides++) {
				//System.out.println("Sides: "+sides);
				if(Info.contains("reroll")) {
					DroppedDie.get(Dice).add(Die.get(Dice).get(sides));
				}
			}
			for(int RollPos = 0;Die.get(Dice).size()>RollPos;RollPos++) {
				//System.out.println("Check2");
				Checker = true;
				for(int Check = 0;DropValues.length>Check;Check++) {
					//System.out.println("Check3");
					if(Die.get(Dice).get(RollPos)==Integer.parseInt(DropValues[Check])) {
						Checker = false;
						//Die.get(Dice).get(RollPos)
					}
				}
				//System.out.println("checker: "+Checker);
				if(Checker == true) {
					DroppedDie.get(Dice).add(Die.get(Dice).get(RollPos));
				}
			}
		}
		Die.add(Adders);
		return DroppedDie;
		
		
	}
	
}
