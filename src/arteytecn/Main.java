package arteytecn;

import processing.core.PApplet;
import processing.serial.*;
import processing.sound.*;

public class Main extends PApplet{
	
	
	boolean teclas[] = new boolean[6];
	//Inicio el puerto para el serial 
	Serial puerto;
	//valores que contaran cuantas veces levanta o no el objeto
	int count1,count2,count3;
	// valores que se envian a la suma 1/0
	int contador1, contador2, contador3, contador4, contador5, contador6;
	// validar las sumas para prender o apagar las luces
	int suma, sumaAnterior;
	//cargar audio inicial
	SoundFile starMusic;
	// Cargar los archivos de audio de los diferentes inicios
	SoundFile startOne, startTwo, startThree;
	// Cargar los archivos de audio para los objetos con parte uno y dos
	SoundFile objetOne1, objetOne2, objetTwo1, objetTwo2, objetThree1, objetThree2;

	public static void main(String[] args) {
			PApplet.main("arteytecn.Main");	
			

	}
	
	public void settings() {
		size(500, 500);	
		
	}

	public void setup() {
		
	//puerto = new Serial(this, Serial.list()[0], 9600);
		starMusic = new SoundFile(this, "melendi.mp3");
		startOne = new SoundFile(this, "ahora.mp3");
		startTwo = new SoundFile(this, "ahora.mp3");
		startThree = new SoundFile(this, "ahora.mp3");
		objetOne1 = new SoundFile(this, "melendi.mp3");
		objetOne2 = new SoundFile(this, "tini.mp3");
		objetTwo1 = new SoundFile(this, "tutu.mp3");
		objetTwo2 = new SoundFile(this, "joy.mp3");
		objetThree1 = new SoundFile(this, "tini.mp3");
		objetThree2 = new SoundFile(this, "joy.mp3");
		teclas[0] = false;
		teclas[1] = false;
		teclas[2] = false;

	}
	

	public void draw() {
	//	enviarSuma();
	}
	
	public void keyReleased() {
	
	
		if (keyCode == UP) {
			count1 ++;
			contador1= 0;
			teclas[0] = false;
			
			if(count1==1) {
				System.out.println("Elegi el primer audio");
				startOne.play();
				objetOne2.stop();
				objetTwo1.stop();
				objetTwo2.stop();
				objetThree1.stop();
				objetThree2.stop();		
			}
			if(count1==2) {
				System.out.println("Primer audio-Arriba");
				startOne.stop();
				startTwo.stop();
				startThree.stop();
				objetOne1.play();
				objetOne2.stop();
				objetTwo1.stop();
				objetTwo2.stop();
				objetThree1.stop();
				objetThree2.stop();	
				
			}
			if(count1==3) {
				System.out.println("Segundo audio-Arriba");
				objetOne1.stop();
				objetOne2.play();
				objetTwo1.stop();
				objetTwo2.stop();
				objetThree1.stop();
				objetThree2.stop();	
			}
			
			}
		if (keyCode == DOWN) {
			count2 ++;
			contador2= 0;
			teclas[1] = false;
			if(count2==1) {
				System.out.println("Elegi el segundo audio");
				startTwo.play();
				objetOne2.stop();
				objetTwo1.stop();
				objetTwo2.stop();
				objetThree1.stop();
				objetThree2.stop();		
			}
			if(count2==2) {
				System.out.println("Primer audio-Abajo");
				startOne.stop();
				startTwo.stop();
				startThree.stop();
				objetOne1.stop();
				objetOne2.stop();
				objetTwo1.play();
				objetTwo2.stop();
				objetThree1.stop();
				objetThree2.stop();
				
			}
			if(count2==3) {
				System.out.println("Segundo audio-Abajo");
				startOne.stop();
				startTwo.stop();
				startThree.stop();
				objetOne1.stop();
				objetOne2.stop();
				objetTwo1.stop();
				objetTwo2.play();
				objetThree1.stop();
				objetThree2.stop();	
				
			}
		}
		if (keyCode == LEFT) {
			count3 ++;
			contador3= 0;
			teclas[2] = false;
			if(count3==1) {
				System.out.println("Elegi el tercer audio");
				startThree.play();
				objetOne2.stop();
				objetTwo1.stop();
				objetTwo2.stop();
				objetThree1.stop();
				objetThree2.stop();		
			}
			if(count3==2) {
				System.out.println("Primer audio-Izquierda");
				startOne.stop();
				startTwo.stop();
				startThree.stop();
				objetOne1.stop();
				objetOne2.stop();
				objetTwo1.stop();
				objetTwo2.stop();
				objetThree1.play();
				objetThree2.stop();		
			}
			if(count3==3) {
				System.out.println("Segundo audio-Izquierda");
				objetOne2.stop();
				objetTwo1.stop();
				objetTwo2.stop();
				objetThree1.stop();
				objetThree2.play();	
			}
		
		}
		
		if(startOne.isPlaying()) {
			count1++;
			count2=1;
//			System.out.println("cambioElAudioDos"+count2);
			count3=1;
//			System.out.println("cambioElAudioTres"+count3);
		}else if(startTwo.isPlaying()) {
			count2++;
			count1=1;
//			System.out.println("cambioElAudioUno"+count1);
			count3=1;
//			System.out.println("cambioElAudioTres"+count3);
		}else if(startThree.isPlaying()) {
			count3++;
			count1=1;
//			System.out.println("cambioElAudioUno"+count1);
			count2=1;
//			System.out.println("cambioElAudioDos"+count2);
		}
	
		suma= contador1+contador2+contador3;
		System.out.println(suma);
		
		}

	public void keyPressed() {
		if (keyCode == UP) {
			teclas[0] = true;
			contador1= 1;
		}
		
		if (keyCode == DOWN) {
			teclas[1] = true;
			contador2=1;
					}
		if (keyCode == LEFT) {
			teclas[2] = true;
			contador3=1;	
		}
		
		
	}
	
/*	public void enviarSuma() {
		if (suma != sumaAnterior) {
			int numSuma = suma;
			if (numSuma == 3) {
				puerto.write("A");
				sumaAnterior = suma;
				System.out.println("EnvioZona3");
			}
			if (numSuma == 2) {
				puerto.write("B");
				sumaAnterior = suma;
				System.out.println("EnvioZona2");
			}
			if (numSuma == 1) {
				puerto.write("C");
				sumaAnterior = suma;
				System.out.println("EnvioZOna1");
			}
			
			if (numSuma == 0) {
				puerto.write("D");
				sumaAnterior = suma;
				System.out.println("Apagar todas las luces");
			}
		}
	}*/
}
