package pascalsSword;

import java.util.ArrayList;

public class Extrema {
	ArrayList<ArrayList<Integer>> Dice;
	int Export;
	int Looker;
	
	public Extrema(ArrayList<ArrayList<Integer>> Dice){//this is a class
		this.Dice = Dice;
		//Export = 0;
		}
		
	public int Max() {
		Export = 0;
		for(int Group = 0;Group<Dice.size();Group++) {
			Looker = Dice.get(Group).get(0);
			for(int Num = 0;Num<Dice.get(Group).size();Num++) {
				if (Looker < Dice.get(Group).get(Num)) {
					Looker = Dice.get(Group).get(Num);
				}
			}
		Export += Looker; ///broken
		}
		return Export;
	}
	public int Min() {
		Export = 0;
		for(int Group = 0;Group<Dice.size();Group++) {
			//System.out.println(Dice);
			Looker = Dice.get(Group).get(0);
			for(int Num = 0;Num<Dice.get(Group).size();Num++) {
				if (Looker > Dice.get(Group).get(Num)) {
					Looker = Dice.get(Group).get(Num);
				}
			}
		Export += Looker; ///broken
		}
		return Export;
	}
	public int MaxMax() {
		Export = 0;
		for(int Group = 0;Group<Dice.size();Group++) {
			Looker = Dice.get(Group).get(0);
			for(int Num = 0;Num<Dice.get(Group).size();Num++) {
				if (Looker < Dice.get(Group).get(Num)) {
					Looker = Dice.get(Group).get(Num);
					//System.out.println("Looker: "+Looker);
				}
			}
			if(Looker>0) {
				Export += Looker;
			}
		}
		return Export;
	}
	
	public int MaxMin() {
		Export = 0;
		for(int Group = 0;Group<Dice.size();Group++) {
			Looker = Dice.get(Group).get(0);
			for(int Num = 0;Num<Dice.get(Group).size();Num++) {
				if (Looker > Dice.get(Group).get(Num)) {	
					Looker = Dice.get(Group).get(Num);
				}
			}	
			if(Looker<0) {
				Export += Looker;
			}
		}
		return Export;
	}
}
