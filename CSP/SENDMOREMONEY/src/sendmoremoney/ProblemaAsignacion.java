/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmoremoney;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

public class ProblemaAsignacion {

    public static void main(String[] args) {

        int[] conjunto = {3, 7, 1, 8, 4, 5};
        int objetivo = 12;

        Model model = new Model("ProblemaSumaSubconjuntos");

        IntVar[] seleccionados = model.intVarArray("seleccionados", conjunto.length, 0, 1);

        // Restricción: la suma de los elementos seleccionados es igual al objetivo
        IntVar sumaSeleccionada = model.intVar("sumaSeleccionada", objetivo, objetivo);
        model.scalar(seleccionados,conjunto, "=", sumaSeleccionada).post();

        // Solución
        Solution solution = model.getSolver().findSolution();
        if (solution != null) {
            System.out.println("Subconjunto que suma " + objetivo + ":");
            for (int i = 0; i < conjunto.length; i++) {
                if (solution.getIntVal(seleccionados[i]) == 1) {
                    System.out.print(conjunto[i] + " ");
                }
            }
        } else {
            System.out.println("No se encontró solución.");
        }

    }
}
