package pascalsSword;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Sword {
	ArrayList<ArrayList<Integer>> Dice;
	int Min;
	int Max;
	int MaxMin;
	int MaxMax;
	int SetZero;
	int LowerBound;
	int HigherBound;
	BigInteger[] Rolls;
	BigInteger[] TempRolls;
	BigInteger[] TimmedRolls;
	
	public Sword(ArrayList<ArrayList<Integer>> Dice,int Min,int Max,int MaxMin,int MaxMax){//this is a class
		this.Dice = Dice;
		this.Min = Min;
		this.Max = Max;
		this.MaxMin = MaxMin;
		this.MaxMax = MaxMax;
		}
		
	public void speak() {
		System.out.println("The Dice: "+Dice); //This is called a method
	}
	
	public int SetPoint() {
		if (MaxMin >= 0){
			SetZero = 1;
		}else {
			SetZero = Min;
			//System.out.println("WHYYY");
		}return SetZero;
	}
	
	public BigInteger[] Calc() {
		if (MaxMin > 0){
			Rolls = new BigInteger[MaxMax+1];
			TempRolls = new BigInteger[MaxMax+1];
			SetZero = 0;
		}else {
			Rolls = new BigInteger[MaxMax+1-MaxMin];
			TempRolls = new BigInteger[MaxMax+1-MaxMin];
			SetZero = Math.abs(MaxMin);
		}Arrays.fill(Rolls,BigInteger.valueOf(0));
		Arrays.fill(TempRolls,BigInteger.valueOf(0));		
		//System.out.println("thing:"+Arrays.toString(Rolls));
		Rolls[SetZero] = BigInteger.valueOf(1);
		//System.out.println("thing:"+Arrays.toString(Rolls));
		for(int Die=0;Dice.size()>Die;Die++) {
			for(int Side=0;Dice.get(Die).size()>Side;Side++) {
				for(int Sum=0;Sum<Rolls.length;Sum++) {
					if(Rolls[Sum]!=BigInteger.valueOf(0)) {
						TempRolls[Sum+Dice.get(Die).get(Side)]=TempRolls[Sum+Dice.get(Die).get(Side)].add(Rolls[Sum]);
					}			
				}
			}
			Rolls = Arrays.copyOf(TempRolls,TempRolls.length);
			//System.out.println(Arrays.toString(Rolls));
			Arrays.fill(TempRolls, BigInteger.valueOf(0));
		}
		for(int Lower=0;Lower<=SetZero+1;Lower++) {
			LowerBound = Lower;
			if(Rolls[Lower]!=BigInteger.valueOf(0)) {
				break;
			}
		}for(int Higher=Rolls.length-1;Higher>=0;Higher--) {
			if(Rolls[Higher]!=BigInteger.valueOf(0)) {
				HigherBound = Higher;
				//System.out.println("only once EH");
				break;
			}
		}
		BigInteger[] TrimmedRolls = new BigInteger[HigherBound-LowerBound];
		//System.out.println("lower bound: "+LowerBound);
		//System.out.println("higher bound: "+HigherBound);
		TrimmedRolls = Arrays.copyOfRange(Rolls,LowerBound,HigherBound+1);
		return TrimmedRolls;
	}
	
	
}
