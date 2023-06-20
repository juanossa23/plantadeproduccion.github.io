
/**
 * Write a description of class PLANTA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CalculoProduccion {
    public static void main(String[] args) {
        // aquí la información la pone el operario
        System.out.println("Bienvenido al sistema de cálculo de producción JF Torres");
        System.out.println("Por favor, ingrese su nombre:");
        String nombre = System.console().readLine();

        // variables
        int produccionTotal = 0;
        double produccionPerdida = 0;
        String lineasParadas = "";

        // empieza a rellenar el campo los operarios
        for (int dia = 1; dia <= 7; dia++) {
            System.out.println("=== Día " + dia + " ===");

            // se solicita info del turno
            System.out.println("Ingrese el número de turno (1, 2 o 3):");
            int turno = Integer.parseInt(System.console().readLine());

            System.out.println("Ingrese el número de línea (1, 2 o 3):");
            int linea = Integer.parseInt(System.console().readLine());

            // aquí se calcula la producción del turno actual
            int produccion = 25000;

            // preguntar si se paró la línea
            System.out.println("¿La línea se detuvo en algún momento? (s/n):");
            String respuesta = System.console().readLine();

            if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("Ingrese la cantidad de tiempo en minutos que la línea se detuvo:");
                int tiempoParada = Integer.parseInt(System.console().readLine());

                // ajustar la producción de las líneas que se pararon
                produccionPerdida += (tiempoParada / 60.0) * produccion;
                lineasParadas += "Turno " + turno + ", Línea " + linea + "\n";
            }

            // agregar producción actual a la total
            produccionTotal += produccion;
        }

        // producción según operario
        System.out.println("Resumen de producción:");
        System.out.println("Producción total de la semana: " + produccionTotal);
        System.out.println("Producción perdida debido a líneas paradas: " + produccionPerdida);
        System.out.println("Líneas que se pararon:");
        System.out.println(lineasParadas);
    }
}
