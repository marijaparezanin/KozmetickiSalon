package gui;


import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import datamanager.DataManager;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;

import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;
import net.miginfocom.swing.MigLayout;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = -8026416994513756565L;
	DataManager dm;
	String user;

	public MainFrame() {
		
	}

	public MainFrame(DataManager dm) {
		this.dm = dm;
		loginDialog();
	}
	
	private void loginDialog() {
		JDialog d = new JDialog();
		d.setTitle("Prijava");
		d.setLocationRelativeTo(null);
		d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		d.setResizable(false);
		initLoginGUI(d);
		d.pack();
		d.setLocationRelativeTo(null);	//centrira
		d.setVisible(true);		        

		
	}
	
	
	private void initLoginGUI(JDialog dialog) {
		/*
		 * Malo detaljnije podesavanje MigLayout-a: Drugi parametar (string) sadrzi 2
		 * prazne uglaste zagrade jer imamo 2 kolone (ovde nista nismo podesili) Treci
		 * parametar ima onoliko uglastih zagrada koliko imamo redova (u nasem slucaju
		 * 4) Unutar zagrada mozemo detaljnije podesavati kolone i redove, dok vrednosti
		 * izmedju njih predstavljaju razmake u pikselima. Ovde smo postavili razmak od
		 * 20px izmedju 1. i 2. i izmedju 3. i 4. reda.
		 */
		
		//wrap 2 znaci da svako dva elementa on prelazi u novi red
		MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[][]20[]");
		dialog.setLayout(layout);

		JTextField tfKorisnickoIme = new JTextField(20);
		JPasswordField pfLozinka = new JPasswordField(20);
		JButton btnOk = new JButton("OK");
		JButton btnRegister = new JButton("Registruj se");

		// Ako postavimo dugme 'btnOK' kao defaul button, onda ce svaki pritisak tastera
		// Enter na tastaturi
		// Izazvati klik na njega
		dialog.getRootPane().setDefaultButton(btnOk);

		dialog.add(new JLabel("Dobrodošli. Molimo da se prijavite."), "span 2");
		dialog.add(new JLabel("Korisničko ime"));
		dialog.add(tfKorisnickoIme);
		dialog.add(new JLabel("Šifra"));
		dialog.add(pfLozinka);
		dialog.add(new JLabel());
		dialog.add(btnOk, "split 2");
		dialog.add(btnRegister);

		// Klik na Login dugme
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String korisnickoIme = tfKorisnickoIme.getText().trim();
				String lozinka = new String(pfLozinka.getPassword()).trim();
				if(korisnickoIme.isEmpty() || lozinka.isEmpty()) {
					 JOptionPane.showMessageDialog(null, "Niste uneli sve podatke.");
				}
				else {
					if(dm.isValidKlijent(korisnickoIme, lozinka) != null) {
						dialog.setVisible(true);

					}else if(dm.isValidKozmeticar(korisnickoIme, lozinka)!= null) {
						dialog.setVisible(true);

					}else if(dm.isValidRecepcioner(korisnickoIme, lozinka)!= null) {
						dialog.setVisible(true);
						
					}else if(dm.isValidMenadzer(korisnickoIme, lozinka)!= null) {
						dialog.setVisible(false);
						MenadzerFrame m = new MenadzerFrame(dm, dm.isValidMenadzer(korisnickoIme, lozinka));
					}
					else {
						JOptionPane.showMessageDialog(null, "Nepostojeci korisnik.");
					}
				}
				
			}
		});
		
		// Cancel dugme samo sakriva trenutni prozor
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
				dialog.dispose();

				JDialog register = new JDialog();
				
				register.setTitle("Registracija");
				register.setLocationRelativeTo(null);
				register.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				register.setResizable(false);
		        register.setSize(600, 500);

				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
				register.setLayout(layout);

				JTextField rfKorIme = new JTextField(20);
				JTextField rfLozinka = new JTextField(20);
				JTextField rfIme = new JTextField(20);
				JTextField rfPrezime = new JTextField(20);
				String[] pol = {"zensko", "musko"};
				JComboBox<String> rfPol = new JComboBox<>(pol);
				JTextField rfBroj = new JTextField(20);
				JTextField rfGrad = new JTextField(20);
				
				JButton btnrOk = new JButton("Potvrdi");
				JButton btnrCancel = new JButton("Nazad");

				
				
				dialog.getRootPane().setDefaultButton(btnOk);

				register.add(new JLabel("Registracija"), "span 2, align center");
				register.add(new JLabel("Korisničko ime"), "cell 0 1");
				register.add(rfKorIme, "cell 1 1");
				register.add(new JLabel("Šifra"), "cell 0 2");
				register.add(rfLozinka, "cell 1 2");
				register.add(new JLabel("Ime"), "cell 0 3");
				register.add(rfIme, "cell 1 3");
				register.add(new JLabel("Prezime"), "cell 0 4");
				register.add(rfPrezime, "cell 1 4");
				register.add(new JLabel("Pol"), "cell 0 5");
				register.add(rfPol, "cell 1 5");
				register.add(new JLabel("Tel broj"), "cell 0 6");
				register.add(rfBroj, "cell 1 6");
				register.add(new JLabel("Adresa"), "cell 0 7");
				register.add(rfGrad, "cell 1 7");
				
				register.add(btnrOk,"cell 1 8");
				register.add(btnrCancel, "cell 1 8");
		        //The pack() method calculates the preferred size of the dialog based on its contents,
		        //so when i did this after setting it visible it shrunk because the dialog was empty
		        register.pack();
		        register.setLocationRelativeTo(null);	//centrira
		        register.setVisible(true);
		        
		        
		        btnrCancel.addActionListener(new ActionListener() {
		        	@Override
					public void actionPerformed(ActionEvent e) {
		        		register.setVisible(false);
		        		register.dispose();
		        		loginDialog();
		        	}
		        });
		        
		        
		        
		        btnrOk.addActionListener(new ActionListener() {
		        	@Override
					public void actionPerformed(ActionEvent e) {
						String rKorIme = rfKorIme.getText().trim();
						String rLozinka = rfLozinka.getText().trim();
						String rIme = rfIme.getText().trim();
						String rPrezime = rfPrezime.getText().trim();
						String rPol = (String) rfPol.getSelectedItem();
						String rBroj = rfBroj.getText().trim();
						String rGrad = rfGrad.getText().trim();
						if(dm.findUser(rKorIme, rLozinka) != null) {			
							JOptionPane.showMessageDialog(null, "Zauzeto korisnicko ime!");
						}else {
							register.setVisible(false);
							register.dispose();
							dm.addKlijent(rKorIme, rLozinka, rIme, rPrezime, rPol, rBroj, rGrad);
							//MenadzerFrame m = new MenadzerFrame(dm, dm.isValidMenadzer("1", "1"));

						}
		        		
		        	}
		        });
		        
		        
		        
			}
		});

	}
}

