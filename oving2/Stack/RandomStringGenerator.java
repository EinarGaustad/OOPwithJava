package oving2.Stack;
import java.util.Random;
/***
 * 
 * @ lage tilfeldige tekster
 */
public class RandomStringGenerator {
	//int tall;
	//int bokstaver;
	Random random=new Random();
	/**
	public RandomStringGenerator(String tall){
		if("tall"==tall.toLowerCase()||"number"==tall.toLowerCase()){
			this.tall=random.nextInt(1000);
		}
		else if("letter"==tall.toLowerCase()||"bokstaver"==tall.toLowerCase()){
			this.bokstaver=random.nextInt(1000);
		}
	}
	**/
	
	/***
	 * getRandomString
	 * @returner et tilfeldig String-objekt.
	 */
	public String getRandomString(){
		String s="";
		for (int i=0; i<(random.nextInt(10))+1;i++){
			//s+=(char)(random.nextInt(96)+33);
			//s+=(char)(random.nextInt(25)+65);
			//s+=(char)(random.nextInt(25)+97);
			s+=ord()+" ";	
		}
		//System.out.println(s);
		return s;
	}
	public String ord(){
		String o="";
		for (int i=0; i<(random.nextInt(5))+1;i++){
			if (random.nextInt(3)==1)// 25% sjance
				o+=vokaler();
			o+=konsonanter();		// 100%
			if (random.nextInt(1)==0)// 50% sjance
				o+=konsonanter();
			if (random.nextInt(3)==1)// 25% sjance
				o+=konsonanter();
			o+=vokaler();			//100%
			if (random.nextInt(9)==1)// 10% sjance
				o+=vokaler();
			if (random.nextInt(1)==0)// 50% sjance
				o+=konsonanter();
		}
		//System.out.println(o);
		return o;
	}
	public String konsonanter(){
		String k="";
		do{
			k=""+(char)(random.nextInt(25)+97);
		}while(k==vokaler());
		return k;
	}
	public String vokaler(){
		String v="";
		int tilfeldig=random.nextInt(8);
		switch(tilfeldig){
		case 0: v="a";
		break;
		case 1: v="e";
		break;
		case 2: v="i";
		break;
		case 3: v="o";
		break;
		case 4: v="u";
		break;
		case 5: v="y";
		break;
		case 6: v="æ";
		break;
		case 7: v="å";
		break;
		case 8: v="ø";
		break;
		}
		return v;
	}
}
