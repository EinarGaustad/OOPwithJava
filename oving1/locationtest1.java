package oving1;

public class locationtest1 {
	public static void main(String[] args){
		
		Location tabell [] = new Location [4];

		for (int i=0; i<4; i++){
			int tall = (int) (Math.random()*100+1);
			tabell [i] = new Location();

			int velg = (int) (Math.random()*4)+1;
			String flytteFra = null;
			switch (velg){
				case 1: flytteFra = "up y +";
						break;
				case 2: flytteFra = "down y -";
						break;
				case 3: flytteFra = "left x -";
						break;
				case 4: flytteFra = "right x +";
						break;
			}
			System.out.println("	flytte: "+flytteFra+" "+tall);
			
			for (int j=0; j<tall; j++){
				switch(velg){
					case 1: tabell[i].up();
							break;
					case 2: tabell[i].down();
							break;
					case 3: tabell[i].left();
							break;
					case 4: tabell[i].right();
							break;
				}
			}
			System.out.println(tabell[i].toString());
		}
	}
}
