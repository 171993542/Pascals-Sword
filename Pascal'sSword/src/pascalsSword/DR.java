package pascalsSword;

import java.math.BigInteger;
import java.util.ArrayList;

public class DR {
	ArrayList<ArrayList<Integer>> DRDie = new ArrayList<>();
	ArrayList<Integer> TempDie = new ArrayList<>();
	int Max;int Min;int MaxMax;int MaxMin;
	BigInteger[] Holder;
	int SetZero;
	int[] ValueFinder;
	String temp;int DR;Boolean Checker;int CorrectValue;
	
	int total=0;
	
	public DR() {
		
	}
	public ArrayList<ArrayList<Integer>> CalcDR(ArrayList<ArrayList<Integer>>Die,String Info) {	
		//RemovedDie = new ArrayList<>(new ArrayList<>());
		DRDie.add(new ArrayList<>());
		temp = Info;
		temp = temp.replaceAll("dr","");temp = temp.replaceAll("neg","-"); //Change this plz
		//System.out.println(temp);
		DR = Integer.parseInt(temp);
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
		for(int DiceValue=0;TempDie.size()>DiceValue;DiceValue++) {
			//System.out.println("drats");
			CorrectValue = TempDie.get(DiceValue)-DR;
			if(DR>=0&&CorrectValue<0) {
				CorrectValue=0;
			}else if(DR<0&&CorrectValue>0) {
				CorrectValue=0;
			}
			DRDie.get(0).add(CorrectValue);
		}

		for(int Blank=0;Die.size()-1>Blank;Blank++) {
			DRDie.add(new ArrayList<>());
			DRDie.get(Blank+1).add(0);
		}
		return DRDie;
	}
}
