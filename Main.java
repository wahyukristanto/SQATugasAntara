package main;

import Dadu;


public class Main {
  public static void main(String[] args) {
    Dadu cobadadu = new Dadu();
    
	for(int i=0; i<7; i++){
      
cobadadu.lempar();
    }
 
System.out.println(cobadadu.toString());
  }
}
