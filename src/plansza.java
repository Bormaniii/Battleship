import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class plansza {
	JFrame start;
	JPanel panel2;
	static boolean nowystatek = true;
	static boolean pierwszyruch = true;
	static boolean zakaz = false;
	static boolean wygrana = false;
	static dzialanie komputer = new dzialanie();
	
	public plansza(JFrame start, JPanel panel2, int wys, int szer, JSlider[] przesuwaki, String[] nazwystatkow) {

		zapiszodczyt zapis = new zapiszodczyt();
		
		
		JButton[][] tablicaprzyciskow = new JButton[wys+1][szer+1];
		JButton[][] tablicaprzyciskow1 = new JButton[wys+1][szer+1];
		JButton[][] ukrytykomp = new JButton[wys+1][szer+1]; 
		
		
		panel2.setVisible(false);
		start.remove(panel2);
		
		//tworzenie komponentow
		JButton legenda = new JButton("Legenda");
		JButton zapisz = new JButton("Zapisz gre");
		JPanel panel3 = new JPanel(new GridBagLayout());
		JPanel komp = new JPanel(new GridLayout(wys+1, szer+1));
		JPanel gracz = new JPanel(new GridLayout(wys+1, szer+1));
		JLabel kom = new JLabel("komputer");
		JLabel grac = new JLabel("gracz");
		JLabel rozmiesc = new JLabel("Wskaz, gdzie umiescic:");
		JLabel rozmiesc2 = new JLabel();
		//moge go uzywac nizej
		JSlider ogran = new JSlider();
		ogran.setMaximum(5);
		ogran.setMinimum(0);
		ogran.setValue(0);
		JSlider ogran2 = new JSlider();
		ogran2.setValue(0);
		JSlider dlugoscstatku = new JSlider();
		dlugoscstatku.setValue(5);
		
		
				
		//tworzenie pol
		for(int a=0;a<wys+1;a++) {
			for(int b=0;b<szer+1;b++) {
				//Tworzenie przycisku
					final int v =a;
					final int vv =b;
				tablicaprzyciskow[a][b] = new JButton();
				if(a==0) {
					tablicaprzyciskow[a][b].setText(Integer.toString(b));
					tablicaprzyciskow[a][b].setBorderPainted(false);
				}
				if(b==0) {
					tablicaprzyciskow[a][b].setText(Integer.toString(a));
					tablicaprzyciskow[a][b].setBorderPainted(false);
				}
				gracz.add(tablicaprzyciskow[a][b]);
			}}
		
		
		for(int a=0;a<wys+1;a++) {
			for(int b=0;b<szer+1;b++) {
				//Tworzenie przycisku
					final int v =a;
					final int vv =b;
				tablicaprzyciskow1[a][b] = new JButton();
				ukrytykomp[a][b] = new JButton();
				if(a==0) {
					tablicaprzyciskow1[a][b].setText(Integer.toString(b));
					tablicaprzyciskow1[a][b].setBorderPainted(false);
					ukrytykomp[a][b].setText(Integer.toString(b));
					ukrytykomp[a][b].setBorderPainted(false);
				}
				if(b==0) {
					tablicaprzyciskow1[a][b].setText(Integer.toString(a));
					tablicaprzyciskow1[a][b].setBorderPainted(false);
					ukrytykomp[a][b].setText(Integer.toString(a));
					ukrytykomp[a][b].setBorderPainted(false);
				}
				komp.add(ukrytykomp[a][b]);
			}}
		
		if(menu.wczyt) {
			zapiszodczyt wczyt = new zapiszodczyt ();
			try {
				wczyt.odczyt();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JButton[][] fikcyjny = new JButton[wys+1][szer+1];
			
			for(int a=0;a<wys+1;a++) {
				for(int b=0;b<szer+1;b++) {		
					fikcyjny[a][b] = new JButton();
		tablicaprzyciskow[a][b].setBackground(zapiszodczyt.tablicaprzyciskow[a][b].getBackground());
		tablicaprzyciskow1[a][b].setBackground(zapiszodczyt.tablicaprzyciskow1[a][b].getBackground());
		
		if((tablicaprzyciskow1[a][b].getBackground()==Color.BLACK) || (tablicaprzyciskow1[a][b].getBackground()==Color.RED)) {
			ukrytykomp[a][b].setBackground(tablicaprzyciskow1[a][b].getBackground());
		}
		
				}}
			
			komputer = new dzialanie(tablicaprzyciskow, wys, szer);		
			
			blokowanie(wys, szer, tablicaprzyciskow1, ukrytykomp);
			blokowanie(wys, szer, tablicaprzyciskow, fikcyjny);
			
		}

		
		//dodawanie komponentow
		GridBagConstraints ogranicznik = new GridBagConstraints();
		ogranicznik.insets = new Insets(10, 10, 10, 10);
		ogranicznik.gridy = 0;
		ogranicznik.gridx = 0;
		ogranicznik.weightx = 1;
		ogranicznik.weighty = 1;
		panel3.add(legenda, ogranicznik);
		
		ogranicznik.gridy = 1;
		panel3.add(komp, ogranicznik);
		ogranicznik.gridy = 2;
		panel3.add(kom, ogranicznik);
		ogranicznik.gridy = 3;
		panel3.add(rozmiesc, ogranicznik);
		
		ogranicznik.gridy = 0;
		ogranicznik.gridx = 1;
		panel3.add(zapisz, ogranicznik);
		ogranicznik.gridy = 1;
		panel3.add(gracz, ogranicznik);
		ogranicznik.gridy = 2;
		panel3.add(grac, ogranicznik);
		ogranicznik.gridy = 3;
		panel3.add(rozmiesc2, ogranicznik);
		//koniec dodawania

		
		if(menu.wczyt==false) {
			
			//komponenty pod komputer

			JSlider[] przesuwaki1 = new JSlider[5];
			for(int a=5;a>0;a--) {
				przesuwaki1[a-1] = new JSlider();
				przesuwaki1[a-1].setMinimum(0);
				przesuwaki1[a-1].setMaximum(a);
			}

			for(int a=0;a<5;a++){
				przesuwaki1[a].setValue(przesuwaki[a].getValue());
			}
			
			//ruch komputera
			komputer = new dzialanie(tablicaprzyciskow1, przesuwaki1, tablicaprzyciskow, wys, szer);

			
			
		
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
		
		rozmiesc2.setText(nazwystatkow[ogran.getValue()]+ " sztuk: "+przesuwaki[ogran.getValue()].getValue());
		
		
		//rozmieszczanie statkow gracza
			for(int a=0;a<wys+1;a++) {
				for(int b=0;b<szer+1;b++) {
					//Tworzenie przycisku
						final int v =a;
						final int vv =b;
						if(menu.wczyt==false) {
						tablicaprzyciskow[a][b].addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								System.out.println(tablicaprzyciskow.length);
										int sprawdzanie = 0;
										
																		
										
										
										//sprawdza ile pol jest zajetych
										for(int a=0;a<wys+1;a++) {
											for(int b=0;b<szer+1;b++) {
												if(tablicaprzyciskow[a][b].getBackground()==Color.GREEN) {
													sprawdzanie++;
												}
											}
										}
										
										//sprawdza czy to juz nowy statek
										if(sprawdzanie==ogran2.getValue()) {
											nowystatek=false;
										}
										if(zakaz==false) {
											//pierwszy ruch
											if(pierwszyruch==true) {
												if(v!=0 && vv!=0) {
													tablicaprzyciskow[v][vv].setBackground(Color.GREEN);													
													pierwszyruch=false;
													nowystatek=false;
													System.out.println("kupa");
												}												
												}
											
											
											//jesli nowy statek to zacznij w innym pustym polu
											if(nowystatek==true) {
												if(v!=0 && vv!=0) {
												tablicaprzyciskow[v][vv].setBackground(Color.GREEN);													
												nowystatek=false;
												System.out.println("kupa1");												
											}}
											
											
											
												//drugie pole
											
											if(sprawdzanie==ogran2.getValue()-dlugoscstatku.getValue()+1 || sprawdzanie==1){
												System.out.println("kupa2");
												if(v!=0 && vv!=0) {
													if(v+1>tablicaprzyciskow.length-1) {
													if(tablicaprzyciskow[v-1][vv].getBackground()==Color.GREEN ||
															tablicaprzyciskow[v][vv+1].getBackground()==Color.GREEN ||
															tablicaprzyciskow[v][vv-1].getBackground()==Color.GREEN) {
														tablicaprzyciskow[v][vv].setBackground(Color.GREEN);
													}}else if(vv+1>tablicaprzyciskow.length-1){
														if(tablicaprzyciskow[v+1][vv].getBackground()==Color.GREEN ||
																tablicaprzyciskow[v-1][vv].getBackground()==Color.GREEN ||
																tablicaprzyciskow[v][vv-1].getBackground()==Color.GREEN) {
															tablicaprzyciskow[v][vv].setBackground(Color.GREEN);
														}
													}else {
														if(tablicaprzyciskow[v-1][vv].getBackground()==Color.GREEN || 
																tablicaprzyciskow[v+1][vv].getBackground()==Color.GREEN ||
																tablicaprzyciskow[v-1][vv].getBackground()==Color.GREEN ||
																tablicaprzyciskow[v][vv-1].getBackground()==Color.GREEN ||
																tablicaprzyciskow[v][vv+1].getBackground()==Color.GREEN ||
																tablicaprzyciskow[v][vv-1].getBackground()==Color.GREEN) {
															tablicaprzyciskow[v][vv].setBackground(Color.GREEN);
														}								
													}													
													}
												}else {
												//kolejne pola											
												if(v!=0 && vv!=0) {
										
											System.out.println("kupa3");
											System.out.println(v+" "+vv);
												System.out.println("kupa3");
												if(v-2>=0) {
											if(tablicaprzyciskow[v-2][vv].getBackground()==Color.GREEN) {
												if(tablicaprzyciskow[v-1][vv].getBackground()==Color.GREEN) {
												tablicaprzyciskow[v][vv].setBackground(Color.GREEN);
											}}}
												if(v+2<=wys) {
											if(tablicaprzyciskow[v+2][vv].getBackground()==Color.GREEN) {
												if(tablicaprzyciskow[v+1][vv].getBackground()==Color.GREEN) {
												tablicaprzyciskow[v][vv].setBackground(Color.GREEN);
											}}}
											if(vv-2>=0) {
											if(tablicaprzyciskow[v][vv-2].getBackground()==Color.GREEN) {
												if(tablicaprzyciskow[v][vv-1].getBackground()==Color.GREEN) {
												tablicaprzyciskow[v][vv].setBackground(Color.GREEN);
											}}}
											if(vv+2<=szer) {
											if(tablicaprzyciskow[v][vv+2].getBackground()==Color.GREEN) {
												if(tablicaprzyciskow[v][vv+1].getBackground()==Color.GREEN) {
												tablicaprzyciskow[v][vv].setBackground(Color.GREEN);											
										}}}
											
											}}
											sprawdzanie=0;
											
											for(int a=0;a<wys+1;a++) {
												for(int b=0;b<szer+1;b++) {
													if(tablicaprzyciskow[a][b].getBackground()==Color.GREEN) {
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
											if(tablicaprzyciskow[a][b].getBackground()==Color.GREEN) {
												if(a+1<=wys && b+1<=szer) {
												tablicaprzyciskow[a+1][b+1].setEnabled(false);
												}
												if(a+1<=wys) {
												tablicaprzyciskow[a+1][b].setEnabled(false);
												tablicaprzyciskow[a+1][b-1].setEnabled(false);
												tablicaprzyciskow[a][b-1].setEnabled(false);
												tablicaprzyciskow[a-1][b].setEnabled(false);
												tablicaprzyciskow[a-1][b-1].setEnabled(false);
												}
												if(b+1<=szer) {
												tablicaprzyciskow[a][b+1].setEnabled(false);
												tablicaprzyciskow[a-1][b+1].setEnabled(false);												
												tablicaprzyciskow[a][b-1].setEnabled(false);
												tablicaprzyciskow[a-1][b].setEnabled(false);
												tablicaprzyciskow[a-1][b-1].setEnabled(false);
											}}
										}}
									
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
									}
									//zwieksza sume potrzebnych pol wzgledem statkow
									ogran2.setValue(ogran2.getValue()+dlugoscstatku.getValue());
								try {
									//zmienia instrukcje ile statkow jeszcze
								rozmiesc2.setText(nazwystatkow[ogran.getValue()]+ " sztuk: "+przesuwaki[ogran.getValue()].getValue());
								}catch(Exception q) {
									
									//konczy prace, przekazuje paleczke komputerowi
									rozmiesc2.setText("Teraz atakuj pole komputera");
									for(int a=0;a<wys+1;a++) {
										for(int b=0;b<szer+1;b++) {
											tablicaprzyciskow[a][b].setEnabled(true);
										}}
									
									
									
									zakaz=true;
									komputer.rozmieszczaniekomputera();
									for(int a=0;a<wys+1;a++) {
										for(int b=0;b<szer+1;b++) {
											tablicaprzyciskow1[a][b].setEnabled(true);
										}
									
								}
									rozmiesc.setText("Brawo! Rozmiesciles wszystkie statki!");
								}
								}}
							System.out.println(dlugoscstatku.getValue());
							System.out.println(ogran.getValue());
							System.out.println(ogran2.getValue());
							System.out.println(sprawdzanie);
							
							}
						});
						}}
						
			}}
		else {
			rozmiesc.setText("Pomyslnie wczytano gre");
		}

				for(int a=0;a<wys+1;a++) {
					for(int b=0;b<szer+1;b++) {
						//Tworzenie przycisku
							final int v =a;
							final int vv =b;
						
						
						ukrytykomp[a][b].addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								if(!wygrana) {
								
								if(tablicaprzyciskow1[v][vv].getBackground()==Color.GREEN){
									ukrytykomp[v][vv].setBackground(Color.BLACK);
									ukrytykomp[v][vv].setEnabled(false);
									tablicaprzyciskow1[v][vv].setBackground(Color.BLACK);
									tablicaprzyciskow1[v][vv].setEnabled(false);
									
									wygrana=true;
									//blokowanko zatopionych
									
									blokowanie(wys, szer, tablicaprzyciskow1, ukrytykomp);
									
									
									
								}else{
									tablicaprzyciskow1[v][vv].setBackground(Color.RED);
									tablicaprzyciskow1[v][vv].setEnabled(false);
									ukrytykomp[v][vv].setBackground(Color.RED);
									ukrytykomp[v][vv].setEnabled(false);
									try {
										komputer.ruchkomputera();
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
																								
								}
								if(wygrana) {
									JFrame wygrana = new JFrame("BRAWO!!!");
									wygrana.setSize(400, 400);
									wygrana.setLocation(100, 100);
									JLabel brawo = new JLabel("BRAWO!!! WYGRALES!!!");
									wygrana.add(brawo);
									wygrana.setVisible(true);
								}
								
								
								
						
							}
							});
		}}
													
		
		
		
		komp.setVisible(true);
		gracz.setVisible(true);
		panel3.setVisible(true);
		start.add(panel3);
		
		//legenda
		legenda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				legenda legend = new legenda();
			}
		
		
		});
		
		
		
zapisz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					zapis.zapisz(tablicaprzyciskow, tablicaprzyciskow1, wys, szer);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		
		
		});
	}
	
	
	void blokowanie(int wys, int szer, JButton[][] tablicaprzyciskow1, JButton[][] ukrytykomp) {
		//blokowanko zatopionych
		for(int a=1;a<wys+1;a++) {
			for(int b=1;b<szer+1;b++) {
				if((tablicaprzyciskow1[a][b].getBackground()==Color.BLACK) && 
						(tablicaprzyciskow1[a-1][b].getBackground()!=Color.GREEN) && 
						(tablicaprzyciskow1[a][b-1].getBackground()!=Color.GREEN)) {
					
					boolean koniecmapy = false;
					int dlugosc=1;
					while((a+dlugosc<=wys) && (tablicaprzyciskow1[a+dlugosc][b].getBackground()==Color.BLACK) && (!koniecmapy)) {
						dlugosc++;
						if(a+dlugosc>wys) {
							koniecmapy=true;
						}
					}
					if(b+1<=szer) {
					if((a+dlugosc<=wys) && (tablicaprzyciskow1[a+dlugosc][b].getBackground()!=Color.GREEN) && 
							(tablicaprzyciskow1[a][b+1].getBackground()!=Color.GREEN)) {
						for(int c = 0;c<dlugosc;c++) {
								tablicaprzyciskow1[a-1][b].setEnabled(false);
								tablicaprzyciskow1[a-1][b-1].setEnabled(false);
								tablicaprzyciskow1[a+c][b-1].setEnabled(false);
								ukrytykomp[a-1][b].setEnabled(false);
								ukrytykomp[a-1][b-1].setEnabled(false);
								ukrytykomp[a+c][b-1].setEnabled(false);
								if(a+c+1<=wys && b+1<=szer) {
									tablicaprzyciskow1[a+c+1][b].setEnabled(false);
									tablicaprzyciskow1[a+c+1][b-1].setEnabled(false);
									tablicaprzyciskow1[a+c+1][b+1].setEnabled(false);
									ukrytykomp[a+c+1][b].setEnabled(false);
									ukrytykomp[a+c+1][b-1].setEnabled(false);
									ukrytykomp[a+c+1][b+1].setEnabled(false);
								}
								if(b+1<=szer) {
									tablicaprzyciskow1[a-1][b+1].setEnabled(false);
									tablicaprzyciskow1[a+c][b+1].setEnabled(false);		
									ukrytykomp[a-1][b+1].setEnabled(false);
									ukrytykomp[a+c][b+1].setEnabled(false);									
								}
								System.out.println("blok");
								
							tablicaprzyciskow1[a+c][b].setBackground(Color.GRAY);
							ukrytykomp[a+c][b].setBackground(Color.GRAY);
						}
					}}
					
					
					dlugosc=1;
					koniecmapy = false;
					while((b+dlugosc<=szer) && (tablicaprzyciskow1[a][b+dlugosc].getBackground()==Color.BLACK) && (!koniecmapy)) {
						dlugosc++;
						if(b+dlugosc>szer) {
							koniecmapy=true;
							
						}
					}
					if(a+1<=wys) {
					if((b+dlugosc<=szer) && (tablicaprzyciskow1[a][b+dlugosc].getBackground()!=Color.GREEN) && 
							(tablicaprzyciskow1[a+1][b].getBackground()!=Color.GREEN)) {
						for(int c = 0;c<dlugosc;c++) {
								tablicaprzyciskow1[a][b-1].setEnabled(false);
								tablicaprzyciskow1[a-1][b-1].setEnabled(false);
								tablicaprzyciskow1[a-1][b+c].setEnabled(false);
								ukrytykomp[a][b-1].setEnabled(false);
								ukrytykomp[a-1][b-1].setEnabled(false);
								ukrytykomp[a-1][b+c].setEnabled(false);
								if(b+c+1<=szer && a+1<=wys) {
									tablicaprzyciskow1[a][b+c+1].setEnabled(false);
									tablicaprzyciskow1[a-1][b+c+1].setEnabled(false);
									tablicaprzyciskow1[a+1][b+c+1].setEnabled(false);
									ukrytykomp[a][b+c+1].setEnabled(false);
									ukrytykomp[a-1][b+c+1].setEnabled(false);
									ukrytykomp[a+1][b+c+1].setEnabled(false);
								}
								if(a+1<=wys) {
									tablicaprzyciskow1[a+1][b-1].setEnabled(false);
									tablicaprzyciskow1[a+1][b+c].setEnabled(false);	
									ukrytykomp[a+1][b-1].setEnabled(false);
									ukrytykomp[a+1][b+c].setEnabled(false);											
								
								System.out.println("blok");
								}	
							tablicaprzyciskow1[a][b+c].setBackground(Color.GRAY);	
							ukrytykomp[a][b+c].setBackground(Color.GRAY);							
						}
					}}
					
				}
				if(tablicaprzyciskow1[a][b].getBackground()==Color.GREEN) {
					wygrana=false;
				}
			}
		}
	}
}
