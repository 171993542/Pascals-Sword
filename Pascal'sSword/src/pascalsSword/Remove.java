package pascalsSword;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Remove {
	ArrayList<ArrayList<Integer>> RemovedDie = new ArrayList<>();
	ArrayList<Integer> TempDie = new ArrayList<>();
	int Max;int Min;int MaxMax;int MaxMin;
	BigInteger[] Holder;
	int SetZero;
	int[] ValueFinder;
	String temp;String[] DropValues;Boolean Checker;
	
	int total=0;
	
	public Remove() {
		
	}
	public ArrayList<ArrayList<Integer>> CalcRemove(ArrayList<ArrayList<Integer>>Die,String Info) {	
		//RemovedDie = new ArrayList<>(new ArrayList<>());
		RemovedDie.add(new ArrayList<>());
		temp = Info;
		temp = temp.replaceAll("remove","");temp = temp.replaceAll("neg","-");
		//System.out.println(temp);
		DropValues = temp.split(",");
		if(temp.equals("")) {
			return Die;
		}
		Extrema Extrema = new Extrema(Die);
		Min = Extrema.Min();Max = Extrema.Max();MaxMin = Extrema.MaxMin();MaxMax = Extrema.MaxMax();
		Sword Sword = new Sword(Die,Min,Max,MaxMin,MaxMax);
		Holder = Sword.Calc();
		//System.out.println("Holder? "+Arrays.toString(Holder));
		ValueFinder = new int[Sword.Calc().length];
		SetZero = Sword.SetPoint();
		for(int i=SetZero;i<SetZero+Sword.Calc().length;i++) {				
			ValueFinder[i-SetZero] = i;//if set zero is neg 1
			}
		for(int Dist=0;ValueFinder.length>Dist;Dist++) {
			Checker = true;
			for(int Values=0;DropValues.length>Values;Values++) {
				if(Integer.parseInt(DropValues[Values])==ValueFinder[Dist]) {
					Checker = false;
				}
			}//something here
			//System.out.println("checker: "+Checker);
			if(Checker==true) {
				total +=1;
				TempDie = new ArrayList<>();
				//System.out.println("Holder thingie: "+Holder[Dist].intValue());
				for(int Times=0;Holder[Dist].intValue()>Times;Times++) {
					TempDie.add(ValueFinder[Dist]);//chance that -1 should be fixed idk
				}
			//System.out.println(RemovedDie);
			RemovedDie.get(0).addAll(TempDie);
			}
		}
		for(int Blank=0;Die.size()-1>Blank;Blank++) {
			RemovedDie.add(new ArrayList<>());
			RemovedDie.get(Blank+1).add(0);
		}
		//System.out.println("Total: "+total);
		//System.out.println("Holder: "+Arrays.toString(Holder));
		//System.out.println("ValueFinder: "+Arrays.toString(ValueFinder));
		return RemovedDie;
	}
}
