package pascalsSword;

import java.util.ArrayList;
import java.util.Arrays;

public class FunctionLooker {
	ArrayList<Integer> DetectorArray;
	int Location;
	int Depth;
	
	public int CalcDeep(ArrayList<Integer> DetectorArray) {
		Depth = -1;
		for(int Items = 1;Items<DetectorArray.size();Items+=2) {
			if (DetectorArray.get(Items) > Depth){
				Depth = DetectorArray.get(Items);
				Location = (Items-1);
			}
		}
		return Location;
			
	}
	public int CalcFunction(ArrayList<String> FunctionList) {
		Depth = Integer.parseInt(FunctionList.get(1))-1; //(0)+1
		//Location = 1;
		//System.out.println(DetectorArray.size());
		for(int Items = 1;Items<FunctionList.size();Items+=2) {//weird behavior with +
			if (Integer.parseInt(FunctionList.get(Items)) > Depth){//Higher Depth is prioitized
				Depth = Integer.parseInt(FunctionList.get(Items));
				Location = (Items-1);
			}
		}
		return Location;
	}
}
