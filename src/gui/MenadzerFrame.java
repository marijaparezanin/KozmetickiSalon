package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import customTableModels.*;
import datamanager.DataManager;
import korisnik.*;
import usluge.*;
import salon.*;
import net.miginfocom.swing.MigLayout;

public class MenadzerFrame  extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3270672175892419744L;
	DataManager dm;
	Menadzer user;
	JTabbedPane tabovi;
	JFrame dialog;
	JPanel tab1, tab2, tab3, tab4, tab5, tab6, tab7, tab8, tab9;
	
	
	public MenadzerFrame() {
		
	}

	public MenadzerFrame(DataManager dm, Menadzer m) {
		this.dm = dm;
		this.user = m;
		initWindow();
	}
	
	private void initWindow() {
		this.dialog = new JFrame();
		dialog.setTitle("Kozmeticki salon");
		dialog.setSize(800,600);
		dialog.setMinimumSize(new Dimension(600, 500));
		dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialog.setLayout(new MigLayout("fill"));
		dialog.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/icon.png")).getImage());
		this.tabovi = new JTabbedPane(JTabbedPane.TOP);
		//------------------MENADZER TABLE
		this.tab1 = createMenadzerTab();
		//------------------KOZMETICAR TABLE
		this.tab2 = createKozmeticarTab();        
		//-----------------RECEPCIONERI TABLE
		this.tab3 = createRecepcionerTab();
		//-----------------KLIJENTI TABLE
		this.tab4 = createKlijentTab();
		//-----------------CJENOVNIK TABLE
		this.tab5 = createCjenovnikTab();
		//-----------------KOZMETICKI SALON
		//this.tab6 = createKozmetickiSalonTab();
		//-----------------TIP TRETMANA
		this.tab7 = createTTretmanaTab();
		//-----------------USLUGA TRETMANA
		this.tab8 = createUslugeTab();
		//-----------------ZAKAZANI TRETMANI
		this.tab9 = createZakazaniTretmanTab();
		
		baseWindow();
	}
	
	private void baseWindow() {        
		tabovi.removeAll(); // Remove all tabs from the tabbedPane
        tabovi.addTab("Menadzeri", tab1);
        tabovi.addTab("Kozmeticari", tab2);
        tabovi.addTab("Recepcioneri", tab3);
        tabovi.addTab("Klijenti", tab4);
        tabovi.addTab("Cjenovnik", tab5);
        //tabovi.addTab("Kozmeticki salon", tab6);
        tabovi.addTab("Tip tretmana", tab7);
        tabovi.addTab("Usluge tretmana", tab8);
        tabovi.addTab("Zakazani tretmani", tab9);
        
        dialog.add(tabovi, "grow");
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
	}
	
	
	public JPanel createMenadzerTab() {
		JPanel buttonsPanel1 = new JPanel();
		JButton Mbutton1 = new JButton("Dodaj");
		JButton Mbutton2 = new JButton("Izmjeni");
		JButton Mbutton3 = new JButton("Izbrisi");
		buttonsPanel1.add(Mbutton1);
		buttonsPanel1.add(Mbutton2);
		buttonsPanel1.add(Mbutton3);	//dodam dugmice u svoj panel
		
		//napravim tabelu, stavila sam vise kolone jer mi je preglednije
	
		List<Menadzer> dataList1 = new ArrayList<>(dm.getAllMenadzeri().values());
		TableModel tableModel1 = new MenadzerCustomTableModel(dataList1);
		JTable table1 = new JTable(tableModel1);
		table1.setRowHeight(table1.getRowHeight() * 2);
		
		//da bi mi bilo scrollable, dodam tabelu u nju logicno
		JScrollPane scrollPane = new JScrollPane(table1);
		
		//pravim panel gdje cu ubaciti scrollable tabelu i dugmice
		this.tab1 = new JPanel(new BorderLayout());
		tab1.add(buttonsPanel1, BorderLayout.NORTH);
		tab1.add(scrollPane, BorderLayout.CENTER);
		
		tabovi.addTab("Menadzeri", tab1);
		dialog.add(tabovi, BorderLayout.CENTER);
		dialog.getContentPane().add(tabovi);	
		
		Mbutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog add = new JDialog();
				add.setTitle("Dodaj");
				add.setLocationRelativeTo(null);
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setResizable(false);
				add.setSize(600, 500);

				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
				add.setLayout(layout);

				JTextField afKorIme = new JTextField(20);
				JTextField afLozinka = new JTextField(20);
				JTextField afIme = new JTextField(20);
				JTextField afPrezime = new JTextField(20);
				String[] pol = {"zensko", "musko"};
				JComboBox<String> afPol = new JComboBox<>(pol);
				JTextField afBroj = new JTextField(20);
				JTextField afGrad = new JTextField(20);
				JTextField afNivo = new JTextField(20);
				JTextField afStaz = new JTextField(20);
				JTextField afPlataOsnova = new JTextField(20);
				JTextField afPlata = new JTextField(20);
				
				JButton btnrOk = new JButton("Potvrdi");
				
				dialog.getRootPane().setDefaultButton(btnrOk);

				add.add(new JLabel("Dodaj"), "span 2, align center");
				add.add(new JLabel("Korisničko ime"), "cell 0 1");
				add.add(afKorIme, "cell 1 1");
				add.add(new JLabel("Šifra"), "cell 0 2");
				add.add(afLozinka, "cell 1 2");
				add.add(new JLabel("Ime"), "cell 0 3");
				add.add(afIme, "cell 1 3");
				add.add(new JLabel("Prezime"), "cell 0 4");
				add.add(afPrezime, "cell 1 4");
				add.add(new JLabel("Pol"), "cell 0 5");
				add.add(afPol, "cell 1 5");
				add.add(new JLabel("Tel broj"), "cell 0 6");
				add.add(afBroj, "cell 1 6");
				add.add(new JLabel("Adresa"), "cell 0 7");
				add.add(afGrad, "cell 1 7");
				add.add(new JLabel("Nivo strucne spreme"), "cell 0 8");
				add.add(afNivo, "cell 1 8");				
				add.add(new JLabel("Staz"), "cell 0 9");
				add.add(afStaz, "cell 1 9");			
				add.add(new JLabel("Plata osnova"), "cell 0 10");
				add.add(afPlataOsnova, "cell 1 10");
				add.add(new JLabel("Plata"), "cell 0 11");
				add.add(afPlata, "cell 1 11");
				add.add(btnrOk,"span 2, align center");
				
		        //The pack() method calculates the preferred size of the dialog based on its contents,
		        //so when i did this after setting it visible it shrunk because the dialog was empty
				add.pack();
		        add.setLocationRelativeTo(null);	//centrira
		        add.setVisible(true);
		        
		        btnrOk.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
	        		String aKorIme = afKorIme.getText().trim();
					String aLozinka = afLozinka.getText().trim();
					String aIme = afIme.getText().trim();
					String aPrezime = afPrezime.getText().trim();
					String aPol = (String) afPol.getSelectedItem();
					String aBroj = afBroj.getText().trim();
					String aGrad = afGrad.getText().trim();
					Double aNivo = 0.0;
					Double aStaz = 0.0;
					Double aPlataOsnova = 0.0;
					Double aPlata = 0.0;
					if(!afNivo.getText().equals("")) {
						aNivo = Double.parseDouble(afNivo.getText().trim());
					}
					if(!afStaz.getText().equals("")) {
						aStaz = Double.parseDouble(afStaz.getText().trim());						
					}
					if(!afPlataOsnova.getText().equals("")) {
						aPlataOsnova = Double.parseDouble(afPlataOsnova.getText().trim());	
					}
					if(!afPlata.getText().equals("")) {
						aPlata = Double.parseDouble(afPlata.getText().trim());	
					}
					

					if(dm.findUser(aKorIme, aLozinka) != null) {			
						JOptionPane.showMessageDialog(null, "Zauzeto korisnicko ime!");
					}else if(aKorIme.equals("") || aLozinka.equals("") || aIme.equals("") || aPrezime.equals("") || aPol.equals("") || aBroj.equals("")){
						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
					}else {
			        	add.setVisible(false);
		        		add.dispose();
						dm.addMenadzer(aKorIme, aLozinka, aIme, aPrezime, aPol, aBroj, aGrad);
						dm.MenadzerChangeNivo(aKorIme, aNivo);
						dm.MenadzerChangeStaz(aKorIme, aStaz);
						dm.MenadzerChangePlataOsnova(aKorIme, aPlataOsnova);
						dm.MenadzerChangePlata(aKorIme, aPlata);
						createMenadzerTab();
						baseWindow();

					}
	        	}
		     });	//action listener submit add
			}	//action performed
		});//action listener open add
		
		Mbutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izmjeni");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);

				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				JTextField editKorisnickoIme = new JTextField(20);
				JButton btnChose = new JButton("Pronadji");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Izmjena"), "span 2, align center");
				choose.add(new JLabel("Korisničko ime menadzera za izmjenu"));
				choose.add(editKorisnickoIme);
				choose.add(btnChose, "span 2, align center");
				
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String inputKorIme = editKorisnickoIme.getText().trim();
		        		Menadzer m = dm.findByKorMenadzer(inputKorIme);
		        		if(m == null) {
							JOptionPane.showMessageDialog(null, "Nepostojeci korisnik!");	
		        		}
		        		else {
		        			choose.setVisible(false);
    		        		choose.dispose();
		        			JDialog add = new JDialog();
		    				add.setTitle("Izmjena");
		    				add.setLocationRelativeTo(null);
		    				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		    				add.setResizable(false);
		    				add.setSize(600, 500);

		    				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
		    				add.setLayout(layout);

		    				JTextField eKorIme = new JTextField(20);
		    				JTextField eLozinka = new JTextField(20);
		    				JTextField eIme = new JTextField(20);
		    				JTextField ePrezime = new JTextField(20);
		    				String[] pol = {"zensko", "musko"};
		    				JComboBox<String> ePol = new JComboBox<>(pol);
		    				JTextField eBroj = new JTextField(20);
		    				JTextField eGrad = new JTextField(20);
		    				JTextField eNivo = new JTextField(20);
		    				JTextField eStaz = new JTextField(20);
		    				JTextField ePlataOsnova = new JTextField(20);
		    				JTextField ePlata = new JTextField(20);
		    				eKorIme.setText(m.getKorIme());
		    				eLozinka.setText(m.getLozinka());
		    				eIme.setText(m.getIme());
		    				ePrezime.setText(m.getPrezime());
		    				ePol.setSelectedItem(m.getPol());
		    				eBroj.setText(m.getTelefon());
		    				eGrad.setText(m.getAdresa());
		    				eNivo.setText(String.valueOf(m.getNivo()));
		    				eStaz.setText(String.valueOf(m.getStaz()));
		    				ePlataOsnova.setText(String.valueOf(m.getplataOsnova()));
		    				ePlata.setText(String.valueOf(m.getPlata()));

		    				JButton btnrOk = new JButton("Potvrdi");
		    				
		    				dialog.getRootPane().setDefaultButton(btnrOk);

		    				add.add(new JLabel("Registracija"), "span 2, align center");
		    				add.add(new JLabel("Korisničko ime"), "cell 0 1");
		    				add.add(eKorIme, "cell 1 1");
		    				add.add(new JLabel("Šifra"), "cell 0 2");
		    				add.add(eLozinka, "cell 1 2");
		    				add.add(new JLabel("Ime"), "cell 0 3");
		    				add.add(eIme, "cell 1 3");
		    				add.add(new JLabel("Prezime"), "cell 0 4");
		    				add.add(ePrezime, "cell 1 4");
		    				add.add(new JLabel("Pol"), "cell 0 5");
		    				add.add(ePol, "cell 1 5");
		    				add.add(new JLabel("Tel broj"), "cell 0 6");
		    				add.add(eBroj, "cell 1 6");
		    				add.add(new JLabel("Adresa"), "cell 0 7");
		    				add.add(eGrad, "cell 1 7");
		    				add.add(new JLabel("Nivo strucne spreme"), "cell 0 8");
		    				add.add(eNivo, "cell 1 8");				
		    				add.add(new JLabel("Staz"), "cell 0 9");
		    				add.add(eStaz, "cell 1 9");			
		    				add.add(new JLabel("Plata osnova"), "cell 0 10");
		    				add.add(ePlataOsnova, "cell 1 10");
		    				add.add(new JLabel("Plata"), "cell 0 11");
		    				add.add(ePlata, "cell 1 11");
		    				add.add(btnrOk,"span 2, align center");
		    				
		    		        //The pack() method calculates the preferred size of the dialog based on its contents,
		    		        //so when i did this after setting it visible it shrunk because the dialog was empty
		    				add.pack();
		    		        add.setLocationRelativeTo(null);	//centrira
		    		        add.setVisible(true);
		    		        
		    		        btnrOk.addActionListener(new ActionListener() {
		    		        	public void actionPerformed(ActionEvent e) {
		    	        		String aKorIme = eKorIme.getText().trim();
		    					String aLozinka = eLozinka.getText().trim();
		    					String aIme = eIme.getText().trim();
		    					String aPrezime = ePrezime.getText().trim();
		    					String aPol = (String) ePol.getSelectedItem();
		    					String aBroj = eBroj.getText().trim();
		    					String aGrad = eGrad.getText().trim();
		    					Double aNivo = 0.0;
		    					Double aStaz = 0.0;
		    					Double aPlataOsnova = 0.0;
		    					Double aPlata = 0.0;
		    					if(!eNivo.getText().equals("")) {
		    						aNivo = Double.parseDouble(eNivo.getText().trim());
		    					}
		    					if(!eStaz.getText().equals("")) {
		    						aStaz = Double.parseDouble(eStaz.getText().trim());						
		    					}
		    					if(!ePlataOsnova.getText().equals("")) {
		    						aPlataOsnova = Double.parseDouble(ePlataOsnova.getText().trim());	
		    					}
		    					if(!ePlata.getText().equals("")) {
		    						aPlata = Double.parseDouble(ePlata.getText().trim());	
		    					}
		    					
		    					if(aKorIme.equals("") || aLozinka.equals("") || aIme.equals("") || aPrezime.equals("") || aPol.equals("") || aBroj.equals("")){
		    						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
		    					}else {
		    			        	add.setVisible(false);
		    		        		add.dispose();
		    		        		dm.edit(m, m.getKorIme(), aLozinka, aIme, aPrezime, aPol, aBroj, aGrad);
		    						dm.MenadzerChangeNivo(inputKorIme, aNivo);
		    						dm.MenadzerChangeStaz(inputKorIme, aStaz);
		    						dm.MenadzerChangePlataOsnova(inputKorIme, aPlataOsnova);
		    						dm.MenadzerChangePlata(inputKorIme, aPlata);
		    						dm.MenadzerChangeKorIme(m.getKorIme(), aKorIme);
		    						createMenadzerTab();
		    						baseWindow();

		    					}
		    	        	}
		    		       });
		        		}
		        		
		        	}
				});
				
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});

		Mbutton3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izbrisi");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);

				
				
				
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				JTextField editKorisnickoIme = new JTextField(20);
				JButton btnChose = new JButton("Obrisi");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Brisanje"), "span 2, align center");
				choose.add(new JLabel("Korisničko ime menadzera za brisanje"));
				choose.add(editKorisnickoIme);
				choose.add(btnChose, "span 2, align center");
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String inputKorIme = editKorisnickoIme.getText().trim();
		        		if(dm.findByKorMenadzer(inputKorIme) == null) {
							JOptionPane.showMessageDialog(null, "Nepostojeci korisnik!");	
		        		}
		        		else {
		        			choose.setVisible(false);
    		        		choose.dispose();
    		        		dm.removeMenadzer(inputKorIme);
    		        		createMenadzerTab();
    						baseWindow();
		        		}
		        	}
		        });
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});
		
		return tab1;
	}

	public JPanel createKozmeticarTab() {
		JPanel buttonsPanel1 = new JPanel();
		JButton Mbutton1 = new JButton("Dodaj");
		JButton Mbutton2 = new JButton("Izmjeni");
		JButton Mbutton3 = new JButton("Izbrisi");
		buttonsPanel1.add(Mbutton1);
		buttonsPanel1.add(Mbutton2);
		buttonsPanel1.add(Mbutton3);	//dodam dugmice u svoj panel
		
		//napravim tabelu, stavila sam vise kolone jer mi je preglednije
	
		List<Kozmeticar> dataList1 = new ArrayList<>(dm.getAllKozmeticari().values());
		TableModel tableModel1 = new KozmeticarCustomTableModel(dataList1, dm);
		JTable table1 = new JTable(tableModel1);
		table1.setRowHeight(table1.getRowHeight() * 2);
		
		//da bi mi bilo scrollable, dodam tabelu u nju logicno
		JScrollPane scrollPane = new JScrollPane(table1);
		
		//pravim panel gdje cu ubaciti scrollable tabelu i dugmice
		this.tab2 = new JPanel(new BorderLayout());
		tab2.add(buttonsPanel1, BorderLayout.NORTH);
		tab2.add(scrollPane, BorderLayout.CENTER);
		
		tabovi.addTab("Kozmeticari", tab2);
		dialog.add(tabovi, BorderLayout.CENTER);
		dialog.getContentPane().add(tabovi);	
		
		Mbutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog add = new JDialog();
				add.setTitle("Dodaj");
				add.setLocationRelativeTo(null);
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setResizable(false);
				add.setSize(600, 500);

				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
				add.setLayout(layout);

				JTextField afKorIme = new JTextField(20);
				JTextField afLozinka = new JTextField(20);
				JTextField afIme = new JTextField(20);
				JTextField afPrezime = new JTextField(20);
				String[] pol = {"zensko", "musko"};
				JComboBox<String> afPol = new JComboBox<>(pol);
				JTextField afUsluge = new JTextField(20);
				JTextField afBroj = new JTextField(20);
				JTextField afGrad = new JTextField(20);
				JTextField afNivo = new JTextField(20);
				JTextField afStaz = new JTextField(20);
				JTextField afPlataOsnova = new JTextField(20);
				JTextField afPlata = new JTextField(20);
				
				JButton btnrOk = new JButton("Potvrdi");
				
				dialog.getRootPane().setDefaultButton(btnrOk);

				add.add(new JLabel("Dodaj"), "span 2, align center");
				add.add(new JLabel("Korisničko ime"), "cell 0 1");
				add.add(afKorIme, "cell 1 1");
				add.add(new JLabel("Šifra"), "cell 0 2");
				add.add(afLozinka, "cell 1 2");
				add.add(new JLabel("Ime"), "cell 0 3");
				add.add(afIme, "cell 1 3");
				add.add(new JLabel("Prezime"), "cell 0 4");
				add.add(afPrezime, "cell 1 4");
				add.add(new JLabel("Pol"), "cell 0 5");
				add.add(afPol, "cell 1 5");
				add.add(new JLabel("Usluge"), "cell 0 6");
				add.add(afUsluge, "cell 1 6");
				add.add(new JLabel("Tel broj"), "cell 0 7");
				add.add(afBroj, "cell 1 7");
				add.add(new JLabel("Adresa"), "cell 0 8");
				add.add(afGrad, "cell 1 8");
				add.add(new JLabel("Nivo strucne spreme"), "cell 0 9");
				add.add(afNivo, "cell 1 9");				
				add.add(new JLabel("Staz"), "cell 0 10");
				add.add(afStaz, "cell 1 10");			
				add.add(new JLabel("Plata osnova"), "cell 0 11");
				add.add(afPlataOsnova, "cell 1 11");
				add.add(new JLabel("Plata"), "cell 0 12");
				add.add(afPlata, "cell 1 12");
				add.add(btnrOk,"span 2, align center");
				
		        //The pack() method calculates the preferred size of the dialog based on its contents,
		        //so when i did this after setting it visible it shrunk because the dialog was empty
				add.pack();
		        add.setLocationRelativeTo(null);	//centrira
		        add.setVisible(true);
		        
		        btnrOk.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
	        		String aKorIme = afKorIme.getText().trim();
					String aLozinka = afLozinka.getText().trim();
					String aIme = afIme.getText().trim();
					String aPrezime = afPrezime.getText().trim();
					String aPol = (String) afPol.getSelectedItem();
					String aBroj = afBroj.getText().trim();
					String aGrad = afGrad.getText().trim();
					String[] usluge = afUsluge.getText().split(",");
					Double aNivo = 0.0;
					Double aStaz = 0.0;
					Double aPlataOsnova = 0.0;
					Double aPlata = 0.0;
					if(!afNivo.getText().equals("")) {
						aNivo = Double.parseDouble(afNivo.getText().trim());
					}
					if(!afStaz.getText().equals("")) {
						aStaz = Double.parseDouble(afStaz.getText().trim());						
					}
					if(!afPlataOsnova.getText().equals("")) {
						aPlataOsnova = Double.parseDouble(afPlataOsnova.getText().trim());	
					}
					if(!afPlata.getText().equals("")) {
						aPlata = Double.parseDouble(afPlata.getText().trim());	
					}
					

					if(dm.findUser(aKorIme, aLozinka) != null) {			
						JOptionPane.showMessageDialog(null, "Zauzeto korisnicko ime!");
					}else if(aKorIme.equals("") || aLozinka.equals("") || aIme.equals("") || aPrezime.equals("") || aPol.equals("") || aBroj.equals("")){
						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
					}else {
			        	add.setVisible(false);
		        		add.dispose();
						dm.addKozmeticar(aKorIme, aLozinka, aIme, aPrezime, aPol, aBroj, aGrad);
						dm.KozmeticarChangeNivo(aKorIme, aNivo);
						dm.KozmeticarChangeStaz(aKorIme, aStaz);
						dm.KozmeticarChangePlataOsnova(aKorIme, aPlataOsnova);
						dm.KozmeticarChangePlata(aKorIme, aPlata);
						if(usluge.length == 1 && !usluge[0].equals("")) {
							dm.KozmeticarAddUsluga(aKorIme, usluge[0].trim());
						}else if(usluge.length > 1) {
							for(int i = 0; i< usluge.length; i++) {
								dm.KozmeticarAddUsluga(aKorIme, usluge[i].trim());
							}
						}
						
						createKozmeticarTab();
						baseWindow();

					}
	        	}
		     });	//action listener submit add
			}	//action performed
		});//action listener open add
		
		
		Mbutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izmjeni");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				JTextField editKorisnickoIme = new JTextField(20);
				JButton btnChose = new JButton("Pronadji");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Izmjena"), "span 2, align center");
				choose.add(new JLabel("Korisničko ime kozmeticara za izmjenu"));
				choose.add(editKorisnickoIme);
				choose.add(btnChose, "span 2, align center");
				
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String inputKorIme = editKorisnickoIme.getText().trim();
		        		Kozmeticar m = dm.findByKorKozmeticar(inputKorIme);
		        		if(m == null) {
							JOptionPane.showMessageDialog(null, "Nepostojeci korisnik!");	
		        		}
		        		else {
		        			choose.setVisible(false);
    		        		choose.dispose();
		        			JDialog add = new JDialog();
		    				add.setTitle("Izmjena");
		    				add.setLocationRelativeTo(null);
		    				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		    				add.setResizable(false);
		    				add.setSize(600, 500);

		    				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
		    				add.setLayout(layout);

		    				JTextField eKorIme = new JTextField(20);
		    				JTextField eLozinka = new JTextField(20);
		    				JTextField eIme = new JTextField(20);
		    				JTextField ePrezime = new JTextField(20);
		    				String[] pol = {"zensko", "musko"};
		    				JComboBox<String> ePol = new JComboBox<>(pol);
		    				JTextField eBroj = new JTextField(20);
		    				JTextField eGrad = new JTextField(20);
		    				JTextField eNivo = new JTextField(20);
		    				JTextField eStaz = new JTextField(20);
		    				JTextField ePlataOsnova = new JTextField(20);
		    				JTextField ePlata = new JTextField(20);
		    				
		    				String[] djel = dm.getListaKozmeticar(inputKorIme).split(",");
		    				String[] opcije = new String[djel.length + 1];
		    				opcije[0] = "";
		    				for(int i = 1; i < djel.length + 1; i++) {
		    					djel[i-1].trim();
		    					opcije[i] = djel[i-1];
		    				}
		    				JComboBox<String> IzbrisiUslugu = new JComboBox<>(opcije);
		    				IzbrisiUslugu.setSelectedItem("");
		    				
		    				List<String> opcije2 = new ArrayList<>();
		    				opcije2.add("");
		    				boolean provjera;
		    				for(Map.Entry<Integer, UslugeTretmana> z : dm.getAllUsluge().entrySet()) {
		    					provjera = true;
		    					for(int j = 1; j< opcije.length; j++) {
		    						if(z.getValue().getNazivUsluge().equals(opcije[j])) {
		    							provjera = false;
		    						}
		    					}
		    					if(provjera) {
		    						opcije2.add(z.getValue().getNazivUsluge());
		    					}
		    				}
		    				
		    				JComboBox<String> DodajUslugu = new JComboBox<>(opcije2.toArray(new String[0]));
		    				IzbrisiUslugu.setSelectedItem("");
		    				
		    				
		    				eKorIme.setText(m.getKorIme());
		    				eLozinka.setText(m.getLozinka());
		    				eIme.setText(m.getIme());
		    				ePrezime.setText(m.getPrezime());
		    				ePol.setSelectedItem(m.getPol());
		    				eBroj.setText(m.getTelefon());
		    				eGrad.setText(m.getAdresa());
		    				eNivo.setText(String.valueOf(m.getNivo()));
		    				eStaz.setText(String.valueOf(m.getStaz()));
		    				ePlataOsnova.setText(String.valueOf(m.getplataOsnova()));
		    				ePlata.setText(String.valueOf(m.getPlata()));

		    				JButton btnrOk = new JButton("Potvrdi");
		    				
		    				dialog.getRootPane().setDefaultButton(btnrOk);

		    				add.add(new JLabel("Registracija"), "span 2, align center");
		    				add.add(new JLabel("Korisničko ime"), "cell 0 1");
		    				add.add(eKorIme, "cell 1 1");
		    				add.add(new JLabel("Šifra"), "cell 0 2");
		    				add.add(eLozinka, "cell 1 2");
		    				add.add(new JLabel("Ime"), "cell 0 3");
		    				add.add(eIme, "cell 1 3");
		    				add.add(new JLabel("Prezime"), "cell 0 4");
		    				add.add(ePrezime, "cell 1 4");
		    				add.add(new JLabel("Pol"), "cell 0 5");
		    				add.add(ePol, "cell 1 5");
		    				add.add(new JLabel("Tel broj"), "cell 0 6");
		    				add.add(eBroj, "cell 1 6");
		    				add.add(new JLabel("Adresa"), "cell 0 7");
		    				add.add(eGrad, "cell 1 7");
		    				add.add(new JLabel("Nivo strucne spreme"), "cell 0 8");
		    				add.add(eNivo, "cell 1 8");				
		    				add.add(new JLabel("Staz"), "cell 0 9");
		    				add.add(eStaz, "cell 1 9");			
		    				add.add(new JLabel("Plata osnova"), "cell 0 10");
		    				add.add(ePlataOsnova, "cell 1 10");
		    				add.add(new JLabel("Plata"), "cell 0 11");
		    				add.add(ePlata, "cell 1 11");
		    				add.add(new JLabel("Obrisi uslugu"), "cell 0 12");
		    				add.add(IzbrisiUslugu, "cell 1 12");
		    				add.add(new JLabel("Dodaj ulsugu"), "cell 0 13");
		    				add.add(DodajUslugu, "cell 1 13");
		    				add.add(btnrOk,"span 2, align center");
		    				
		    		        //The pack() method calculates the preferred size of the dialog based on its contents,
		    		        //so when i did this after setting it visible it shrunk because the dialog was empty
		    				add.pack();
		    		        add.setLocationRelativeTo(null);	//centrira
		    		        add.setVisible(true);
		    		        
		    		        btnrOk.addActionListener(new ActionListener() {
		    		        	public void actionPerformed(ActionEvent e) {
		    	        		String aKorIme = eKorIme.getText().trim();
		    					String aLozinka = eLozinka.getText().trim();
		    					String aIme = eIme.getText().trim();
		    					String aPrezime = ePrezime.getText().trim();
		    					String aPol = (String) ePol.getSelectedItem();
		    					String aBroj = eBroj.getText().trim();
		    					String aGrad = eGrad.getText().trim();
		    					Double aNivo = 0.0;
		    					Double aStaz = 0.0;
		    					Double aPlataOsnova = 0.0;
		    					Double aPlata = 0.0;
		    					if(!eNivo.getText().equals("")) {
		    						aNivo = Double.parseDouble(eNivo.getText().trim());
		    					}
		    					if(!eStaz.getText().equals("")) {
		    						aStaz = Double.parseDouble(eStaz.getText().trim());						
		    					}
		    					if(!ePlataOsnova.getText().equals("")) {
		    						aPlataOsnova = Double.parseDouble(ePlataOsnova.getText().trim());	
		    					}
		    					if(!ePlata.getText().equals("")) {
		    						aPlata = Double.parseDouble(ePlata.getText().trim());	
		    					}
		    					String dodata = (String) DodajUslugu.getSelectedItem();
		    					String brisi = (String) IzbrisiUslugu.getSelectedItem();
		    					
		    					if(aKorIme.equals("") || aLozinka.equals("") || aIme.equals("") || aPrezime.equals("") || aPol.equals("") || aBroj.equals("")){
		    						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
		    					}else {
		    			        	add.setVisible(false);
		    		        		add.dispose();
		    		        		Kozmeticar m = dm.findByKorKozmeticar(inputKorIme);
		    		        		dm.edit(m, m.getKorIme(), aLozinka, aIme, aPrezime, aPol, aBroj, aGrad);
		    						dm.KozmeticarChangeNivo(inputKorIme, aNivo);
		    						dm.KozmeticarChangeStaz(inputKorIme, aStaz);
		    						dm.KozmeticarChangePlataOsnova(inputKorIme, aPlataOsnova);
		    						dm.KozmeticarChangePlata(inputKorIme, aPlata);
		    						dm.KozmeticarChangeKorIme(m.getKorIme(), aKorIme);
		    						
		    						if(!dodata.equals("")) {
		    							dm.KozmeticarAddUsluga(aKorIme, dodata);
		    						}
		    						if(!brisi.equals("")) {
		    							dm.removeKozmeticarUsluga(inputKorIme, brisi);
		    						}
		    						
		    						
		    						createKozmeticarTab();
		    						baseWindow();

		    					}
		    	        	}
		    		       });
		        		}
		        		
		        	}
				});
				
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});

		
		Mbutton3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izbrisi");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);

				
				
				
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				JTextField editKorisnickoIme = new JTextField(20);
				JButton btnChose = new JButton("Obrisi");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Brisanje"), "span 2, align center");
				choose.add(new JLabel("Korisničko ime kozmeticara za brisanje"));
				choose.add(editKorisnickoIme);
				choose.add(btnChose, "span 2, align center");
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String inputKorIme = editKorisnickoIme.getText().trim();
		        		if(dm.findByKorKozmeticar(inputKorIme) == null) {
							JOptionPane.showMessageDialog(null, "Nepostojeci korisnik!");	
		        		}
		        		else {
		        			choose.setVisible(false);
    		        		choose.dispose();
    		        		dm.removeKozmeticar(inputKorIme);
    		        		createKozmeticarTab();
    						baseWindow();
		        		}
		        	}
		        });
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});
		
		
		return tab2;
	}

	public JPanel createRecepcionerTab() {
		JPanel buttonsPanel1 = new JPanel();
		JButton Mbutton11 = new JButton("Dodaj");
		JButton Mbutton22 = new JButton("Izmjeni");
		JButton Mbutton33 = new JButton("Izbrisi");
		buttonsPanel1.add(Mbutton11);
		buttonsPanel1.add(Mbutton22);
		buttonsPanel1.add(Mbutton33);	//dodam dugmice u svoj panel
		
		//napravim tabelu, stavila sam vise kolone jer mi je preglednije
		List<Recepcioner> dataList1 = new ArrayList<>(dm.getAllRecepcioneri().values());
		TableModel tableModel1 = new RecepcionerCustomTableModel(dataList1);
		JTable table1 = new JTable(tableModel1);
		table1.setRowHeight(table1.getRowHeight() * 2);
		
		//da bi mi bilo scrollable, dodam tabelu u nju logicno
		JScrollPane scrollPane = new JScrollPane(table1);
		
		//pravim panel gdje cu ubaciti scrollable tabelu i dugmice
		this.tab3 = new JPanel(new BorderLayout());
		tab3.add(buttonsPanel1, BorderLayout.NORTH);
		tab3.add(scrollPane, BorderLayout.CENTER);
		
		tabovi.addTab("Recepcioneri", tab3);
		dialog.add(tabovi, BorderLayout.CENTER);
		dialog.getContentPane().add(tabovi);	
		
		Mbutton11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog add = new JDialog();
				add.setTitle("Dodaj");
				add.setLocationRelativeTo(null);
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setResizable(false);
				add.setSize(600, 500);

				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
				add.setLayout(layout);

				JTextField afKorIme = new JTextField(20);
				JTextField afLozinka = new JTextField(20);
				JTextField afIme = new JTextField(20);
				JTextField afPrezime = new JTextField(20);
				String[] pol = {"zensko", "musko"};
				JComboBox<String> afPol = new JComboBox<>(pol);
				JTextField afBroj = new JTextField(20);
				JTextField afGrad = new JTextField(20);
				JTextField afNivo = new JTextField(20);
				JTextField afStaz = new JTextField(20);
				JTextField afPlataOsnova = new JTextField(20);
				JTextField afPlata = new JTextField(20);
				
				JButton btnrOk = new JButton("Potvrdi");
				
				dialog.getRootPane().setDefaultButton(btnrOk);

				add.add(new JLabel("Dodaj"), "span 2, align center");
				add.add(new JLabel("Korisničko ime"), "cell 0 1");
				add.add(afKorIme, "cell 1 1");
				add.add(new JLabel("Šifra"), "cell 0 2");
				add.add(afLozinka, "cell 1 2");
				add.add(new JLabel("Ime"), "cell 0 3");
				add.add(afIme, "cell 1 3");
				add.add(new JLabel("Prezime"), "cell 0 4");
				add.add(afPrezime, "cell 1 4");
				add.add(new JLabel("Pol"), "cell 0 5");
				add.add(afPol, "cell 1 5");
				add.add(new JLabel("Tel broj"), "cell 0 6");
				add.add(afBroj, "cell 1 6");
				add.add(new JLabel("Adresa"), "cell 0 7");
				add.add(afGrad, "cell 1 7");
				add.add(new JLabel("Nivo strucne spreme"), "cell 0 8");
				add.add(afNivo, "cell 1 8");				
				add.add(new JLabel("Staz"), "cell 0 9");
				add.add(afStaz, "cell 1 9");			
				add.add(new JLabel("Plata osnova"), "cell 0 10");
				add.add(afPlataOsnova, "cell 1 10");
				add.add(new JLabel("Plata"), "cell 0 11");
				add.add(afPlata, "cell 1 11");
				add.add(btnrOk,"span 2, align center");
				
		        //The pack() method calculates the preferred size of the dialog based on its contents,
		        //so when i did this after setting it visible it shrunk because the dialog was empty
				add.pack();
		        add.setLocationRelativeTo(null);	//centrira
		        add.setVisible(true);
		        
		        btnrOk.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
	        		String aKorIme = afKorIme.getText().trim();
					String aLozinka = afLozinka.getText().trim();
					String aIme = afIme.getText().trim();
					String aPrezime = afPrezime.getText().trim();
					String aPol = (String) afPol.getSelectedItem();
					String aBroj = afBroj.getText().trim();
					String aGrad = afGrad.getText().trim();
					Double aNivo = 0.0;
					Double aStaz = 0.0;
					Double aPlataOsnova = 0.0;
					Double aPlata = 0.0;
					if(!afNivo.getText().equals("")) {
						aNivo = Double.parseDouble(afNivo.getText().trim());
					}
					if(!afStaz.getText().equals("")) {
						aStaz = Double.parseDouble(afStaz.getText().trim());						
					}
					if(!afPlataOsnova.getText().equals("")) {
						aPlataOsnova = Double.parseDouble(afPlataOsnova.getText().trim());	
					}
					if(!afPlata.getText().equals("")) {
						aPlata = Double.parseDouble(afPlata.getText().trim());	
					}
					

					if(dm.findUser(aKorIme, aLozinka) != null) {			
						JOptionPane.showMessageDialog(null, "Zauzeto korisnicko ime!");
					}else if(aKorIme.equals("") || aLozinka.equals("") || aIme.equals("") || aPrezime.equals("") || aPol.equals("") || aBroj.equals("")){
						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
					}else {
			        	add.setVisible(false);
		        		add.dispose();
						dm.addRecepcioner(aKorIme, aLozinka, aIme, aPrezime, aPol, aBroj, aGrad);
						dm.RecepcionerChangeNivo(aKorIme, aNivo);
						dm.RecepcionerChangeStaz(aKorIme, aStaz);
						dm.RecepcionerChangePlataOsnova(aKorIme, aPlataOsnova);
						dm.RecepcionerChangePlata(aKorIme, aPlata);
						createRecepcionerTab();
						baseWindow();

					}
	        	}
		     });	//action listener submit add
			}	//action performed
		});//action listener open add
		
		
		Mbutton22.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izmjeni");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				JTextField editKorisnickoIme = new JTextField(20);
				JButton btnChose = new JButton("Pronadji");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Izmjena"), "span 2, align center");
				choose.add(new JLabel("Korisničko ime recepcionera za izmjenu"));
				choose.add(editKorisnickoIme);
				choose.add(btnChose, "span 2, align center");
				
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String inputKorIme = editKorisnickoIme.getText().trim();
		        		Recepcioner m = dm.findByKorReceocioner(inputKorIme);
		        		if(m == null) {
							JOptionPane.showMessageDialog(null, "Nepostojeci korisnik!");	
		        		}
		        		else {
		        			choose.setVisible(false);
    		        		choose.dispose();
		        			JDialog add = new JDialog();
		    				add.setTitle("Izmjena");
		    				add.setLocationRelativeTo(null);
		    				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		    				add.setResizable(false);
		    				add.setSize(600, 500);

		    				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
		    				add.setLayout(layout);

		    				JTextField eKorIme = new JTextField(20);
		    				JTextField eLozinka = new JTextField(20);
		    				JTextField eIme = new JTextField(20);
		    				JTextField ePrezime = new JTextField(20);
		    				String[] pol = {"zensko", "musko"};
		    				JComboBox<String> ePol = new JComboBox<>(pol);
		    				JTextField eBroj = new JTextField(20);
		    				JTextField eGrad = new JTextField(20);
		    				JTextField eNivo = new JTextField(20);
		    				JTextField eStaz = new JTextField(20);
		    				JTextField ePlataOsnova = new JTextField(20);
		    				JTextField ePlata = new JTextField(20);
		    				eKorIme.setText(m.getKorIme());
		    				eLozinka.setText(m.getLozinka());
		    				eIme.setText(m.getIme());
		    				ePrezime.setText(m.getPrezime());
		    				ePol.setSelectedItem(m.getPol());
		    				eBroj.setText(m.getTelefon());
		    				eGrad.setText(m.getAdresa());
		    				eNivo.setText(String.valueOf(m.getNivo()));
		    				eStaz.setText(String.valueOf(m.getStaz()));
		    				ePlataOsnova.setText(String.valueOf(m.getplataOsnova()));
		    				ePlata.setText(String.valueOf(m.getPlata()));

		    				JButton btnrOk = new JButton("Potvrdi");
		    				
		    				dialog.getRootPane().setDefaultButton(btnrOk);

		    				add.add(new JLabel("Izmjena"), "span 2, align center");
		    				add.add(new JLabel("Korisničko ime"), "cell 0 1");
		    				add.add(eKorIme, "cell 1 1");
		    				add.add(new JLabel("Šifra"), "cell 0 2");
		    				add.add(eLozinka, "cell 1 2");
		    				add.add(new JLabel("Ime"), "cell 0 3");
		    				add.add(eIme, "cell 1 3");
		    				add.add(new JLabel("Prezime"), "cell 0 4");
		    				add.add(ePrezime, "cell 1 4");
		    				add.add(new JLabel("Pol"), "cell 0 5");
		    				add.add(ePol, "cell 1 5");
		    				add.add(new JLabel("Tel broj"), "cell 0 6");
		    				add.add(eBroj, "cell 1 6");
		    				add.add(new JLabel("Adresa"), "cell 0 7");
		    				add.add(eGrad, "cell 1 7");
		    				add.add(new JLabel("Nivo strucne spreme"), "cell 0 8");
		    				add.add(eNivo, "cell 1 8");				
		    				add.add(new JLabel("Staz"), "cell 0 9");
		    				add.add(eStaz, "cell 1 9");			
		    				add.add(new JLabel("Plata osnova"), "cell 0 10");
		    				add.add(ePlataOsnova, "cell 1 10");
		    				add.add(new JLabel("Plata"), "cell 0 11");
		    				add.add(ePlata, "cell 1 11");
		    				add.add(btnrOk,"span 2, align center");
		    				
		    		        //The pack() method calculates the preferred size of the dialog based on its contents,
		    		        //so when i did this after setting it visible it shrunk because the dialog was empty
		    				add.pack();
		    		        add.setLocationRelativeTo(null);	//centrira
		    		        add.setVisible(true);
		    		        
		    		        btnrOk.addActionListener(new ActionListener() {
		    		        	public void actionPerformed(ActionEvent e) {
		    	        		String aKorIme = eKorIme.getText().trim();
		    					String aLozinka = eLozinka.getText().trim();
		    					String aIme = eIme.getText().trim();
		    					String aPrezime = ePrezime.getText().trim();
		    					String aPol = (String) ePol.getSelectedItem();
		    					String aBroj = eBroj.getText().trim();
		    					String aGrad = eGrad.getText().trim();
		    					Double aNivo = 0.0;
		    					Double aStaz = 0.0;
		    					Double aPlataOsnova = 0.0;
		    					Double aPlata = 0.0;
		    					if(!eNivo.getText().equals("")) {
		    						aNivo = Double.parseDouble(eNivo.getText().trim());
		    					}
		    					if(!eStaz.getText().equals("")) {
		    						aStaz = Double.parseDouble(eStaz.getText().trim());						
		    					}
		    					if(!ePlataOsnova.getText().equals("")) {
		    						aPlataOsnova = Double.parseDouble(ePlataOsnova.getText().trim());	
		    					}
		    					if(!ePlata.getText().equals("")) {
		    						aPlata = Double.parseDouble(ePlata.getText().trim());	
		    					}
		    					
		    					if(aKorIme.equals("") || aLozinka.equals("") || aIme.equals("") || aPrezime.equals("") || aPol.equals("") || aBroj.equals("")){
		    						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
		    					}else {
		    			        	add.setVisible(false);
		    		        		add.dispose();
		    		        		dm.edit(m, m.getKorIme(), aLozinka, aIme, aPrezime, aPol, aBroj, aGrad);
		    						dm.RecepcionerChangeNivo(inputKorIme, aNivo);
		    						dm.RecepcionerChangeStaz(inputKorIme, aStaz);
		    						dm.RecepcionerChangePlataOsnova(inputKorIme, aPlataOsnova);
		    						dm.RecepcionerChangePlata(inputKorIme, aPlata);
		    						dm.RecepcionerChangeKorIme(inputKorIme, aKorIme);
		    						createRecepcionerTab();
		    						baseWindow();

		    					}
		    	        	}
		    		       });
		        		}
		        		
		        	}
				});
				
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});

		
		Mbutton33.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izmjeni");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);

				
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				JTextField editKorisnickoIme = new JTextField(20);
				JButton btnChose = new JButton("Obrisi");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Brisanje"), "span 2, align center");
				choose.add(new JLabel("Korisničko ime recepcionera za brisanje"));
				choose.add(editKorisnickoIme);
				choose.add(btnChose, "span 2, align center");
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String inputKorIme = editKorisnickoIme.getText().trim();
		        		if(dm.findByKorReceocioner(inputKorIme) == null) {
							JOptionPane.showMessageDialog(null, "Nepostojeci korisnik!");	
		        		}
		        		else {
		        			choose.setVisible(false);
    		        		choose.dispose();
    		        		dm.removeRecepcioner(inputKorIme);
    		        		createRecepcionerTab();
    						baseWindow();
		        		}
		        	}
		        });
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});
		
		return tab3;
	}

	public JPanel createKlijentTab() {
		JPanel buttonsPanel1 = new JPanel();
		JButton Mbutton1 = new JButton("Dodaj");
		JButton Mbutton2 = new JButton("Izmjeni");
		JButton Mbutton3 = new JButton("Izbrisi");
		buttonsPanel1.add(Mbutton1);
		buttonsPanel1.add(Mbutton2);
		buttonsPanel1.add(Mbutton3);	//dodam dugmice u svoj panel
		
		//napravim tabelu, stavila sam vise kolone jer mi je preglednije
	
		List<Klijent> dataList1 = new ArrayList<>(dm.getAllKlijenti().values());
		TableModel tableModel1 = new KlijentCustomTableModel(dataList1);
		JTable table1 = new JTable(tableModel1);
		table1.setRowHeight(table1.getRowHeight() * 2);
		
		//da bi mi bilo scrollable, dodam tabelu u nju logicno
		JScrollPane scrollPane = new JScrollPane(table1);
		
		//pravim panel gdje cu ubaciti scrollable tabelu i dugmice
		this.tab4 = new JPanel(new BorderLayout());
		tab4.add(buttonsPanel1, BorderLayout.NORTH);
		tab4.add(scrollPane, BorderLayout.CENTER);
		
		tabovi.addTab("Klijenti", tab4);
		dialog.add(tabovi, BorderLayout.CENTER);
		dialog.getContentPane().add(tabovi);	
		
		Mbutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog add = new JDialog();
				add.setTitle("Dodaj");
				add.setLocationRelativeTo(null);
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setResizable(false);
				add.setSize(600, 500);

				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
				add.setLayout(layout);

				JTextField afKorIme = new JTextField(20);
				JTextField afLozinka = new JTextField(20);
				JTextField afIme = new JTextField(20);
				JTextField afPrezime = new JTextField(20);
				String[] pol = {"zensko", "musko"};
				JComboBox<String> afPol = new JComboBox<>(pol);
				JTextField afBroj = new JTextField(20);
				JTextField afGrad = new JTextField(20);
				JTextField afIstorija = new JTextField(20);
				JCheckBox checkLojalti = new JCheckBox("");
				checkLojalti.setSelected(false);
				
				JButton btnrOk = new JButton("Potvrdi");
				
				dialog.getRootPane().setDefaultButton(btnrOk);

				add.add(new JLabel("Dodaj"), "span 2, align center");
				add.add(new JLabel("Korisničko ime"), "cell 0 1");
				add.add(afKorIme, "cell 1 1");
				add.add(new JLabel("Šifra"), "cell 0 2");
				add.add(afLozinka, "cell 1 2");
				add.add(new JLabel("Ime"), "cell 0 3");
				add.add(afIme, "cell 1 3");
				add.add(new JLabel("Prezime"), "cell 0 4");
				add.add(afPrezime, "cell 1 4");
				add.add(new JLabel("Pol"), "cell 0 5");
				add.add(afPol, "cell 1 5");
				add.add(new JLabel("Tel broj"), "cell 0 6");
				add.add(afBroj, "cell 1 6");
				add.add(new JLabel("Adresa"), "cell 0 7");
				add.add(afGrad, "cell 1 7");
				add.add(new JLabel("Istorija kupovine"), "cell 0 8");
				add.add(afIstorija, "cell 1 8");
				add.add(new JLabel("Lojalti kartica"), "cell 0 9");
				add.add(checkLojalti, "cell 1 9");
				add.add(btnrOk,"span 2, align center");
				
		        //The pack() method calculates the preferred size of the dialog based on its contents,
		        //so when i did this after setting it visible it shrunk because the dialog was empty
				add.pack();
		        add.setLocationRelativeTo(null);	//centrira
		        add.setVisible(true);
		        
		        btnrOk.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
	        		String aKorIme = afKorIme.getText().trim();
					String aLozinka = afLozinka.getText().trim();
					String aIme = afIme.getText().trim();
					String aPrezime = afPrezime.getText().trim();
					String aPol = (String) afPol.getSelectedItem();
					String aBroj = afBroj.getText().trim();
					String aGrad = afGrad.getText().trim();
					Double aIstorija = 0.0;

					if(!afIstorija.getText().equals("")) {
						aIstorija = Double.parseDouble(afIstorija.getText().trim());
					}

					if(dm.findUser(aKorIme, aLozinka) != null) {			
						JOptionPane.showMessageDialog(null, "Zauzeto korisnicko ime!");
					}else if(aKorIme.equals("") || aLozinka.equals("") || aIme.equals("") || aPrezime.equals("") || aPol.equals("") || aBroj.equals("")){
						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
					}else {
			        	add.setVisible(false);
		        		add.dispose();
						dm.addKlijent(aKorIme, aLozinka, aIme, aPrezime, aPol, aBroj, aGrad);
						dm.klijentChangeIstorija(aKorIme, aIstorija);
						dm.klijentSetLojalti(aKorIme, checkLojalti.isSelected());
						createKlijentTab();
						baseWindow();

					}
	        	}
		     });	//action listener submit add
			}	//action performed
		});//action listener open add
		
		Mbutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izmjeni");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);

				
				
				
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				JTextField editKorisnickoIme = new JTextField(20);
				JButton btnChose = new JButton("Pronadji");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Izmjena"), "span 2, align center");
				choose.add(new JLabel("Korisničko ime klijenta za izmjenu"));
				choose.add(editKorisnickoIme);
				choose.add(btnChose, "span 2, align center");
				
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String inputKorIme = editKorisnickoIme.getText().trim();
		        		Klijent m = dm.findByKorKlijent(inputKorIme);
		        		if(m == null) {
							JOptionPane.showMessageDialog(null, "Nepostojeci korisnik!");	
		        		}
		        		else {
		        			choose.setVisible(false);
    		        		choose.dispose();
		        			JDialog add = new JDialog();
		    				add.setTitle("Izmjena");
		    				add.setLocationRelativeTo(null);
		    				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		    				add.setResizable(false);
		    				add.setSize(600, 500);

		    				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
		    				add.setLayout(layout);

		    				JTextField eKorIme = new JTextField(20);
		    				JTextField eLozinka = new JTextField(20);
		    				JTextField eIme = new JTextField(20);
		    				JTextField ePrezime = new JTextField(20);
		    				String[] pol = {"zensko", "musko"};
		    				JComboBox<String> ePol = new JComboBox<>(pol);
		    				JTextField eBroj = new JTextField(20);
		    				JTextField eGrad = new JTextField(20);    				
		    				JTextField eIstorija = new JTextField(20);
		    				JCheckBox EcheckLojalti = new JCheckBox("");
		    				
		    				eKorIme.setText(m.getKorIme());
		    				eLozinka.setText(m.getLozinka());
		    				eIme.setText(m.getIme());
		    				ePrezime.setText(m.getPrezime());
		    				ePol.setSelectedItem(m.getPol());
		    				eBroj.setText(m.getTelefon());
		    				eGrad.setText(m.getAdresa());
		    				eIstorija.setText(String.valueOf(m.getIstorijaKupovine()));
		    				EcheckLojalti.setSelected(m.hasLojaltiKartica());

		    				JButton btnrOk = new JButton("Potvrdi");
		    				
		    				dialog.getRootPane().setDefaultButton(btnrOk);

		    				add.add(new JLabel("Dodaj"), "span 2, align center");
		    				add.add(new JLabel("Korisničko ime"), "cell 0 1");
		    				add.add(eKorIme, "cell 1 1");
		    				add.add(new JLabel("Šifra"), "cell 0 2");
		    				add.add(eLozinka, "cell 1 2");
		    				add.add(new JLabel("Ime"), "cell 0 3");
		    				add.add(eIme, "cell 1 3");
		    				add.add(new JLabel("Prezime"), "cell 0 4");
		    				add.add(ePrezime, "cell 1 4");
		    				add.add(new JLabel("Pol"), "cell 0 5");
		    				add.add(ePol, "cell 1 5");
		    				add.add(new JLabel("Tel broj"), "cell 0 6");
		    				add.add(eBroj, "cell 1 6");
		    				add.add(new JLabel("Adresa"), "cell 0 7");
		    				add.add(eGrad, "cell 1 7");
		    				add.add(new JLabel("Istorija kupovine"), "cell 0 8");
		    				add.add(eIstorija, "cell 1 8");				
		    				add.add(new JLabel("Lojalti kartica"), "cell 0 9");
		    				add.add(EcheckLojalti, "cell 1 9");
		    				add.add(btnrOk,"span 2, align center");
		    				
		    		        //The pack() method calculates the preferred size of the dialog based on its contents,
		    		        //so when i did this after setting it visible it shrunk because the dialog was empty
		    				add.pack();
		    		        add.setLocationRelativeTo(null);	//centrira
		    		        add.setVisible(true);
		    		        
		    		        btnrOk.addActionListener(new ActionListener() {
		    		        	public void actionPerformed(ActionEvent e) {
		    	        		String aKorIme = eKorIme.getText().trim();
		    					String aLozinka = eLozinka.getText().trim();
		    					String aIme = eIme.getText().trim();
		    					String aPrezime = ePrezime.getText().trim();
		    					String aPol = (String) ePol.getSelectedItem();
		    					String aBroj = eBroj.getText().trim();
		    					String aGrad = eGrad.getText().trim();
		    					Double aIstorija = 0.0;
		    					
		    					if(!eIstorija.getText().equals("")) {
		    						aIstorija = Double.parseDouble(eIstorija.getText().trim());
		    					}
		    					
		    					if(aKorIme.equals("") || aLozinka.equals("") || aIme.equals("") || aPrezime.equals("") || aPol.equals("") || aBroj.equals("")){
		    						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
		    					}else {
		    			        	add.setVisible(false);
		    		        		add.dispose();
		    		        		dm.edit(m, m.getKorIme(), aLozinka, aIme, aPrezime, aPol, aBroj, aGrad);
		    		        		dm.klijentChangeIstorija(inputKorIme, aIstorija);
		    						dm.klijentSetLojalti(inputKorIme, EcheckLojalti.isSelected());
		    						dm.klijentChangeKorIme(inputKorIme, aKorIme);
		    						createKlijentTab();
		    						baseWindow();
		    					}
		    	        	}
		    		       });
		        		}
		        		
		        	}
				});
				
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});

		Mbutton3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izbrisi");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);
				
				
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				JTextField editKorisnickoIme = new JTextField(20);
				JButton btnChose = new JButton("Obrisi");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Brisanje"), "span 2, align center");
				choose.add(new JLabel("Korisničko ime klijenta za brisanje"));
				choose.add(editKorisnickoIme);
				choose.add(btnChose, "span 2, align center");
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String inputKorIme = editKorisnickoIme.getText().trim();
		        		if(dm.findByKorKlijent(inputKorIme) == null) {
							JOptionPane.showMessageDialog(null, "Nepostojeci korisnik!");	
		        		}
		        		else {
		        			choose.setVisible(false);
    		        		choose.dispose();
    		        		dm.removeKlijent(inputKorIme);
    		        		createKlijentTab();
    						baseWindow();
		        		}
		        	}
		        });
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});
			
		return tab4;
	}

	public JPanel createCjenovnikTab() {
		JPanel buttonsPanel1 = new JPanel();
		JButton Mbutton1 = new JButton("Dodaj");
		JButton Mbutton2 = new JButton("Izmjeni");
		JButton Mbutton3 = new JButton("Izbrisi");
		buttonsPanel1.add(Mbutton1);
		buttonsPanel1.add(Mbutton2);
		buttonsPanel1.add(Mbutton3);	//dodam dugmice u svoj panel
		
		//mogu da koristim default jer nije mapa sa objektima
		 DefaultTableModel tableModel = new DefaultTableModel();
	        tableModel.addColumn("Tip tretmana");
	        tableModel.addColumn("Cijena");
	        for (Map.Entry<String, Double> entry : dm.getAllCjeneNazivi().entrySet()) {
	            Object[] rowData = {entry.getKey(), entry.getValue()};
	            tableModel.addRow(rowData);
	        }
	        
	    JTable table1 = new JTable(tableModel);
		table1.setRowHeight(table1.getRowHeight() * 2);
		
		//da bi mi bilo scrollable, dodam tabelu u nju logicno
		JScrollPane scrollPane = new JScrollPane(table1);
		
		//pravim panel gdje cu ubaciti scrollable tabelu i dugmice
		this.tab5 = new JPanel(new BorderLayout());
		tab5.add(buttonsPanel1, BorderLayout.NORTH);
		tab5.add(scrollPane, BorderLayout.CENTER);
		
		tabovi.addTab("Cjenovnik", tab5);
		
		Mbutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog add = new JDialog();
				add.setTitle("Dodaj");
				add.setLocationRelativeTo(null);
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setResizable(false);
				add.setSize(600, 500);

				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				add.setLayout(layout);

				ArrayList<String> dostupniNazivi = new ArrayList<>();

				for (Map.Entry<Integer, TipTretmana> t : dm.getAllTipovi().entrySet()) {
					Boolean provjera = true;
					for(Map.Entry<String, Double> cjene : dm.getAllCjeneNazivi().entrySet()) {
						if(t.getValue().getnazivTretmana().equals(cjene.getKey())) {
							provjera = false;
						}
					}
					if(provjera) {
						dostupniNazivi.add(t.getValue().getnazivTretmana());
					}
				}
				
				String[] nazivi =  dostupniNazivi.toArray(new String[dostupniNazivi.size()]);
				JComboBox<String> afCTTNaziv = new JComboBox<>(nazivi);
				JTextField afcijena = new JTextField(20);
				
				JButton btnrOk = new JButton("Potvrdi");
				
				dialog.getRootPane().setDefaultButton(btnrOk);

				add.add(new JLabel("Dodaj"), "span 2, align center");
				add.add(new JLabel("Naziv tretmana"), "cell 0 1");
				add.add(afCTTNaziv, "cell 1 1");
				add.add(new JLabel("Cijena"), "cell 0 2");
				add.add(afcijena, "cell 1 2");
				add.add(btnrOk,"span 2, align center");
				
		        //The pack() method calculates the preferred size of the dialog based on its contents,
		        //so when i did this after setting it visible it shrunk because the dialog was empty
				add.pack();
		        add.setLocationRelativeTo(null);	//centrira
		        add.setVisible(true);
		        
		        btnrOk.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
					Double aCijena = 0.0;

					if(!afcijena.getText().equals("")) {
						aCijena = Double.parseDouble(afcijena.getText().trim());
					}

					if(afcijena.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
					}else {
			        	add.setVisible(false);
		        		add.dispose();
		        		dm.addCijena((String)afCTTNaziv.getSelectedItem(), aCijena);
						createCjenovnikTab();
						baseWindow();

					}
	        	}
		     });	//action listener submit add
			}	//action performed
		});//action listener open add
		
		Mbutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] postojeciNazivi = new String[dm.getAllCjeneNazivi().size()];
				int i = 0;
				for(Map.Entry<String, Double> cjene : dm.getAllCjeneNazivi().entrySet()) {
					postojeciNazivi[i] = cjene.getKey();
					i++;
				}
				
    			JDialog add = new JDialog();
				add.setTitle("Izmjena");
				add.setLocationRelativeTo(null);
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setResizable(false);
				add.setSize(600, 500);
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				add.setLayout(layout);

				JComboBox<String> afCTTNaziv = new JComboBox<>(postojeciNazivi);
				JTextField afCijena = new JTextField(20);
				JButton btnrOk = new JButton("Potvrdi");
				
				dialog.getRootPane().setDefaultButton(btnrOk);

				add.add(new JLabel("Dodaj"), "span 2, align center");
				add.add(new JLabel("Naziv tretmana"), "cell 0 1");
				add.add(afCTTNaziv, "cell 1 1");
				add.add(new JLabel("Nova cijena"), "cell 0 2");
				add.add(afCijena, "cell 1 2");
				add.add(btnrOk,"span 2, align center");
				
		        //The pack() method calculates the preferred size of the dialog based on its contents,
		        //so when i did this after setting it visible it shrunk because the dialog was empty
				add.pack();
		        add.setLocationRelativeTo(null);	//centrira
		        add.setVisible(true);
		        
		        btnrOk.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
	        		String NazivSelected = (String)afCTTNaziv.getSelectedItem();
					Double NovaCijena = 0.0;
					
					if(!afCijena.getText().equals("")) {
						NovaCijena = Double.parseDouble(afCijena.getText().trim());
					}
					
					if(NovaCijena == 0){
						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
					}else {
			        	add.setVisible(false);
		        		add.dispose();
		      
		        		dm.changeCijena(NazivSelected, NovaCijena);
		        		
						createCjenovnikTab();
						baseWindow();
					}
	        	}
		       });
			}
		});

		Mbutton3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izbrisi");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);
				
				
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				
				String[] postojeciNazivi = new String[dm.getAllCjeneNazivi().size()];
				int i = 0;
				for(Map.Entry<String, Double> cjene : dm.getAllCjeneNazivi().entrySet()) {
					postojeciNazivi[i] = cjene.getKey();
					i++;
				}
				JComboBox<String> BrisanjeField = new JComboBox<>(postojeciNazivi);
				JButton btnChose = new JButton("Obrisi");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Brisanje"), "span 2, align center");
				choose.add(new JLabel("Naziv tretmana za brisanje"));
				choose.add(BrisanjeField);
				choose.add(btnChose, "span 2, align center");
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String NazivSelected = (String)BrisanjeField.getSelectedItem();
	        			choose.setVisible(false);
		        		choose.dispose();
		        		
		        		dm.removeCjena(NazivSelected);		        		
		        		createCjenovnikTab();
						baseWindow();
		        		
		        	}
		        });
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});
			
		return tab5;
		

	}
	
	public JPanel createKozmetickiSalonTab() {		
		/*JPanel buttonPanel = new JPanel();
		JButton Mbutton1 = new JButton("Promjeni");
		buttonPanel.add(Mbutton1);
		//pravim panel gdje cu ubaciti scrollable tabelu i dugmice
		this.tab6 = new JPanel(new BorderLayout());
		
		JPanel mainPanel = new JPanel();
		MigLayout layout = new MigLayout("wrap 2", "[][][]", "[]20[]");
		mainPanel.setLayout(layout);
		
		JTextField afCTTNaziv = new JTextField(20);
		mainPanel.add(new JLabel("Naziv tretmana"), "cell 0 1, center");
		mainPanel.add(afCTTNaziv, "cell 1 1, center");
		tabovi.addTab("Kozmeticki Salon", tab6);	
		tab6.add(buttonPanel, BorderLayout.SOUTH);
		tab6.add(mainPanel, BorderLayout.CENTER);*/
		return tab6;
	}

	public JPanel createTTretmanaTab() {
		JPanel buttonsPanel1 = new JPanel();
		JButton Mbutton1 = new JButton("Dodaj");
		JButton Mbutton2 = new JButton("Izmjeni");
		JButton Mbutton3 = new JButton("Izbrisi");
		buttonsPanel1.add(Mbutton1);
		buttonsPanel1.add(Mbutton2);
		buttonsPanel1.add(Mbutton3);	//dodam dugmice u svoj panel
		
		//napravim tabelu, stavila sam vise kolone jer mi je preglednije
	
		List<TipTretmana> dataList1 = new ArrayList<>(dm.getAllTipovi().values());
		TableModel tableModel1 = new TipTretmanaCustomTableModel(dataList1);
		JTable table1 = new JTable(tableModel1);
		table1.setRowHeight(table1.getRowHeight() * 2);
		
		//da bi mi bilo scrollable, dodam tabelu u nju logicno
		JScrollPane scrollPane = new JScrollPane(table1);
		
		//pravim panel gdje cu ubaciti scrollable tabelu i dugmice
		this.tab7 = new JPanel(new BorderLayout());
		tab7.add(buttonsPanel1, BorderLayout.NORTH);
		tab7.add(scrollPane, BorderLayout.CENTER);
		
		dialog.add(tabovi, BorderLayout.CENTER);
		dialog.getContentPane().add(tabovi);	
		
		Mbutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog add = new JDialog();
				add.setTitle("Dodaj");
				add.setLocationRelativeTo(null);
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setResizable(false);
				add.setSize(600, 500);

				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
				add.setLayout(layout);

				JTextField afNazivTretmana = new JTextField(20);
				JTextField afVrijemeTrajanja = new JTextField(20);

				
				
				String[] usluge = new String[dm.getAllUsluge().size()];
				int i = 0;
				for(Map.Entry<Integer, UslugeTretmana> u : dm.getAllUsluge().entrySet()) {
					usluge[i] = u.getValue().getNazivUsluge();
					i++;
				}
				JComboBox<String> afUsluge = new JComboBox<>(usluge);
				
				JButton btnrOk = new JButton("Potvrdi");
				
				dialog.getRootPane().setDefaultButton(btnrOk);

				add.add(new JLabel("Dodaj"), "span 2, align center");
				add.add(new JLabel("Naziv tretmana"), "cell 0 1");
				add.add(afNazivTretmana, "cell 1 1");
				add.add(new JLabel("Vrijeme trajanja(minuti)"), "cell 0 2");
				add.add(afVrijemeTrajanja, "cell 1 2");
				add.add(new JLabel("Usluga kojoj pripada:"), "cell 0 3");
				add.add(afUsluge, "cell 1 3");
				add.add(btnrOk,"span 2, align center");
				
		        //The pack() method calculates the preferred size of the dialog based on its contents,
		        //so when i did this after setting it visible it shrunk because the dialog was empty
				add.pack();
		        add.setLocationRelativeTo(null);	//centrira
		        add.setVisible(true);
		        
		        btnrOk.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
	        		String NazivTretmana = afNazivTretmana.getText().trim();
					int vrijemeTrajanja = 0;
					
					boolean provjera = true;
					try {
						vrijemeTrajanja = Integer.parseInt(afVrijemeTrajanja.getText().trim());		
						if(vrijemeTrajanja <= 0) {
							JOptionPane.showMessageDialog(null, "Vrijeme trajanja mora biti pozitivan broj!");									
						}
					}
					catch(Exception e1) {
						provjera = false;
					}
					
					if(afVrijemeTrajanja.getText().equals("") || !provjera) {
						JOptionPane.showMessageDialog(null, "Unesite vrijeme u pravom formatu!!");	
	
					}
					else if(NazivTretmana.equals("")){
						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
					}else {
			        	add.setVisible(false);
		        		add.dispose();
						dm.addTipTretmana(NazivTretmana, vrijemeTrajanja);
						dm.addUslugaTip((String)afUsluge.getSelectedItem(), NazivTretmana);
						
						createTTretmanaTab();
						baseWindow();

					}
	        	}
		     });	//action listener submit add
			}	//action performed
		});//action listener open add
		
		Mbutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izmjeni");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);
				
				
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				
				String[] naziviTretmana = new String[dm.getAllTipovi().size()];
				int i = 0;
				for(Map.Entry<Integer, TipTretmana> t : dm.getAllTipovi().entrySet()) {
					naziviTretmana[i] = t.getValue().getnazivTretmana();
					i++;
				}
				JComboBox<String> afTretmani = new JComboBox<>(naziviTretmana);
				JButton btnChose = new JButton("Pronadji");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Izmjena"), "span 2, align center");
				choose.add(new JLabel("Naziv tretmana za izmjenu"));
				choose.add(afTretmani);
				choose.add(btnChose, "span 2, align center");
				
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String naziv = (String)afTretmani.getSelectedItem();
		        		TipTretmana  t = dm.TTretmanaFindByNaziv(naziv);
	        			choose.setVisible(false);
		        		choose.dispose();
	        			JDialog add = new JDialog();
	    				add.setTitle("Izmjena");
	    				add.setLocationRelativeTo(null);
	    				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    				add.setResizable(false);
	    				add.setSize(600, 500);

	    				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
	    				add.setLayout(layout);

	    				JTextField fNazivTretmana = new JTextField(20);
	    				JTextField fVrijemeTrajanja = new JTextField(20);
	    				JTextField fCijena = new JTextField(20);
	    				
	    				fNazivTretmana.setText(t.getnazivTretmana());
	    				fVrijemeTrajanja.setText(Integer.toString(t.getVrijemeTrajanja()));
	    				fCijena.setText(Double.toString(t.getCijena()));

	    				JButton btnrOk = new JButton("Potvrdi");	    				
	    				dialog.getRootPane().setDefaultButton(btnrOk);

	    				add.add(new JLabel("Dodaj"), "span 2, align center");
	    				add.add(new JLabel("Novi naziv"), "cell 0 1");
	    				add.add(fNazivTretmana, "cell 1 1");
	    				add.add(new JLabel("Novo vrijeme trajanja"), "cell 0 2");
	    				add.add(fVrijemeTrajanja, "cell 1 2");
	    				add.add(new JLabel("Nova cijena"), "cell 0 3");
	    				add.add(fCijena, "cell 1 3");
	    				add.add(btnrOk,"span 2, align center");
	    				
	    		        //The pack() method calculates the preferred size of the dialog based on its contents,
	    		        //so when i did this after setting it visible it shrunk because the dialog was empty
	    				add.pack();
	    		        add.setLocationRelativeTo(null);	//centrira
	    		        add.setVisible(true);
	    		        
	    		        btnrOk.addActionListener(new ActionListener() {
	    		        	public void actionPerformed(ActionEvent e) {
	    	        		String NoviNaziv = fNazivTretmana.getText().trim();
	    					int VrijemeTrajanja = 0;
	    					Double Cijena = 0.0;
	    					
	    					if(!fVrijemeTrajanja.getText().equals("")) {
	    						VrijemeTrajanja = Integer.parseInt(fVrijemeTrajanja.getText().trim());
	    					}
	    					if(!fCijena.getText().equals("")) {
	    						Cijena = Double.parseDouble(fCijena.getText().trim());
	    					}
	    					
	    					if(VrijemeTrajanja <= 1 || Cijena <= 0 || NoviNaziv.equals("")){
	    						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
	    					}else {
	    			        	add.setVisible(false);
	    		        		add.dispose();
	    		        		dm.changeCijena(naziv, Cijena);
	    		        		dm.TTChangeTrajanje(naziv, VrijemeTrajanja);
	    		        		dm.TTChangeNaziv(naziv, NoviNaziv);
	    		        		createCjenovnikTab();
	    						createTTretmanaTab();
	    						baseWindow();
		    					}
		    	        	}
		    		       });
		        		
		        		
		        	}
				});
				
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});

		Mbutton3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izbrisi");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);
				
				
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				String[] naziviTretmana = new String[dm.getAllTipovi().size()];
				int i = 0;
				for(Map.Entry<Integer, TipTretmana> t : dm.getAllTipovi().entrySet()) {
					naziviTretmana[i] = t.getValue().getnazivTretmana();
					i++;
				}
				JComboBox<String> afTretmani = new JComboBox<>(naziviTretmana);
				JButton btnChose = new JButton("Obrisi");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Brisanje"), "span 2, align center");
				choose.add(new JLabel("Izaberite tretman za brisanje: "));
				choose.add(afTretmani);
				choose.add(btnChose, "span 2, align center");
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String izbor = (String)afTretmani.getSelectedItem();
	        			choose.setVisible(false);
		        		choose.dispose();
		        		dm.removeTT(izbor);
		        		createTTretmanaTab();
		        		createCjenovnikTab();
						baseWindow();
		        	}
		        });
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});
			
		return tab7;
		

	}

	public JPanel createUslugeTab() {
		JPanel buttonsPanel1 = new JPanel();
		JButton Mbutton1 = new JButton("Dodaj");
		JButton Mbutton2 = new JButton("Izmjeni");
		JButton Mbutton3 = new JButton("Izbrisi");
		buttonsPanel1.add(Mbutton1);
		buttonsPanel1.add(Mbutton2);
		buttonsPanel1.add(Mbutton3);	//dodam dugmice u svoj panel
		
		//napravim tabelu, stavila sam vise kolone jer mi je preglednije
		
		List<UslugeTretmana> dataList1 = new ArrayList<>(dm.getAllUsluge().values());
		TableModel tableModel1 = new UslugaCustomTableModel(dataList1, dm);
		JTable table1 = new JTable(tableModel1);
		table1.setRowHeight(table1.getRowHeight() * 2);
		
		//da bi mi bilo scrollable, dodam tabelu u nju logicno
		JScrollPane scrollPane = new JScrollPane(table1);
		
		//pravim panel gdje cu ubaciti scrollable tabelu i dugmice
		this.tab8 = new JPanel(new BorderLayout());
		tab8.add(buttonsPanel1, BorderLayout.NORTH);
		tab8.add(scrollPane, BorderLayout.CENTER);
		
		tabovi.addTab("Usluge Tretmana", tab8);
		dialog.add(tabovi, BorderLayout.CENTER);
		dialog.getContentPane().add(tabovi);
		
		Mbutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog add = new JDialog();
				add.setTitle("Dodaj");
				add.setLocationRelativeTo(null);
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setResizable(false);
				add.setSize(600, 500);

				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
				add.setLayout(layout);

				JTextField afNazivTretmana = new JTextField(20);
				//JTextField afVrijemeTrajanja = new JTextField(20);
				
				
				/*
				String[] usluge = new String[dm.getAllUsluge().size()];
				int i = 0;
				for(Map.Entry<Integer, UslugeTretmana> u : dm.getAllUsluge().entrySet()) {
					usluge[i] = u.getValue().getNazivUsluge();
					i++;
				}
				JComboBox<String> afUsluge = new JComboBox<>(usluge);
				*/
				JButton btnrOk = new JButton("Potvrdi");
				
				dialog.getRootPane().setDefaultButton(btnrOk);

				add.add(new JLabel("Dodaj"), "span 2, align center");
				add.add(new JLabel("Naziv usluge"), "cell 0 1");
				add.add(afNazivTretmana, "cell 1 1");
				/*add.add(new JLabel("Vrijeme trajanja(minuti)"), "cell 0 2");
				add.add(afVrijemeTrajanja, "cell 1 2");
				add.add(new JLabel("Usluga kojoj pripada:"), "cell 0 3");
				add.add(afUsluge, "cell 1 3");*/
				add.add(btnrOk,"span 2, align center");
				
		        //The pack() method calculates the preferred size of the dialog based on its contents,
		        //so when i did this after setting it visible it shrunk because the dialog was empty
				add.pack();
		        add.setLocationRelativeTo(null);	//centrira
		        add.setVisible(true);
		        
		        btnrOk.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
	        		String NazivTretmana = afNazivTretmana.getText().trim();
					
				
					if(NazivTretmana.equals("")){
						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
					}else {
			        	add.setVisible(false);
		        		add.dispose();
						
		        		dm.addUslugaTretmana(NazivTretmana);
						
		        		createUslugeTab();
						baseWindow();

					}
	        	}
		     });	//action listener submit add
			}	//action performed
		});//action listener open add
		
		Mbutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izmjeni");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);
				
				
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				
				String[] naziviTretmana = new String[dm.getAllTipovi().size()];
				int i = 0;
				for(Map.Entry<Integer, TipTretmana> t : dm.getAllTipovi().entrySet()) {
					naziviTretmana[i] = t.getValue().getnazivTretmana();
					i++;
				}
				JComboBox<String> afTretmani = new JComboBox<>(naziviTretmana);
				JButton btnChose = new JButton("Pronadji");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Izmjena"), "span 2, align center");
				choose.add(new JLabel("Naziv tretmana za izmjenu"));
				choose.add(afTretmani);
				choose.add(btnChose, "span 2, align center");
				
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String naziv = (String)afTretmani.getSelectedItem();
		        		TipTretmana  t = dm.TTretmanaFindByNaziv(naziv);
	        			choose.setVisible(false);
		        		choose.dispose();
	        			JDialog add = new JDialog();
	    				add.setTitle("Izmjena");
	    				add.setLocationRelativeTo(null);
	    				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    				add.setResizable(false);
	    				add.setSize(600, 500);

	    				MigLayout layout = new MigLayout("wrap 2", "[][][][]", "[]20[]20[]20[]20[]20[]20[]");
	    				add.setLayout(layout);

	    				JTextField fNazivTretmana = new JTextField(20);
	    				JTextField fVrijemeTrajanja = new JTextField(20);
	    				JTextField fCijena = new JTextField(20);
	    				
	    				fNazivTretmana.setText(t.getnazivTretmana());
	    				fVrijemeTrajanja.setText(Integer.toString(t.getVrijemeTrajanja()));
	    				fCijena.setText(Double.toString(t.getCijena()));

	    				JButton btnrOk = new JButton("Potvrdi");	    				
	    				dialog.getRootPane().setDefaultButton(btnrOk);

	    				add.add(new JLabel("Dodaj"), "span 2, align center");
	    				add.add(new JLabel("Novi naziv"), "cell 0 1");
	    				add.add(fNazivTretmana, "cell 1 1");
	    				add.add(new JLabel("Novo vrijeme trajanja"), "cell 0 2");
	    				add.add(fVrijemeTrajanja, "cell 1 2");
	    				add.add(new JLabel("Nova cijena"), "cell 0 3");
	    				add.add(fCijena, "cell 1 3");
	    				add.add(btnrOk,"span 2, align center");
	    				
	    		        //The pack() method calculates the preferred size of the dialog based on its contents,
	    		        //so when i did this after setting it visible it shrunk because the dialog was empty
	    				add.pack();
	    		        add.setLocationRelativeTo(null);	//centrira
	    		        add.setVisible(true);
	    		        
	    		        btnrOk.addActionListener(new ActionListener() {
	    		        	public void actionPerformed(ActionEvent e) {
	    	        		String NoviNaziv = fNazivTretmana.getText().trim();
	    					int VrijemeTrajanja = 0;
	    					Double Cijena = 0.0;
	    					
	    					if(!fVrijemeTrajanja.getText().equals("")) {
	    						VrijemeTrajanja = Integer.parseInt(fVrijemeTrajanja.getText().trim());
	    					}
	    					if(!fCijena.getText().equals("")) {
	    						Cijena = Double.parseDouble(fCijena.getText().trim());
	    					}
	    					
	    					if(VrijemeTrajanja <= 1 || Cijena <= 0 || NoviNaziv.equals("")){
	    						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
	    					}else {
	    			        	add.setVisible(false);
	    		        		add.dispose();
	    		        		dm.changeCijena(naziv, Cijena);
	    		        		dm.TTChangeTrajanje(naziv, VrijemeTrajanja);
	    		        		dm.TTChangeNaziv(naziv, NoviNaziv);
	    		        		createCjenovnikTab();
	    						createTTretmanaTab();
	    						baseWindow();
		    					}
		    	        	}
		    		       });
		        		
		        		
		        	}
				});
				
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});

		Mbutton3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izbrisi");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);
				
				
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				String[] naziviTretmana = new String[dm.getAllTipovi().size()];
				int i = 0;
				for(Map.Entry<Integer, TipTretmana> t : dm.getAllTipovi().entrySet()) {
					naziviTretmana[i] = t.getValue().getnazivTretmana();
					i++;
				}
				JComboBox<String> afTretmani = new JComboBox<>(naziviTretmana);
				JButton btnChose = new JButton("Obrisi");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Brisanje"), "span 2, align center");
				choose.add(new JLabel("Izaberite tretman za brisanje: "));
				choose.add(afTretmani);
				choose.add(btnChose, "span 2, align center");
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String izbor = (String)afTretmani.getSelectedItem();
	        			choose.setVisible(false);
		        		choose.dispose();
		        		dm.removeTT(izbor);
		        		createTTretmanaTab();
		        		createCjenovnikTab();
						baseWindow();
		        	}
		        });
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});


		
		
		
		return tab8;
	}

	public JPanel createZakazaniTretmanTab() {
		JPanel buttonsPanel1 = new JPanel();
		JButton Mbutton1 = new JButton("Dodaj");
		JButton Mbutton2 = new JButton("Izmjeni");
		JButton Mbutton3 = new JButton("Izbrisi");
		buttonsPanel1.add(Mbutton1);
		buttonsPanel1.add(Mbutton2);
		buttonsPanel1.add(Mbutton3);	//dodam dugmice u svoj panel
		
		List<ZakazaniTretman> dataList1 = new ArrayList<>(dm.getAllZakazani().values());
		TableModel tableModel1 = new ZakazaniTretmanTableModel(dataList1, dm);
		JTable table1 = new JTable(tableModel1);
		table1.setRowHeight(table1.getRowHeight() * 2);
		
		//da bi mi bilo scrollable, dodam tabelu u nju logicno
		JScrollPane scrollPane = new JScrollPane(table1);
		
		//pravim panel gdje cu ubaciti scrollable tabelu i dugmice
		this.tab9 = new JPanel(new BorderLayout());
		tab9.add(buttonsPanel1, BorderLayout.NORTH);
		tab9.add(scrollPane, BorderLayout.CENTER);
				
		Mbutton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog add = new JDialog();
				add.setTitle("Dodaj");
				add.setLocationRelativeTo(null);
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setResizable(false);
				add.setSize(600, 500);

				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				add.setLayout(layout);

				String[] postojeciKlijenti = new String[dm.getAllKlijenti().size()];
				int i = 0;
				for(Map.Entry<Integer, Klijent> k :dm.getAllKlijenti().entrySet()) {
					postojeciKlijenti[i] = k.getValue().getKorIme();
					i++;
				}
				
				String[] postojeciTretmani = new String[dm.getAllTipovi().size()];
				i = 0;
				for(Map.Entry<Integer, TipTretmana> t :dm.getAllTipovi().entrySet()) {
					postojeciTretmani[i] = t.getValue().getnazivTretmana();
					i++;
				}
				
				JComboBox<String> afKlijent = new JComboBox<>(postojeciKlijenti);
				JComboBox<String> afTretmani = new JComboBox<>(postojeciTretmani);

				
				JButton btnrOk = new JButton("Potvrdi");
				
				dialog.getRootPane().setDefaultButton(btnrOk);

				add.add(new JLabel("Dodaj"), "span 2, align center");
				add.add(new JLabel("Klijent"), "cell 0 1");
				add.add(afKlijent, "cell 1 1");
				add.add(new JLabel("Tretman"), "cell 0 2");
				add.add(afTretmani, "cell 1 2");
				add.add(btnrOk,"span 2, align center");
												
		        //The pack() method calculates the preferred size of the dialog based on its contents,
		        //so when i did this after setting it visible it shrunk because the dialog was empty
				add.pack();
		        add.setLocationRelativeTo(null);	//centrira
		        add.setVisible(true);
		        
		        btnrOk.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
			        	add.setVisible(false);
		        		add.dispose();
		        		
		        		JDialog choose = new JDialog();
						choose.setTitle("Izaberi kozmeticara");
						choose.setLocationRelativeTo(null);
						choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						choose.setResizable(false);
						
						
						choose.setVisible(true);		       
						MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
						choose.setLayout(layout);
						//choose.setUndecorated(true);

						
						String nazivUsluge = dm.getUslugaPoTretmanu(((String)afTretmani.getSelectedItem()));
						ArrayList<String> treniraniKozmeticari = dm.TreniraniKozmeticari(nazivUsluge);
						JComboBox<String> afKozmeticari = new JComboBox<>(treniraniKozmeticari.toArray(new String[0]));

						
						JButton btnrOk = new JButton("Potvrdi");
						choose.add(new JLabel("Izberite kozmeticara"), "span 2, align center");
						choose.add(new JLabel("Obuceni kozmeticari"));
						choose.add(afKozmeticari);
						choose.add(btnrOk, "span 2, align center");
						choose.getRootPane().setDefaultButton(btnrOk);
						
						
						btnrOk.addActionListener(new ActionListener() {
				        	public void actionPerformed(ActionEvent e) {
			        			choose.setVisible(false);
				        		choose.dispose();
								
				        		dm.addZakazaniTretman((String)afKozmeticari.getSelectedItem(), (String)afKlijent.getSelectedItem(), LocalDateTime.now(), (String)afTretmani.getSelectedItem());
								
								createZakazaniTretmanTab();
								baseWindow();
				        		
				        	}
				        });
						choose.pack();
						choose.setLocationRelativeTo(null);	//centrira

					
	        	}
		     });	//action listener submit add
			}	//action performed
		});//action listener open add
		
		Mbutton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] postojeciKlijenti = new String[dm.getAllKlijenti().size()];
				int i = 0;
				for(Map.Entry<Integer, Klijent> k :dm.getAllKlijenti().entrySet()) {
					postojeciKlijenti[i] = k.getValue().getKorIme();
					i++;
				}
				
				String[] postojeciTretmani = new String[dm.getAllTipovi().size()];
				i = 0;
				for(Map.Entry<Integer, TipTretmana> t :dm.getAllTipovi().entrySet()) {
					postojeciTretmani[i] = t.getValue().getnazivTretmana();
					i++;
				}
				/*
				LocalTime openingTime = LocalTime.of(9, 0); // Example: 9:00 AM
		        LocalTime closingTime = LocalTime.of(17, 0); // Example: 5:00 PM

		        // Create a SpinnerDateModel with current date and time
		        SpinnerDateModel dateModel = new SpinnerDateModel();
		        dateModel.setCalendarField(Calendar.MINUTE);
		        JSpinner dateTimeSpinner = new JSpinner(dateModel);

		        // Set the spinner's editor to display date and time in desired format
		        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateTimeSpinner, "dd/MM/yyyy HH:mm");
		        dateTimeSpinner.setEditor(editor);

		        // Set the working hours constraint
		        DateTimeSpinnerEditor spinnerEditor = new DateTimeSpinnerEditor(dateTimeSpinner, openingTime, closingTime);
		        dateTimeSpinner.setEditor(spinnerEditor);

		        // Create a JFrame to hold the spinner
		        JFrame frame = new JFrame("DateTime Input");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setLayout(new FlowLayout());
		        frame.add(dateTimeSpinner);*/
				
				
				
    			JDialog add = new JDialog();
				add.setTitle("Izmjena");
				add.setLocationRelativeTo(null);
				add.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				add.setResizable(false);
				add.setSize(600, 500);
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				add.setLayout(layout);

				JComboBox<String> afKlijent = new JComboBox<>(postojeciKlijenti);
				JComboBox<String> afTretmani = new JComboBox<>(postojeciTretmani);

				
				JButton btnrOk = new JButton("Potvrdi");
				
				dialog.getRootPane().setDefaultButton(btnrOk);

				add.add(new JLabel("Dodaj"), "span 2, align center");
				add.add(new JLabel("Klijent"), "cell 0 1");
				add.add(afKlijent, "cell 1 1");
				add.add(new JLabel("Tretman"), "cell 0 2");
				add.add(afTretmani, "cell 1 2");
				add.add(btnrOk,"span 2, align center");
				
		        //The pack() method calculates the preferred size of the dialog based on its contents,
		        //so when i did this after setting it visible it shrunk because the dialog was empty
				add.pack();
		        add.setLocationRelativeTo(null);	//centrira
		        add.setVisible(true);
		        
		        btnrOk.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
	        		String NazivSelected = (String)afCTTNaziv.getSelectedItem();
					Double NovaCijena = 0.0;
					
					if(!afCijena.getText().equals("")) {
						NovaCijena = Double.parseDouble(afCijena.getText().trim());
					}
					
					if(NovaCijena == 0){
						JOptionPane.showMessageDialog(null, "Unesite sve informacije!");	
					}else {
			        	add.setVisible(false);
		        		add.dispose();
		      
		        		dm.changeCijena(NazivSelected, NovaCijena);
		        		
						createCjenovnikTab();
						baseWindow();
					}
	        	}
		       });
			}
		});

		Mbutton3.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog choose = new JDialog();
				choose.setTitle("Izbrisi");
				choose.setLocationRelativeTo(null);
				choose.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				choose.setResizable(false);
				
				
				choose.setVisible(true);		       
				MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[]");
				choose.setLayout(layout);

				
				String[] postojeciNazivi = new String[dm.getAllCjeneNazivi().size()];
				int i = 0;
				for(Map.Entry<String, Double> cjene : dm.getAllCjeneNazivi().entrySet()) {
					postojeciNazivi[i] = cjene.getKey();
					i++;
				}
				JComboBox<String> BrisanjeField = new JComboBox<>(postojeciNazivi);
				JButton btnChose = new JButton("Obrisi");

				choose.getRootPane().setDefaultButton(btnChose);

				choose.add(new JLabel("Brisanje"), "span 2, align center");
				choose.add(new JLabel("Naziv tretmana za brisanje"));
				choose.add(BrisanjeField);
				choose.add(btnChose, "span 2, align center");
				
				btnChose.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		String NazivSelected = (String)BrisanjeField.getSelectedItem();
	        			choose.setVisible(false);
		        		choose.dispose();
		        		
		        		dm.removeCjena(NazivSelected);		        		
		        		createCjenovnikTab();
						baseWindow();
		        		
		        	}
		        });
				choose.pack();
				choose.setLocationRelativeTo(null);	//centrira
			}
		});
			
		return tab9;
	}


}
