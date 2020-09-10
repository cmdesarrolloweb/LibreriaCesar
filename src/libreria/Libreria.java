
package libreria;

import libreria.interfaz.InterfazLibreria;

public class Libreria {

    public static void main(String[] args) throws Exception {
        
        InterfazLibreria interfaz = new InterfazLibreria();
        while(true){
            interfaz.menu();
        }
    }
    
}
