package gui;

public class ActivityFactory {
	
	private static ActivityFactory instance;
	
	private ActivityFactory(){
	}
	
	
	public Activity getActivity(String type){
		if(type.equals("select-kanji")){
			return new SelectKanji();
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
