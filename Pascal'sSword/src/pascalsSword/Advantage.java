package pascalsSword;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;


public class Advantage {
	ArrayList<ArrayList<Integer>> AdvDie = new ArrayList<>();
	ArrayList<Integer> TempDie = new ArrayList<>();
	int Max;int Min;int MaxMax;int MaxMin;
	BigInteger[] Holder;
	int SetZero;int AdvTimes;int Looker;
	int[] ValueFinder;int[] Iterator;
	String temp;Boolean Checker;
		
	public Advantage() {
	}
	public ArrayList<ArrayList<Integer>> CalcAdvantage(ArrayList<ArrayList<Integer>>Die,String Info) {	
		temp = Info.replaceAll("avantage","");
		temp = temp.replaceAll("eis","");
		if(temp.isBlank()) {
			AdvTimes = 1;
		}else {
			AdvTimes = Integer.parseInt(temp);
		}
		Iterator = new int[AdvTimes+2];
		Arrays.fill(Iterator,0);
		AdvDie.add(new ArrayList<>());
		Extrema Extrema = new Extrema(Die);
		Min = Extrema.Min();Max = Extrema.Max();MaxMin = Extrema.MaxMin();MaxMax = Extrema.MaxMax();
		Sword Sword = new Sword(Die,Min,Max,MaxMin,MaxMax);
		Holder = Sword.Calc();
		ValueFinder = new int[Sword.Calc().length];
		SetZero = Sword.SetPoint();
		for(int i=SetZero;i<SetZero+Sword.Calc().length;i++) {				
			ValueFinder[i-SetZero] = i;
			}
		for(int Dist=0;ValueFinder.length>Dist;Dist++) {
			for(int Times=0;Holder[Dist].intValue()>Times;Times++) {
				TempDie.add(ValueFinder[Dist]);
			}
		}
		for(int SuperCounter=1;Math.pow(TempDie.size(),AdvTimes+1)>=SuperCounter;SuperCounter++) {
			Iterator[0] += 1;
			for(int Iter=0;Iter<Iterator.length-1;Iter++) {
				if(Iterator[Iter]>=TempDie.size()) {
					Iterator[Iter]=0;
					Iterator[Iter+1]+=1;
				}
			}
			Looker = TempDie.get(Iterator[0]);
			for(int MaxCan=0;MaxCan<Iterator.length-1;MaxCan++) {
				if(TempDie.get(Iterator[MaxCan])>Looker) {
					Looker = TempDie.get(Iterator[MaxCan]);
				}
			}
			AdvDie.get(0).add(Looker);
		}
		for(int Blank=0;Die.size()-1>Blank;Blank++) {
			AdvDie.add(new ArrayList<>());
			AdvDie.get(Blank+1).add(0);
		}
		return AdvDie;
	}
	
	public ArrayList<ArrayList<Integer>> CalcDisadvantage(ArrayList<ArrayList<Integer>>Die,String Info) {	
		temp = Info.replaceAll("advantage","");
		temp = temp.replaceAll("dis","");
		if(temp.isBlank()) {
			AdvTimes = 1;
		}else {
			AdvTimes = Integer.parseInt(temp);
		}
		Iterator = new int[AdvTimes+2];
		Arrays.fill(Iterator,0);
		AdvDie.add(new ArrayList<>());
		Extrema Extrema = new Extrema(Die);
		Min = Extrema.Min();Max = Extrema.Max();MaxMin = Extrema.MaxMin();MaxMax = Extrema.MaxMax();
		Sword Sword = new Sword(Die,Min,Max,MaxMin,MaxMax);
		Holder = Sword.Calc();
		ValueFinder = new int[Sword.Calc().length];
		SetZero = Sword.SetPoint();
		for(int i=SetZero;i<SetZero+Sword.Calc().length;i++) {				
			ValueFinder[i-SetZero] = i;
			}
		for(int Dist=0;ValueFinder.length>Dist;Dist++) {
			for(int Times=0;Holder[Dist].intValue()>Times;Times++) {
				TempDie.add(ValueFinder[Dist]);
			}
		}
		for(int SuperCounter=1;Math.pow(TempDie.size(),AdvTimes+1)>=SuperCounter;SuperCounter++) {
			Iterator[0] += 1;
			for(int Iter=0;Iter<Iterator.length-1;Iter++) {
				if(Iterator[Iter]>=TempDie.size()) {
					Iterator[Iter]=0;
					Iterator[Iter+1]+=1;
				}
			}
			Looker = TempDie.get(Iterator[0]);
			for(int MaxCan=0;MaxCan<Iterator.length-1;MaxCan++) {
				if(TempDie.get(Iterator[MaxCan])>Looker) {
					Looker = TempDie.get(Iterator[MaxCan]);
				}
			}
			AdvDie.get(0).add(Looker);
		}
		for(int Blank=0;Die.size()-1>Blank;Blank++) {
			AdvDie.add(new ArrayList<>());
			AdvDie.get(Blank+1).add(0);
		}
		return AdvDie;
	}
}