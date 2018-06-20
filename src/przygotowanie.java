import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class przygotowanie {
JFrame start;
JPanel panel;
	


public przygotowanie(JFrame start, JPanel panel)  {
	panel.setVisible(false);
	start.remove(panel);
	JPanel panel1 = new JPanel(new GridBagLayout());
	//tworzenie komponentow
	JLabel wielkosc = new JLabel("WYBIERZ WIELKOSC PLANSZY");
	JButton mala = new JButton("12x12");
	JButton srednia = new JButton("16x16");
	JButton duza = new JButton("24x24");
	
	//dodawanie komponentow
	GridBagConstraints ogranicznik = new GridBagConstraints();
	ogranicznik.insets = new Insets(0, 0, 0, 0);
	ogranicznik.anchor = GridBagConstraints.NORTH;
	ogranicznik.ipady = 40;
	ogranicznik.gridx = 1;
	ogranicznik.gridy = 0;
	panel1.add(wielkosc, ogranicznik);
	
	ogranicznik.fill = GridBagConstraints.CENTER;
	ogranicznik.ipady = 0;
	ogranicznik.gridx = 0;
	ogranicznik.gridy = 1;
	panel1.add(mala,ogranicznik);
	
	ogranicznik.gridx = 1;
	ogranicznik.gridy = 1;
	panel1.add(srednia, ogranicznik);
	
	ogranicznik.gridx = 2;
	panel1.add(duza, ogranicznik);
	
	panel1.setVisible(true);
	start.add(panel1);
	//koniec dodawania
	
	//wybory wielkosci planszy
	mala.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int wys = 12;
			int szer = 12;
			
			ilosc mala = new ilosc(start, panel1, wys, szer);
		}
		
		
	});
	
	srednia.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int wys = 16;
			int szer = 16;
			
			ilosc srednia = new ilosc(start, panel1, wys, szer);
		}
		
		
	});

	duza.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
		
			int wys = 18;
			int szer = 18;
		
			ilosc duza = new ilosc(start, panel1, wys, szer);
		}
	
	
	});
}
}
