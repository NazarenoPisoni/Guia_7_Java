import java.util.*;

public class Colegio {
    private static List<Alumno> alumnos = new ArrayList<>();
    public static void agregarAlumno(Alumno a) throws Exception {
        if(a.getNacionalidad() == null || a.getNacionalidad().isEmpty()){
            throw new Exception("El alumno debe tener una nacionalidad.");
        }
        alumnos.add(a);
    }

    public static void verNacionalidad(String nacionalidad) throws Exception{
        int contador = 0;
        for(Alumno a :  alumnos){
            if(a.getNacionalidad().equals(nacionalidad)){
                contador++;
            }
        }
        if(contador == 0){
            throw new Exception("No hay alumnos con la nacionalidad proporcionada: " + nacionalidad);
        }
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Cantidad de alumnos con esa nacionalidad: " + contador);
    }

    public static void cuantos() throws Exception{
        try{
            Set<String> nacionalidades = new HashSet<>();
            for(Alumno a : alumnos){
                nacionalidades.add(a.getNacionalidad());
            }
            if(nacionalidades.isEmpty()){
                throw new Exception("No se encontraron nacionalidades en el colegio.");
            }
            System.out.println("Cantidad de nacionalidades diferentes: " + nacionalidades.size());
        }catch (Exception e){
            System.out.println("Error al obtener la cantidad de nacionalidades: " + e.getMessage());
        }
    }

    public static void borrar(Alumno a) throws Exception{
        try {
            if(!alumnos.contains(a)){
                throw new Exception("El alumno no existe.");
            }
            alumnos.remove(a);
        }catch (Exception e){
            System.out.println("Error al intentar borrar un alumno: " + e.getMessage());
        }
    }

    public static void verTodos() throws Exception{
        Map<String, Integer> nacionalidades = new HashMap<>();

        if(alumnos == null){
            throw new Exception("La lista de alumnos no puede estar vacía.");
        }

        for(Alumno a : alumnos){
            if(a == null){
                throw new Exception("Se encontró un alumno nulo en la lista.");
            }
            if(a.getNacionalidad()==null || a.getNacionalidad().isEmpty()){
                throw new Exception("La nacionalidad del alumno es nula o vacía.");
            }

            if(!nacionalidades.containsKey(a.getNacionalidad())){
                nacionalidades.put(a.getNacionalidad(), 1);
            }else{
                nacionalidades.put(a.getNacionalidad(), nacionalidades.get(a.getNacionalidad()) + 1);
            }
        }

        System.out.println("Cantidad de nacionalidades existentes: " + nacionalidades.size());

        for(Map.Entry<String, Integer> entry : nacionalidades.entrySet()){
            System.out.println("Nacionalidad: " + entry.getKey() + " , cantidad: " + entry.getValue());
        }
    }
}
