package core;

import java.io.IOException;
import java.util.Random;

import database.Conexion;

public class SelectKanji {
	
	private Conexion cn;
	
	public SelectKanji() throws IOException{
		cn = Conexion.getInstance();
	}
	public String[] getExcercise() {
		String[] res = new String[6];
		Random rnd = new Random(System.currentTimeMillis());
		int id = rnd.nextInt(cn.size());
		res[0] = cn.get(id).get_kanji();
		res[5] = cn.get(id).get_lecture(rnd.nextInt(cn.get(id).get_lectures().size()));
		res[1] = res[5];
		res[2] = cn.get_lecture(rnd.nextInt(cn.total_lectures()));
		res[3] = cn.get_lecture(rnd.nextInt(cn.total_lectures()));
		res[4] = cn.get_lecture(rnd.nextInt(cn.total_lectures()));
		for(int x=0;x<=4;++x){
			int i = rnd.nextInt(4);
			int j = rnd.nextInt(4);
			String tmp = res[i+1];
			res[i+1] = res[j+1];
			res[j+1] = tmp;
		}
		return res;
	}
}
