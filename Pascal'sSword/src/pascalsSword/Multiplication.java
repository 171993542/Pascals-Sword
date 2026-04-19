package pascalsSword;

import java.math.BigInteger;
import java.util.ArrayList;

public class Multiplication {
	ArrayList<ArrayList<Integer>> MultDie = new ArrayList<>();
	ArrayList<Integer> TempDie = new ArrayList<>();
	int Max;int Min;int MaxMax;int MaxMin;
	BigInteger[] Holder;
	int SetZero;
	int[] ValueFinder;
	String temp;String[] MultValues;Boolean Checker;
	
	int total=0;
	
	public Multiplication() {
		
	}
	public ArrayList<ArrayList<Integer>> CalcMultiplication(ArrayList<ArrayList<Integer>>Die,String Info) {	
		//RemovedDie = new ArrayList<>(new ArrayList<>());
		MultDie.add(new ArrayList<>());
		temp = Info;
		temp = temp.replaceAll("mult","");temp = temp.replaceAll("neg","-"); //Change this plz
		//System.out.println(temp);
		MultValues = temp.split(",");
		if(temp.equals("")) {
			return Die;
		}
		Extrema Extrema = new Extrema(Die);
		Min = Extrema.Min();Max = Extrema.Max();MaxMin = Extrema.MaxMin();MaxMax = Extrema.MaxMax();
		Sword Sword = new Sword(Die,Min,Max,MaxMin,MaxMax);
		Holder = Sword.Calc();
		ValueFinder = new int[Sword.Calc().length];
		SetZero = Sword.SetPoint();
		for(int i=SetZero;i<SetZero+Sword.Calc().length;i++) {				
			ValueFinder[i-SetZero] = i;//if set zero is neg 1
			}
		for(int Dist=0;ValueFinder.length>Dist;Dist++) {
			for(int Times=0;Holder[Dist].intValue()>Times;Times++) {
				TempDie.add(ValueFinder[Dist]);//chance that -1 should be fixed idk
			}
		}
		//basically I need a correct die thingie here
		for(int Values=0;MultValues.length>Values;Values++) {
			//MultDie.add(new ArrayList<>());
			for(int DiceValue=0;TempDie.size()>DiceValue;DiceValue++) {
				//System.out.println("drats");
				MultDie.get(0).add(TempDie.get(DiceValue)*Integer.parseInt(MultValues[Values]));
			}
		}
		//System.out.println("Temp Die"+TempDie);

		
		for(int Blank=0;Die.size()-1>Blank;Blank++) {
			MultDie.add(new ArrayList<>());
			MultDie.get(Blank+1).add(0);
		}
		return MultDie;
	}
}
