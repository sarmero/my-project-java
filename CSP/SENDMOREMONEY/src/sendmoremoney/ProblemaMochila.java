/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmoremoney;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

public class ProblemaMochila {

    public static void main(String[] args) {
        int numItems = 5;
        int[] pesos = {2, 3, 4, 5, 9};
        int[] valores = {3, 4, 5, 8, 10};
        int pesoMaximo = 15;

        Model model = new Model("ProblemaMochila");

        IntVar[] seleccionados = model.intVarArray("seleccionados", numItems, 0, 1);

        IntVar pesoTotal = model.intVar("pesoTotal", 0, pesoMaximo);
        // Restricción de peso máximo
        model.scalar(seleccionados, pesos, "=", pesoTotal).post();

        // Valor total a maximizar
        IntVar valorTotal = model.intVar("valorTotal", 0, IntVar.MAX_INT_BOUND);
        model.scalar(seleccionados, valores, "=", valorTotal).post();

        // Restricción de peso máximo
        model.arithm(pesoTotal, "<=", pesoMaximo).post();

        // Objetivo: maximizar el valor total
        model.setObjective(Model.MAXIMIZE, valorTotal);

        // Solución
        Solution solution = model.getSolver().findSolution();
    if (solution != null) {
            System.out.println("Objetivo máximo: " + solution.getIntVal(valorTotal));
            System.out.println("Peso total: " + solution.getIntVal(pesoTotal));
            System.out.print("Elementos seleccionados:");
            for (int i = 0; i < numItems; i++) {
                if (solution.getIntVal(seleccionados[i]) == 1) {
                    System.out.print(" " + i);
                }
            }
        } else {
            System.out.println("No se encontró solución.");
        }
    }
}
