package pascalsSword;

import java.math.BigInteger;
import java.util.ArrayList;

public class Half {
	ArrayList<ArrayList<Integer>> HalfDie = new ArrayList<>();
	ArrayList<Integer> TempDie = new ArrayList<>();
	int Max;int Min;int MaxMax;int MaxMin;
	BigInteger[] Holder;
	int SetZero;
	int[] ValueFinder;
	String temp;Boolean Checker;
	
	int total=0;
	
	public Half() {
		
	}
	public ArrayList<ArrayList<Integer>> CalcHalf(ArrayList<ArrayList<Integer>>Die,String Info) {	
		//RemovedDie = new ArrayList<>(new ArrayList<>());
		HalfDie.add(new ArrayList<>());
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
		
		for(int DiceValue=0;TempDie.size()>DiceValue;DiceValue++) {
			//System.out.println("drats");
			if(TempDie.get(DiceValue)==1) {
				HalfDie.get(0).add(1);
			}else if(TempDie.get(DiceValue)==-1){
				HalfDie.get(0).add(-1);
			}
			else {
				if(TempDie.get(DiceValue)>=0){
					HalfDie.get(0).add((int)Math.round((double) TempDie.get(DiceValue)/2+.1));
				}else if(TempDie.get(DiceValue)<0){
					HalfDie.get(0).add((int)Math.round((double) TempDie.get(DiceValue)/2+.1));
				}
			}
		}

		for(int Blank=0;Die.size()-1>Blank;Blank++) {
			HalfDie.add(new ArrayList<>());
			HalfDie.get(Blank+1).add(0);
		}
		return HalfDie;
	}
}