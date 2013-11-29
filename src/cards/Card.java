package cards;

import static cards.Suit.club;
import static cards.Suit.diamond;
import static cards.Suit.heart;
import static cards.Suit.spade;

import java.io.File;

public enum Card {

	AceOfHearts(1, heart),
	AceOfSpades(1, spade),
	AceOfClubs(1, club),
	AceOfDiamonds(1, diamond),
	
	TwoOfHearts(2, heart),
	TwoOfSpades(2, spade),
	TwoOfClubs(2, club),
	TwoOfDiamonds(2, diamond),
	
	ThreeOfHearts(3, heart),
	ThreeOfSpades(3, spade),
	ThreeOfClubs(3, club),
	ThreeOfDiamonds(3, diamond),
	
	FourOfHearts(4, heart),
	FourOfSpades(4, spade),
	FourOfClubs(4, club),
	FourOfDiamonds(4, diamond),
	
	FiveOfHearts(5, heart),
	FiveOfSpades(5, spade),
	FiveOfClubs(5, club),
	FiveOfDiamonds(5, diamond),
	

	SixOfHearts(6, heart),
	SixOfSpades(6, spade),
	SixOfClubs(6, club),
	SixOfDiamonds(6, diamond),
	
	SevenOfHearts(7, heart),
	SevenOfSpades(7, spade),
	SevenOfClubs(7, club),
	SevenOfDiamonds(7, diamond),
	
	EightOfHearts(8, heart),
	EightOfSpades(8, spade),
	EightOfClubs(8, club),
	EightOfDiamonds(8, diamond),
	
	NineOfHearts(9, heart),
	NineOfSpades(9, spade),
	NineOfClubs(9, club),
	NineOfDiamonds(9, diamond),
	
	TenOfHearts(10, heart),
	TenOfSpades(10, spade),
	TenOfClubs(10, club),
	TenOfDiamonds(10, diamond),
	
	JackOfHearts(11, heart),
	JackOfSpades(11, spade),
	JackOfClubs(11, club),
	JackOfDiamonds(11, diamond),
	
	QueenOfHearts(12, heart),
	QueenOfSpades(12, spade),
	QueenOfClubs(12, club),
	QueenOfDiamonds(12, diamond),
	
	KingOfHearts(13, heart),
	KingOfSpades(13, spade),
	KingOfClubs(13, club),
	KingOfDiamonds(13, diamond)
	
	;
	
	/*********************************************/
	
	private final int value;
	private final Suit suit;
	private final File imageFile;
	
	Card(int value, Suit suit){
		this.value = value;
		this.suit = suit;
		this.imageFile = getImageFile();
	}

	/**
	 * @return The image file corresponding to this @Card  */
	private File getImageFile(){
		return new File(this.getImageFileName());
	}
	
	/** 
	 * @return The name of the image file corresponding to this @Card */
	public String getImageFileName(){
		String fileName = "playing_cards_images/Playing_card_" + suit + "_" + value + ".jpg";		
		return fileName;
	}
	
	public int getValue(){
		if( this.value > 9){
			return 0;
		}
		
		return value;	
	}
	
	public static void main(String[] args){
		System.out.println(KingOfSpades.getImageFileName());
	}
	
}
