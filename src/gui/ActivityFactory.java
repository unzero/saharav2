package gui;

public class ActivityFactory {
	
	private static ActivityFactory instance;
	
	private ActivityFactory(){
	}
	
	
	public Activity getActivity(String type){
		if(type.equals("select-kanji")){
			return new SelectKanji();
		}
		if(type.equals("visual-timer")){
			return new VisualTimer(10,1);
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
