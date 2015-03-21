package gui;

public class ActivityFactory {
	
	private static ActivityFactory instance;
	
	private ActivityFactory(){
	}
	
	
	public Activity getActivity(String type){
		if(type.equals("select-kanji")){
			return new SelectKanji();
		}else if(type.equals("visual-timer")){
			return new VisualTimer(10,1);
		}else if(type.equals("configuration")){
			return new ConfigurationWindow();
		}
		return null;
	}
	
	public static ActivityFactory getInstance(){
		if( instance == null){
			instance = new ActivityFactory();
		}
		return instance;
	}

}
