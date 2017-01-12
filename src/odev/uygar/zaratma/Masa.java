package odev.uygar.zaratma;

import java.io.IOException;
import java.util.Random;

public class Masa {
	
	static class Zar {
		private static final int min = 1;
		private static final int max = 7;
		private static Random random = new Random();
		
		public static final int salla() {
			int result = 0;
			while((result = random.nextInt(max)) < min) {
				//
			};
			
			return result;
		}
	}
	
	
	private static final int[] skorBord = new int[] { 0, 0 };
	private static final Zar zar = new Zar();

	private static void enterBekle() {
		try {
			System.in.read();
			while (System.in.available() > 0) {
				System.in.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int oyun = 1;
		while (skorBord[0] < 5 && skorBord[1] < 5) {
			System.out.println("Oyuncu 1 zar sallayin");
			enterBekle();
			int gelen1 = zar.salla();
			System.out.println("Oyuncu 1 gelen zar = " + gelen1);

			System.out.println("Oyuncu 2 zar sallayin");
			enterBekle();
			int gelen2 = zar.salla();
			System.out.println("Oyuncu 2 gelen zar = " + gelen2);

			int kazanan = -1;

			if (gelen1 > gelen2) {
				kazanan = 0;
				skorBord[0]++;
			} else if (gelen2 > gelen1) {
				kazanan = 1;
				skorBord[1]++;
			}

			if (kazanan > -1) {
				System.out.println(String.format("Oyun %d kazanan %d. oyuncu", oyun, kazanan + 1));
				System.out.println(String.format("Skor oyuncu 1 = %d - oyuncu 2 = %d", skorBord[0], skorBord[1]));
				
			} else {
				System.out.println(String.format("Oyun %d berabere yeniden zar atin", oyun));
			}
			oyun++;
		}

		if (skorBord[0] > skorBord[1]) {
			System.out.println(String.format("Kazanan oyuncu %d", 1));
		} else {
			System.out.println(String.format("Kazanan oyuncu %d", 2));
		}
	}

}
