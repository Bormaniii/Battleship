import java.awt.Color;
import java.util.Random;

import javax.swing.*;

public class dzialanie {
	JButton[][] tablicaprzyciskow1;
	JSlider[] przesuwaki;
	JButton[][] tablicaprzyciskow;
	static boolean przegrana = false;
	int wys;
	int szer;
	
	public dzialanie() {};
	
	public dzialanie(JButton[][] tablicaprzyciskow, int wys, int szer) {
		this.tablicaprzyciskow=tablicaprzyciskow;
		this.wys=wys;
		this.szer=szer;
	}

	
	public dzialanie(JButton[][] tablicaprzyciskow1, JSlider[] przesuwaki, JButton[][] tablicaprzyciskow, int wys, int szer) {
		this.tablicaprzyciskow=tablicaprzyciskow;
		this.tablicaprzyciskow1=tablicaprzyciskow1;
		this.przesuwaki=przesuwaki;
		this.wys=wys;
		this.szer=szer;
	}
	
	
	
	void rozmieszczaniekomputera() {
		Random random = new Random();
		System.out.println("kupaaaa");
		//tworzenie potrzebnych komponentow
		JSlider ogran = new JSlider();
		ogran.setMaximum(5);
		ogran.setMinimum(0);
		ogran.setValue(0);
		JSlider ogran2 = new JSlider();
		ogran2.setValue(0);
		JSlider dlugoscstatku = new JSlider();
		dlugoscstatku.setValue(5);
		boolean koniec = false;
		boolean nowystatek = true;
		JSlider[] przesuwaki1 = new JSlider[5];
		for(int a=5;a>0;a--) {
			przesuwaki1[a-1] = new JSlider();
			przesuwaki1[a-1].setMinimum(0);
			przesuwaki1[a-1].setMaximum(a);
		}

		for(int a=0;a<5;a++){
			przesuwaki1[a].setValue(przesuwaki[a].getValue());
		}
		
		
		
		while(przesuwaki[ogran.getValue()].getValue()==0) {
			ogran.setValue(ogran.getValue()+1);
			}
			for(int c=0;c<5;c++) {
				if(ogran.getValue()>c) {
					dlugoscstatku.setValue(dlugoscstatku.getValue()-1);
				}
				if(ogran.getValue()==c) {
					ogran2.setValue(ogran2.getValue()+dlugoscstatku.getValue());
				}
			}
		
		
		
		//a tu bedzie sobie rozstawial
		
		
		while(koniec==false) {
			nowystatek=true;
			int sprawdzanie = 0;
			int aa = 0;
			int bb = 0;
			int zaduzo = 0;
			
			//sprawdza ile pol jest zajetych
			for(aa=0;aa<wys+1;aa++) {
				for(bb=0;bb<szer+1;bb++) {
					if(tablicaprzyciskow1[aa][bb].getBackground()==Color.GREEN) {
						sprawdzanie++;
					}
				}
			}
			

			System.out.println(sprawdzanie);
				
				
				//jesli nowy statek to zacznij gdzie chcesz
				if(nowystatek==true) {
					boolean pusto = false;
					int cc=0;
					while(pusto!=true) {
						//losuje pole
				aa = random.nextInt((wys-1)+1)+1;
				bb = random.nextInt((szer-1)+1)+1;
				zaduzo++;
					System.out.println(aa+" "+bb);
					if((tablicaprzyciskow1[aa][bb].getBackground()!=Color.GREEN) && (tablicaprzyciskow1[aa][bb].isEnabled()==true)) {
												
						pusto=true;
					cc = random.nextInt((4-1)+1)+1;
					System.out.println("cc "+cc);
					for(int c=0;c<dlugoscstatku.getValue();c++){
							if(cc==1) {
								if(aa+c<=wys) {
								if((tablicaprzyciskow1[aa+c][bb].getBackground()==Color.GREEN) || (tablicaprzyciskow1[aa+c][bb].isEnabled()==false)) {
							pusto=false;
							cc=0;
								}else{}
								}
							else {
									pusto=false;
									cc=0;
								}}
							if(cc==2) {
								if(aa-c>=1) {
								if((tablicaprzyciskow1[aa-c][bb].getBackground()==Color.GREEN) || (tablicaprzyciskow1[aa-c][bb].isEnabled()==false)) {
							pusto=false;
							
							cc=0;
								}else{}
								}
							else {
									pusto=false;
									cc=0;
								}}
							if(cc==3) {
								if(bb+c<=szer) {
								if((tablicaprzyciskow1[aa][bb+c].getBackground()==Color.GREEN) || (tablicaprzyciskow1[aa][bb+c].isEnabled()==false)) {
							pusto=false;
							cc=0;
								}else{}
								}
							else {
									pusto=false;
									cc=0;
								}}
							if(cc==4) {
								if(bb-c>=1) {
								if((tablicaprzyciskow1[aa][bb-c].getBackground()==Color.GREEN) || (tablicaprzyciskow1[aa][bb-c].isEnabled()==false)) {
							pusto=false;
							cc=0;
								}else{}
								}
							else {
									pusto=false;
									cc=0;
								}}						
					}
					}
					
					}
						
					
					System.out.println("cc "+cc);

					if((tablicaprzyciskow1[aa][bb].getBackground()!=Color.GREEN) && (tablicaprzyciskow1[aa][bb].isEnabled()==true)) {
								
					for(int c=0;c<dlugoscstatku.getValue();c++) {
					if(cc==1) {
						tablicaprzyciskow1[aa+c][bb].setBackground(Color.GREEN);
						System.out.println("dzialam");
						zaduzo=0;
					}
					if(cc==2) {
						tablicaprzyciskow1[aa-c][bb].setBackground(Color.GREEN);
						System.out.println("dzialam");
						zaduzo=0;
					}
					if(cc==3) {
						tablicaprzyciskow1[aa][bb+c].setBackground(Color.GREEN);
						System.out.println("dzialam");
						zaduzo=0;
					}
					if(cc==4) {
						tablicaprzyciskow1[aa][bb-c].setBackground(Color.GREEN);
						System.out.println("dzialam");
						zaduzo=0;
					}
					}															
				}}
				
				sprawdzanie=0;
				
				for(int a=0;a<wys+1;a++) {
					for(int b=0;b<szer+1;b++) {
						if(tablicaprzyciskow1[a][b].getBackground()==Color.GREEN) {
							sprawdzanie++;
						}
					}
				}		
				
				//sprawdza czy ilosc zaznaczonych pol jest rowna wymaganej ilosci w statkach
				if(sprawdzanie==ogran2.getValue()) {
					nowystatek = true;
					//blokuje pola obok
					for(int a=0;a<wys+1;a++) {
						for(int b=0;b<szer+1;b++) {										
							if(tablicaprzyciskow1[a][b].getBackground()==Color.GREEN) {
								if(a+1<=wys && b+1<=szer) {
								tablicaprzyciskow1[a+1][b+1].setEnabled(false);
								System.out.println("blok");
								}
								if(a+1<=wys) {
								tablicaprzyciskow1[a+1][b].setEnabled(false);
								tablicaprzyciskow1[a+1][b-1].setEnabled(false);
								tablicaprzyciskow1[a][b-1].setEnabled(false);
								tablicaprzyciskow1[a-1][b].setEnabled(false);
								tablicaprzyciskow1[a-1][b-1].setEnabled(false);
								System.out.println("blok");
								}
								if(b+1<=szer) {
								tablicaprzyciskow1[a][b+1].setEnabled(false);
								tablicaprzyciskow1[a-1][b+1].setEnabled(false);												
								tablicaprzyciskow1[a][b-1].setEnabled(false);
								tablicaprzyciskow1[a-1][b].setEnabled(false);
								tablicaprzyciskow1[a-1][b-1].setEnabled(false);
								System.out.println("blok");
							}}
						}}
					if(ogran.getValue()<5){
					//jesli tak, to zmniejsza ilosc statkow wciaz potrzebnych do rozlozenia
					przesuwaki[ogran.getValue()].setValue(przesuwaki[ogran.getValue()].getValue()-1);									
					
					//jesli wszystkie statki danego rozmiaru zostaly ustawione
					if(przesuwaki[ogran.getValue()].getValue()==0) {
						//zmniejsza dlugosc statku
						dlugoscstatku.setValue(dlugoscstatku.getValue()-1);
						//dzialanie pomijajace statki, ktorych gracz nie chcial w ogole
						int c = ogran.getValue();
						try {
							while(c!=4){
					if(przesuwaki[c+1].getValue()==0) {	
							ogran.setValue(ogran.getValue()+1);
							dlugoscstatku.setValue(dlugoscstatku.getValue()-1);
							c++;
						}
					else{
						c=4;
					}
							}	
						}catch(Exception q) {}
						
						//przechodzi do kolejnego statku
					ogran.setValue(ogran.getValue()+1);
					}}
					//zwieksza sume potrzebnych pol wzgledem statkow
					ogran2.setValue(ogran2.getValue()+dlugoscstatku.getValue());
					
					//sprawdza i konczy prace
				if(sprawdzanie==ogran2.getValue()) {
					
					koniec=true;
					}
				
				
				
				}
				System.out.println(dlugoscstatku.getValue());
				System.out.println(ogran.getValue());
				System.out.println(ogran2.getValue());
				System.out.println(zaduzo);
					
			if(zaduzo>wys*szer || sprawdzanie>ogran2.getValue()){
				for(aa=0;aa<wys+1;aa++) {
					for(bb=0;bb<szer+1;bb++) {
						tablicaprzyciskow1[aa][bb].setBackground(null);
						tablicaprzyciskow1[aa][bb].setEnabled(true);
					}}
				for(int a=0;a<5;a++){
					przesuwaki[a].setValue(przesuwaki1[a].getValue());
					System.out.println(przesuwaki[a].getValue());
						}
					
				
				ogran.setValue(0);
				ogran2.setValue(0);
				dlugoscstatku.setValue(5);
				koniec = false;
				nowystatek = true;
				System.out.println(zaduzo);
				
				while(przesuwaki[ogran.getValue()].getValue()==0) {
					ogran.setValue(ogran.getValue()+1);
					}
					for(int c=0;c<5;c++) {
						if(ogran.getValue()>c) {
							dlugoscstatku.setValue(dlugoscstatku.getValue()-1);
						}
						if(ogran.getValue()==c) {
							ogran2.setValue(ogran2.getValue()+dlugoscstatku.getValue());
						}
					}					
			}
			
		}
	}
	
	
	void ruchkomputera() throws InterruptedException{
		Random random = new Random();
		boolean ruch=true;
		boolean traf=false;
		while((ruch==true) && (!przegrana)) {
			traf=false;
			przegrana = true;
		//gry cos trafil i chce dobic
		for(int a=0;a<wys+1;a++) {
			for(int b=0;b<szer+1;b++) {
				if(tablicaprzyciskow[a][b].getBackground()==Color.BLACK){
					int c1 = 0;
					int c2 = 0;
					

					//sprawdza czy juz sie dowiedzial o pionowym/poziomym polozeniu i kontynuuje droge
					while((ruch==true) && ((c1==0) || (c2==0)) && (traf==false)){

						
					if((a+1<=wys) && (a-1>=1)){
					if((tablicaprzyciskow[a+1][b].getBackground()==Color.BLACK) && (tablicaprzyciskow[a-1][b].isEnabled()==true)) {
						if(tablicaprzyciskow[a-1][b].getBackground()==Color.GREEN) {
							tablicaprzyciskow[a-1][b].setBackground(Color.BLACK);
							tablicaprzyciskow[a-1][b].setEnabled(false);
							traf=true;
							ruch=false;
							
						}else {
							tablicaprzyciskow[a-1][b].setBackground(Color.RED);
							tablicaprzyciskow[a-1][b].setEnabled(false);
							ruch=false;
						}
					}
					else if((tablicaprzyciskow[a-1][b].getBackground()==Color.BLACK) && (tablicaprzyciskow[a+1][b].isEnabled()==true)) {
						if(tablicaprzyciskow[a+1][b].getBackground()==Color.GREEN) {
							tablicaprzyciskow[a+1][b].setBackground(Color.BLACK);
							tablicaprzyciskow[a+1][b].setEnabled(false);
							traf=true;
							ruch=false;
						}else {
							tablicaprzyciskow[a+1][b].setBackground(Color.RED);
							tablicaprzyciskow[a+1][b].setEnabled(false);
							ruch=false;
						}
					}else {
						c1=1;
					}}else {
						c1=1;
					}
					if((b+1<=szer) && (b-1>=1)) {
					if((tablicaprzyciskow[a][b+1].getBackground()==Color.BLACK) && (tablicaprzyciskow[a][b-1].isEnabled()==true)) {
						if(tablicaprzyciskow[a][b-1].getBackground()==Color.GREEN) {
							tablicaprzyciskow[a][b-1].setBackground(Color.BLACK);
							tablicaprzyciskow[a][b-1].setEnabled(false);
							traf=true;
							ruch=false;
						}else {
							tablicaprzyciskow[a][b-1].setBackground(Color.RED);
							tablicaprzyciskow[a][b-1].setEnabled(false);
							ruch=false;
						}
					}
					else if((tablicaprzyciskow[a][b-1].getBackground()==Color.BLACK) && (tablicaprzyciskow[a][b+1].isEnabled()==true)) {
						if(tablicaprzyciskow[a][b+1].getBackground()==Color.GREEN) {
							tablicaprzyciskow[a][b+1].setBackground(Color.BLACK);
							tablicaprzyciskow[a][b+1].setEnabled(false);
							traf=true;
							ruch=false;
						}else {
							tablicaprzyciskow[a][b+1].setBackground(Color.RED);
							tablicaprzyciskow[a][b+1].setEnabled(false);
							ruch=false;
						}
					}else {
						c2=1;
					}}else {
						c2=1;
					}

					System.out.println(c1+" chuj "+c2);
					System.out.println("ruch"+ruch);
					}}}}
					
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int c4 = 0;
		
		
					for(int a=0;a<wys+1;a++) {
						for(int b=0;b<szer+1;b++) {
							if(tablicaprzyciskow[a][b].getBackground()==Color.BLACK){								

					
					
					
					//szuka trafionych pol, aby atakowac dookola nich
					while((ruch==true) && ((c1==0) || (c2==0) || (c3==0) || (c4==0))){
					int cc = random.nextInt((4-1)+1)+1;
					System.out.println(c1+" "+c2+" "+c3+" "+c4);
					System.out.println("cc "+cc);
					if(cc==1){
						if(a+1<=wys){
							System.out.println("dziura");
						if(tablicaprzyciskow[a+1][b].isEnabled()==true){
							if(tablicaprzyciskow[a+1][b].getBackground()==Color.GREEN){
								tablicaprzyciskow[a+1][b].setBackground(Color.BLACK);
								tablicaprzyciskow[a+1][b].setEnabled(false);
								traf=true;
								ruch=false;
							}else {
								tablicaprzyciskow[a+1][b].setBackground(Color.RED);
								tablicaprzyciskow[a+1][b].setEnabled(false);
								ruch=false;
							}
						}else {
							c1=1;
						}
						}else {
							c1=1;
						}
					}
					if(cc==2){
						if(a-1>=1){
							System.out.println("dziura");
							if(tablicaprzyciskow[a-1][b].isEnabled()==true){
								if(tablicaprzyciskow[a-1][b].getBackground()==Color.GREEN){
									tablicaprzyciskow[a-1][b].setBackground(Color.BLACK);
									tablicaprzyciskow[a-1][b].setEnabled(false);
									traf=true;
									ruch=false;							
								}else {
									tablicaprzyciskow[a-1][b].setBackground(Color.RED);
									tablicaprzyciskow[a-1][b].setEnabled(false);
									ruch=false;
								}
							}else {
								c2=1;
							}		
						}else {
							c2=1;
						}
					}
					if(cc==3){
						System.out.println("dziura");
						if(b+1<=szer){
							if(tablicaprzyciskow[a][b+1].isEnabled()==true){
								if(tablicaprzyciskow[a][b+1].getBackground()==Color.GREEN){
									tablicaprzyciskow[a][b+1].setBackground(Color.BLACK);
									tablicaprzyciskow[a][b+1].setEnabled(false);
									traf=true;
									ruch=false;
								}else {
									tablicaprzyciskow[a][b+1].setBackground(Color.RED);
									tablicaprzyciskow[a][b+1].setEnabled(false);
									ruch=false;
								}
							}else {
								c3=1;
							}	
						}else {
							c3=1;
						}
					}
					if(cc==4){
						System.out.println("dziura");
						if(b-1>=1){
							if(tablicaprzyciskow[a][b-1].isEnabled()==true){
								if(tablicaprzyciskow[a][b-1].getBackground()==Color.GREEN){
									tablicaprzyciskow[a][b-1].setBackground(Color.BLACK);
									tablicaprzyciskow[a][b-1].setEnabled(false);
									traf=true;
									ruch=false;
								}else {
									tablicaprzyciskow[a][b-1].setBackground(Color.RED);
									tablicaprzyciskow[a][b-1].setEnabled(false);
									ruch=false;
								}
							}else {
								c4=1;
							}	
						}else {
							c4=1;
						}
					}
					
					}
					
					
				}
			}
		
	}
					
		//w momencie gdy nie ma nic trafionego i szuka
		while(ruch==true){
		int aa = random.nextInt((wys-1)+1)+1;
		int bb = random.nextInt((szer-1)+1)+1;
		if(tablicaprzyciskow[aa][bb].isEnabled()==true){
		if(tablicaprzyciskow[aa][bb].getBackground()==Color.GREEN){
			tablicaprzyciskow[aa][bb].setBackground(Color.BLACK);
			tablicaprzyciskow[aa][bb].setEnabled(false);
			ruch=false;
			traf=true;
		}else if(tablicaprzyciskow[aa][bb].getBackground()!=Color.GREEN){
			tablicaprzyciskow[aa][bb].setBackground(Color.RED);
			tablicaprzyciskow[aa][bb].setEnabled(false);
			ruch=false;
		}
		}
		}
		
		//blokowanko zatopionych
		for(int a=1;a<wys+1;a++) {
			for(int b=1;b<szer+1;b++) {
				if((tablicaprzyciskow[a][b].getBackground()==Color.BLACK) && (tablicaprzyciskow[a-1][b].getBackground()!=Color.GREEN) && 
						(tablicaprzyciskow[a][b-1].getBackground()!=Color.GREEN)) {
					int dlugosc=1;
					while((tablicaprzyciskow[a+dlugosc][b].getBackground()==Color.BLACK) && (a+dlugosc<=wys)) {
						dlugosc++;
					}//do zrobienia
					if((tablicaprzyciskow[a+dlugosc][b].getBackground()!=Color.GREEN) && (a+dlugosc+1<=wys) && 
							(tablicaprzyciskow[a][b+1].getBackground()!=Color.GREEN)) {
						for(int c = 0;c<dlugosc;c++) {
								tablicaprzyciskow[a-1][b].setEnabled(false);
								tablicaprzyciskow[a-1][b-1].setEnabled(false);
								tablicaprzyciskow[a+c][b-1].setEnabled(false);
								if(a+c+1<=wys && b+1<=szer) {
									tablicaprzyciskow[a+c+1][b].setEnabled(false);
									tablicaprzyciskow[a+c+1][b-1].setEnabled(false);
									tablicaprzyciskow[a+c+1][b+1].setEnabled(false);
								}
								if(b+1<=szer) {
									tablicaprzyciskow[a-1][b+1].setEnabled(false);
									tablicaprzyciskow[a+c][b+1].setEnabled(false);									
								}
								System.out.println("blok");
								
							tablicaprzyciskow[a+c][b].setBackground(Color.GRAY);
						}
					}
					dlugosc=1;
					while((tablicaprzyciskow[a][b+dlugosc].getBackground()==Color.BLACK) && (b+dlugosc<=szer)) {
						dlugosc++;
					}
					if((tablicaprzyciskow[a][b+dlugosc].getBackground()!=Color.GREEN) && (b+dlugosc+1<=szer) && 
							(tablicaprzyciskow[a+1][b].getBackground()!=Color.GREEN)) {
						for(int c = 0;c<dlugosc;c++) {
								tablicaprzyciskow[a][b-1].setEnabled(false);
								tablicaprzyciskow[a-1][b-1].setEnabled(false);
								tablicaprzyciskow[a-1][b+c].setEnabled(false);
								if(b+c+1<=szer && a+1<=wys) {
									tablicaprzyciskow[a][b+c+1].setEnabled(false);
									tablicaprzyciskow[a-1][b+c+1].setEnabled(false);
									tablicaprzyciskow[a+1][b+c+1].setEnabled(false);
								}
								if(a+1<=wys) {
									tablicaprzyciskow[a+1][b-1].setEnabled(false);
									tablicaprzyciskow[a+1][b+c].setEnabled(false);									
								
								System.out.println("blok");
								}	
							tablicaprzyciskow[a][b+c].setBackground(Color.GRAY);
								
						}
					}
					
				}
				if(tablicaprzyciskow[a][b].getBackground()==Color.GREEN) {
					przegrana=false;
				}
				
			}
		}
		
		if(traf==true) {
			System.out.println("dziura111");
			ruch=true;
		}
		
		if(przegrana) {
			JFrame przegrana = new JFrame("CIOTA!!!");
			przegrana.setSize(400, 400);
			przegrana.setLocation(100, 100);
			JLabel ciota = new JLabel("PRZEGRALES CIOTO!!!!");
			przegrana.add(ciota);
			przegrana.setVisible(true);
		}
		
	}
	}
}
