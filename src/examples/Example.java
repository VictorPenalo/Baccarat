package examples;

import static utilities.LastDigit.stripLastDigit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utilities.LastDigit;


public class Example implements ActionListener {	
	
	public static void main(String[] args){
		
		System.out.println(stripLastDigit(9));
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("WHATEVER");		
	}

}
