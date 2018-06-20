import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ilosc {
JFrame start;
JPanel panel1;
	
	public ilosc(JFrame start, JPanel panel1,int wys,int szer)  {
		String[] nazwystatkow = new String[5];
		nazwystatkow[0] = "5-masztowiec:";
		nazwystatkow[1] = "4-masztowiec:";
		nazwystatkow[2] = "3-masztowiec:";
		nazwystatkow[3] = "2-masztowiec:";
		nazwystatkow[4] = "1-masztowiec:";
		JSlider[] przesuwaki = new JSlider[5];
		JLabel[] wyswietl = new JLabel[5];
		
		panel1.setVisible(false);
		start.remove(panel1);
		JPanel panel2 = new JPanel(new GridBagLayout());
		//Tworzenie komponentow
		JLabel ilosc = new JLabel("Wybierz ilosc statkow");
		JLabel pieciomaszt = new JLabel(nazwystatkow[0]);
		JLabel czteromaszt = new JLabel(nazwystatkow[1]);
		JLabel trojmaszt = new JLabel(nazwystatkow[2]);
		JLabel dwumasz = new JLabel(nazwystatkow[3]);
		JLabel jednomaszt = new JLabel(nazwystatkow[4]);
		JButton zapisz = new JButton("Zapisz");
		
		//dodawanie komponentow
		GridBagConstraints ogranicznik = new GridBagConstraints();
		ogranicznik.insets = new Insets(0, 0, 0, 0);
		ogranicznik.anchor = GridBagConstraints.NORTH;
		ogranicznik.gridx = 2;
		ogranicznik.gridy = 0;
		panel2.add(ilosc, ogranicznik);
		//5-masztowiec
		ogranicznik.insets = new Insets(10, 10, 10, 10);
		ogranicznik.gridy = 1;
		ogranicznik.gridx = 0;
		panel2.add(pieciomaszt, ogranicznik);
		//4-masztowiec
		ogranicznik.gridx = 1;
		panel2.add(czteromaszt, ogranicznik);
		//3-masztowiec
		ogranicznik.gridx = 2;
		panel2.add(trojmaszt, ogranicznik);
		//2-maszt
		ogranicznik.gridx = 3;
		panel2.add(dwumasz, ogranicznik);
		//1=maszt
		ogranicznik.gridx = 4;
		panel2.add(jednomaszt, ogranicznik);
		
		//Tworzenie przesowakow do wyboru
		for(int a=5;a>0;a--) {
			ogranicznik.gridy = 2;
			ogranicznik.gridx = a-1;
			przesuwaki[a-1] = new JSlider();
			przesuwaki[a-1].setMinimum(0);
			przesuwaki[a-1].setMaximum(a);
			panel2.add(przesuwaki[a-1], ogranicznik);
		}
		//mozliwosc sprawdzenia, ile statkow zostalo wybranych
		for(int a=5;a>0;a--) {
			ogranicznik.gridy = 3;
			ogranicznik.gridx = a-1;
			final int v = a-1;
			wyswietl[a-1] = new JLabel();
			wyswietl[a-1].setText("ilosc: "+Integer.toString(a));
			panel2.add(wyswietl[a-1], ogranicznik);
			
			przesuwaki[a-1].addChangeListener(new ChangeListener() {
				
				@Override
				public void stateChanged(ChangeEvent e) {
					wyswietl[v].setText("ilosc: "+Integer.toString(przesuwaki[v].getValue()));
					int test = 0;
					for(int a = 0;a<przesuwaki.length;a++) {
						if(przesuwaki[a].getValue()==0) {
							test++;
						}
					}
					if(test==5) {
						zapisz.setEnabled(false);
					}
					else {
						zapisz.setEnabled(true);
					}
				}
			});
		}
		//przycisk
		ogranicznik.gridy = 4;
		ogranicznik.gridx = 2;
		panel2.add(zapisz, ogranicznik);
		
		panel2.setSize(400, 600);
		panel2.setVisible(true);
		start.add(panel2);
		
		
		//funkcja przycisku
				zapisz.addActionListener(new ActionListener() {
					
					@Override
						public void actionPerformed(ActionEvent e) {						
						
						plansza nowa = new plansza(start, panel2, wys, szer, przesuwaki, nazwystatkow);
						
					}});
	}
}
