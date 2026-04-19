package pascalsSword;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SwordFinisher {
	SwordFinisher(){
		
	}
	//public int Divisor(String Input) {
		
	//}
	public BigInteger[] Runner(String Input) {
		int Max;int Min;int MaxMax;int MaxMin;String[] temp;int Depth = 0;int Times=0;int[] Location = new int[2];int TempLocation;int RightCount=0;String CurrentFunction;int DetectSize;int FunctionDiceAmount;BigInteger[] Returner;BigInteger[] ReturnerTwo;
		ArrayList<Integer> Die = new ArrayList<>(); //1drop(1d6)
		ArrayList<ArrayList<Integer>> Dice = new ArrayList<>();
		ArrayList<ArrayList<Integer>> FinalDice = new ArrayList<>();
		ArrayList<ArrayList<Integer>> FunctionHolder = new ArrayList<>(); //temp die storage
		ArrayList<String> FunctionList = new ArrayList<>();
		ArrayList<String> TempDie = new ArrayList<>();
		ArrayList<Integer> DetectorArray = new ArrayList<>();
		//define them functions:
		Drop Drop = new Drop();
		Remove Remove = new Remove();
		Multiplication Multiplication = new Multiplication();
		Half Half = new Half();
		DR DR = new DR();
		Vulnerability Vulnerability = new Vulnerability();
		Advantage Advantage = new Advantage();
		
		
		Scanner Jinput = new Scanner(System.in);
		//System.out.println("High level dice needs? (Yes/No)"); // COMENT THIS OUT IF YOU DON"T WANT ANNOYING MSGS
		/*String temper = (Jinput.nextLine()); //no spaces
		if(temper.toLowerCase().equals("yes")) {
			WindowDisplay.LOBO = true;
		}else {
			WindowDisplay.LOBO = false;
		}*/
		String storedInput = Input;
		//System.out.println(storedInput);
		storedInput = storedInput.replaceAll("D","d");
		storedInput = storedInput.replaceAll("-","+-");
		if(storedInput.charAt(0)=='+') {
			//System.out.println(storedInput);
			storedInput = storedInput.replaceFirst("\\+","");
			//System.out.println(storedInput);
		}
		storedInput = storedInput.toLowerCase();
		storedInput = storedInput.replaceAll("\\(","(!");
		storedInput = storedInput.replaceAll(" ","");
		storedInput = storedInput.replaceAll("multiply","mult");
		storedInput = storedInput.replaceAll("multiplication","mult");
		storedInput = storedInput.replaceAll("vulnerability","weak");
		storedInput = storedInput.replaceAll("vulnerable","weak");
		storedInput = storedInput.replaceAll("adv","advantage");
		storedInput = storedInput.replaceAll("advantage","avantage");//stupid d's
		storedInput = storedInput.replaceAll("dr","er");
		storedInput = storedInput.replaceAll("dis","eis");
		storedInput = storedInput.replaceAll("halfing","half");
		storedInput = storedInput.replaceAll("halving","half");

		
		
		
		if(storedInput.charAt(storedInput.length()-1) == '+'/*||storedInput.charAt(storedInput.length()-1) == ')'||storedInput.charAt(storedInput.length()-1) == '('*/) {
			storedInput = storedInput.substring(0,storedInput.length()-1);
		}
		String[] SuperElements = storedInput.split("\\(");
		for(int SuperElement = 0;SuperElements.length>SuperElement;SuperElement++) {
			String[] Elements = SuperElements[SuperElement].split("\\+"); //nDx notation (x can be a number or a "custom" set (if I make that)
			//System.out.println(Arrays.toString(Elements));
			// Hey so can we not delete this stuff again
			for(int sets = 1;sets<=Elements.length;sets++) { //when using sets in a list, use sets-1
				//System.out.println("ELEMENT: "+Elements[sets-1]);
				if(Elements[sets-1].toLowerCase().contains("!")){ //(
					temp = Elements[sets-1].split("d");
					//System.out.println("TEMP[0]: "+temp[0]);
					DetectorArray.add(Times);// NEVER EVER TYPE ((
					if(!(temp[0].replaceAll("!","").equals(""))&&!(temp[0].equals(""))) {
						//System.out.println(temp[0]);
						//System.out.println("YAY: "+Integer.toString(Integer.parseInt(temp[0].replaceAll("!",""))-1));
						if(!((temp[0]).toLowerCase().contains("erop"))&&!((temp[0]).toLowerCase().contains("remove"))&&!((temp[0]).toLowerCase().contains("mult"))&&!((temp[0]).toLowerCase().contains("half"))&&!((temp[0]).toLowerCase().contains("er"))&&!((temp[0]).toLowerCase().contains("weak"))&&!((temp[0]).toLowerCase().contains("eisavantage"))&&!((temp[0]).toLowerCase().contains("avantage"))){
							Times += Integer.parseInt(temp[0].replaceAll("!",""))-1;
						}
					}
					Depth += 1;
					//System.out.println("DEPTH (inc): "+Depth);
					DetectorArray.add(Depth);
					Elements[sets-1]=Elements[sets-1].replaceAll("!","");
				}if(Elements[sets-1].toLowerCase().contains(")")){
					//System.out.println("Times: "+Times);
					//System.out.println("Depth: "+Depth);
					RightCount=0;
					for (int Char=0; Char<Elements[sets-1].length(); Char++) {
				        if (Elements[sets-1].charAt(Char) == ')') {
				        	RightCount+=1;
				        }
				    }
					//System.out.println("RC: "+RightCount);
					if(RightCount>0) {
						for(int Right=0;Right<RightCount;Right++) {
							//System.out.println("Right: "+Right);
							DetectorArray.add(Times);//here
							DetectorArray.add(Depth);
							System.out.println("DEPTH (dec): "+Depth);
							Depth -= 1;
						}
					}
					//System.out.println(Elements[sets-1]);
					Elements[sets-1]=Elements[sets-1].replaceAll("\\)","");
					//System.out.println("Check: "+Elements[sets-1]);
					//System.out.println(Elements[sets-1]);
				}
				if(Elements[sets-1].toLowerCase().contains("erop")){ //oh contains is a function...
					FunctionList.add(Elements[sets-1].toLowerCase()); //passes so we can do function stuff later
					FunctionList.add(Integer.toString(Depth));
					continue;
				}else if(Elements[sets-1].toLowerCase().contains("remove")){
					FunctionList.add(Elements[sets-1].toLowerCase());
					FunctionList.add(Integer.toString(Depth));
					continue;
				}else if(Elements[sets-1].toLowerCase().contains("mult")){
					FunctionList.add(Elements[sets-1].toLowerCase());
					FunctionList.add(Integer.toString(Depth));
					continue;
				}else if(Elements[sets-1].toLowerCase().contains("half")){
					FunctionList.add(Elements[sets-1].toLowerCase());
					FunctionList.add(Integer.toString(Depth));
					continue;
				}else if(Elements[sets-1].toLowerCase().contains("er")){
					FunctionList.add(Elements[sets-1].toLowerCase());
					FunctionList.add(Integer.toString(Depth));
					continue;
				}else if(Elements[sets-1].toLowerCase().contains("weak")){
					FunctionList.add(Elements[sets-1].toLowerCase());
					FunctionList.add(Integer.toString(Depth));
					continue;
				}else if(Elements[sets-1].toLowerCase().contains("eisavantage")){
					FunctionList.add(Elements[sets-1].toLowerCase());
					FunctionList.add(Integer.toString(Depth));
					continue;
				}else if(Elements[sets-1].toLowerCase().contains("avantage")){
					FunctionList.add(Elements[sets-1].toLowerCase());
					FunctionList.add(Integer.toString(Depth));
					continue;
				}
				if(Elements[sets-1].replaceAll("d","") == Elements[sets-1]) {
					if(Elements[sets-1]!="") {
						Dice.add(new ArrayList<Integer>(Arrays.asList(Integer.parseInt(Elements[sets-1]))));
					}
				}else {
					String[] CurrentElements = Elements[sets-1].split("d");
					//System.out.println(Arrays.toString(CurrentElements));
					for(int times=0;times<Integer.parseInt(CurrentElements[0]);times++) {
						//System.out.println("times: "+times);
						CurrentElements[1]=CurrentElements[1].replaceAll("neg","-");
						if(CurrentElements[1].replaceAll("\\[","") == CurrentElements[1]) {
							for(int length = 1;length<=Integer.parseInt(CurrentElements[1]);length++) {
								Die.add(length);
								}
							Dice.add(new ArrayList<Integer>(Die));
							Die.clear();
							//System.out.println(Die);
						}else {
							TempDie = (new ArrayList<String>(Arrays.asList(CurrentElements[1].split(","))));
							//System.out.println(Arrays.toString(TempDie));
							for(int length=0;length<TempDie.size();length++) {
								if(Elements[sets-1]!="") {
									//System.out.println("Temp die: "+TempDie);
									Die.add(Integer.parseInt(TempDie.get(length).replaceAll("\\[","").replaceAll("\\]","")));
								}
							}
							Dice.add(new ArrayList<Integer>(Die));
							Die.clear();
						}
					}
				}
			Times += 1;
			}
		}
		FunctionLooker FunctionLooker = new FunctionLooker();
		if(DetectorArray.size()>=3) {
			DetectSize = DetectorArray.size();
			for(int Function = 0;Function<DetectSize;Function+=4) {
				//System.out.println("Detecor Array Size: "+DetectSize+"/"+Function);
				FunctionHolder.clear();
				TempLocation = FunctionLooker.CalcDeep(DetectorArray);
				Location[0]=DetectorArray.get(TempLocation);
				DetectorArray.remove(TempLocation+1);
				DetectorArray.remove(TempLocation);
				TempLocation = FunctionLooker.CalcDeep(DetectorArray);
				Location[1]=DetectorArray.get(TempLocation);
				DetectorArray.remove(TempLocation+1);
				DetectorArray.remove(TempLocation);
				TempLocation = FunctionLooker.CalcFunction(FunctionList);
				CurrentFunction=FunctionList.get(TempLocation);
				FunctionList.remove(TempLocation);
				FunctionList.remove(TempLocation);
		
				FunctionHolder = new ArrayList<ArrayList<Integer>>(Dice.subList((Location[0]),(Location[1]+1)));
				FunctionDiceAmount = Location[1]-Location[0]+1;
				if(CurrentFunction.contains("erop")) { //no work
					//System.out.println("DROPING");
					FunctionHolder = Drop.CalcDrop(FunctionHolder,CurrentFunction);
					for(int DroppedDice = 0;FunctionHolder.size()>DroppedDice;DroppedDice++) {
						if(FunctionHolder.get(DroppedDice).isEmpty()!=true) {
							Dice.set(Location[0]+DroppedDice,FunctionHolder.get(DroppedDice));
						}
					}
				}else if(CurrentFunction.contains("remove")){
					//System.out.println("REMOVING");
					FunctionHolder = Remove.CalcRemove(FunctionHolder,CurrentFunction);
					for(int DroppedDice = 0;FunctionHolder.size()>DroppedDice;DroppedDice++) {
						Dice.set(Location[0]+DroppedDice,FunctionHolder.get(DroppedDice));
					}
				}else if(CurrentFunction.contains("mult")){
					//System.out.println("Multiplying");
					FunctionHolder = Multiplication.CalcMultiplication(FunctionHolder,CurrentFunction);
					for(int FirstReplace=0;FunctionDiceAmount>FirstReplace;FirstReplace++) {
						for(int DroppedDice = 0;FunctionHolder.size()>DroppedDice;DroppedDice++) {
							Dice.set(Location[0]+DroppedDice,FunctionHolder.get(DroppedDice));
						}
					}
				}else if(CurrentFunction.contains("half")){
					//System.out.println("Halfing");
					FunctionHolder = Half.CalcHalf(FunctionHolder,CurrentFunction);
					for(int FirstReplace=0;FunctionDiceAmount>FirstReplace;FirstReplace++) {
						for(int DroppedDice = 0;FunctionHolder.size()>DroppedDice;DroppedDice++) {
							Dice.set(Location[0]+DroppedDice,FunctionHolder.get(DroppedDice));
						}
					}
				}else if(CurrentFunction.contains("er")){
					//System.out.println("DRing");
					FunctionHolder = DR.CalcDR(FunctionHolder,CurrentFunction);
					for(int FirstReplace=0;FunctionDiceAmount>FirstReplace;FirstReplace++) {
						for(int DroppedDice = 0;FunctionHolder.size()>DroppedDice;DroppedDice++) {
							Dice.set(Location[0]+DroppedDice,FunctionHolder.get(DroppedDice));
						}
					}
				}else if(CurrentFunction.contains("weak")){
					//System.out.println("weaking");
					FunctionHolder = Vulnerability.CalcVulnerability(FunctionHolder,CurrentFunction);
					for(int FirstReplace=0;FunctionDiceAmount>FirstReplace;FirstReplace++) {
						for(int DroppedDice = 0;FunctionHolder.size()>DroppedDice;DroppedDice++) {
							Dice.set(Location[0]+DroppedDice,FunctionHolder.get(DroppedDice));
						}
					}
				}else if(CurrentFunction.contains("eisavantage")){
					//System.out.println("disadvantaging");
					FunctionHolder = Advantage.CalcDisadvantage(FunctionHolder,CurrentFunction);
					for(int FirstReplace=0;FunctionDiceAmount>FirstReplace;FirstReplace++) {
						for(int DroppedDice = 0;FunctionHolder.size()>DroppedDice;DroppedDice++) {
							Dice.set(Location[0]+DroppedDice,FunctionHolder.get(DroppedDice));
						}
					}
				}else if(CurrentFunction.contains("avantage")){
					//System.out.println("advantaging");
					FunctionHolder = Advantage.CalcAdvantage(FunctionHolder,CurrentFunction);
					for(int FirstReplace=0;FunctionDiceAmount>FirstReplace;FirstReplace++) {
						for(int DroppedDice = 0;FunctionHolder.size()>DroppedDice;DroppedDice++) {
							Dice.set(Location[0]+DroppedDice,FunctionHolder.get(DroppedDice));
						}
					}
				}
			}
		}
		FinalDice = Dice;
		//System.out.println("Final Dice: "+FinalDice);
		Extrema Extrema = new Extrema(FinalDice);
		Min = Extrema.Min();Max = Extrema.Max();MaxMin = Extrema.MaxMin();MaxMax = Extrema.MaxMax();
		//System.out.println("Min: "+Min+"\nMax: "+Max);
		//System.out.println("MaxMin: "+MaxMin+"\nMaxMax: "+MaxMax);
		
		Sword Sword = new Sword(FinalDice,Min,Max,MaxMin,MaxMax);
		
		//Sword.speak();
		//System.out.println("Distribution Curve:    "+Arrays.toString(Sword.Calc()));
		
		// NOT NEEDED, but eh might use later:
		//int[] New = new int[Sword.Calc().length];
		int SetZero = Sword.SetPoint();
		
		/*System.out.println(SetZero);
		for(int i=SetZero;i<SetZero+Sword.Calc().length;i++) {				
			New[i-SetZero] = i;
			}*/
		//System.out.println("What each value means: "+Arrays.toString(New));
		Returner = Sword.Calc();
		ReturnerTwo = new BigInteger[Returner.length+1];
		for(int Setter = 0;Returner.length>Setter;Setter++) {
			ReturnerTwo[Setter] = Returner[Setter];
		}
		ReturnerTwo[Returner.length] = BigInteger.valueOf(Sword.SetPoint());
		//System.out.println(Arrays.toString(ReturnerTwo));
		
		return ReturnerTwo;
	}
}
