/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc.compi_1_ejercicio_ll1;

/**
 *
 * @author grifiun
 */
public class Sintatico {
    public static int ID = 1;
    public static int NUM = 2;
    public static int PAR_A = 3;
    public static int PAR_C = 4;
    public static int SUMA = 5;
    public static int POR = 6;
    public static int FINCADENA = 0;
    
    public static boolean estado = false;

    int token = getToken();

    public void avanzar() {
	token = getToken();
    }

    public void consumir(int tok) {
	if (tok == token) {
		avanzar();
	} else {
		//manejo errors
		error(tok, token);
	}
    }

    public void main() {
            E();
    }

    public void E() {
            switch(token) {
                    case 1:
                            T(); Ep();
                            break;
                    case 2:
                            T(); Ep();
                            break;
                    case 3:
                            T(); Ep();
                            break;
                    default:
                            error(token);
            }
            if (estado != false) {
                System.out.println("cadena aceptada");
            }
    }

    public void Ep() {
	switch(token) {
		case 4:
                    break;
                case 0:
                        //lambda, no hago nada
			break;
		case 5:
			consumir(SUMA); T(); Ep();
			break;
		default:
			error(token);
	}
    }

    public void T() {
	switch(token) {
                case 1:
                        F(); Tp();
                        break;
                case 2:
                        F(); Tp();
                        break;
                case 3:
                        F(); Tp();
                        break;			
		default:
			error(token);
	}
    }

    public void Tp() {
	switch(token) {
		case 4:
                    break;
                case 5:
                    break;
                case 0: 
                    //lambda, no hago nada
                    break;
		case 6:
			consumir(POR); F(); Tp();
			break;
		default:
			error(token);
	}
    }

    public void F() {
	switch(token) {
                case 1:
                        consumir(ID);
                        break;
                case 2:
                        consumir(NUM);
                        break;
                case 3:
                        consumir(PAR_A); 
                        E(); 
                        consumir(PAR_C);
                        break;
		default:
			error(token);
	}
    }
    
    public void error(int token){
        System.out.println("Error: "+token);
        estado = true;
    }
    
    public void error(int tok, int token){
        System.out.println("Se esperaba otro token: "+tok);
        estado = true;
    }
}
