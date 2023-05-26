import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //3. Escribe un programa que juegue con el usuario a adivinar un número. El
        //ordenador debe generar un número entre 1 y 500, y el usuario tiene que intentar
        //adivinarlo.
        //Para ello, cada vez que el usuario introduce un valor, el ordenador debe
        //decirle al usuario si el número que tiene que adivinar es mayor o menor que el
        //que ha introducido el usuario. Cuando consiga adivinarlo, debe indicarlo e
        //imprimir en pantalla el número de veces que el usuario ha intentado adivinar el
        //número.
        //Si el usuario introduce algo que no es un número, debe indicarlo en
        //pantalla, lanzar una excepción y contarlo como un intento. Investigar qué
        //excepción controla el tipo de datos ingresados.

        int numero = (int) (Math.random()*500+1);
        int numeroAdivinar = 0;
        int intentos = 0;
        do {
            try{
                System.out.println("Ingrese un numero entre 1 y 500 para ver si lo adivina: ");
                Scanner sc = new Scanner(System.in);
                numeroAdivinar = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Cuidado! Debe ingresar numeros enteros.");
                intentos++;
            }
            if(numeroAdivinar < numero){
                System.out.println("Debe ingresar un numero mayor.");
                intentos++;
            } else if (numeroAdivinar > numero) {
                System.out.println("Debe ingresar un numero menor.");
                intentos++;
            }else System.out.println("Ha adivinado el numero luego de " + intentos + " intentos.");
        }while (numeroAdivinar != numero);

        //4. Crea una clase colegio que almacene el listado de los alumnos
        //(compuestos por su nombre y nacionalidad). La clase tendrá los siguientes
        //métodos:
        //agregarAlumno(Alumno alumno): añade la nacionalidad de un nuevo
        //alumno
        //verNacionalidad(String nacionalidad): Muestra la nacionalidad y el número de
        //alumnos de esa nacionalidad
        //cuantos(): Muestra cuántas nacionalidades diferentes existen en el colegio.
        //borrar(Alumno alumno): Elimina los datos insertados.
        //VerTodos(): Muestra las distintas nacionalidades y el número de alumnos que
        //existen por nacionalidad.
        //Para todos estos métodos se deben generar distintas validaciones para prevenir
        //errores en la ejecución. Por ej: Que todos los alumnos tengan una nacionalidad;
        //Que exista el alumno que se quiere borrar, etc.

        Alumno a1 = new Alumno("Nazareno", "Argentino");
        Alumno a2 = new Alumno("Mikkel", "Aleman");
        Alumno a3 = new Alumno("Satoshi", "Japones");
        Colegio.agregarAlumno(a1);
        Colegio.agregarAlumno(a2);
        //Colegio.verNacionalidad("Cubano");
        Colegio.cuantos();
        //Colegio.borrar(a3);
        Colegio.verTodos();
    }
}