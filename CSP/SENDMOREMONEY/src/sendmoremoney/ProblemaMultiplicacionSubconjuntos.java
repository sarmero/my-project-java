/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmoremoney;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

public class ProblemaMultiplicacionSubconjuntos {
    public static void main(String[] args) {
        int[] conjunto = {3, 7, 1, 8, 4, 5};
        int objetivo = 20;

        Model model = new Model("ProblemaMultiplicacionSubconjuntos");

        IntVar[] seleccionados = model.intVarArray("seleccionados", conjunto.length, 0, 1);

        // Restricción: el producto de los elementos seleccionados es igual al objetivo
        IntVar productoSeleccionado = model.intVar("productoSeleccionado", objetivo, objetivo);
        model.scalar(seleccionados, conjunto, "=", productoSeleccionado).post();

        // Solución
        Solution solution = model.getSolver().findSolution();
        if (solution != null) {
            System.out.println("Subconjunto cuyo producto es " + objetivo + ":");
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

