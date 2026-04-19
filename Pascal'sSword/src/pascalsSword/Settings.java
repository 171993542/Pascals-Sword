package pascalsSword;

public enum Settings {
	BarGap("Auto"),
	BarWidth("Auto"),
	BarBorderSize("Auto"),
	ShowValues("On"),
	ShowProbabilityValues("On"),
	AutoExport("Off");
	
	String Setting;
	Settings (String Setting){
		this.Setting = Setting;
	}
}
