/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmoremoney;

/**
 *
 * @author user
 */
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.Solution;

public class MultiplicationSolver {
    public static void main(String[] args) {
        Model model = new Model("Target Multiplication Problem");
        
        int targetNumber = 200;
        int[] conjuntoNumeros = {20, 30, 40, 10, 50, 60};
        
        IntVar[] numerosSeleccionados = model.intVarArray("NumerosSeleccionados", conjuntoNumeros.length, 0, 1);
        
        // Restricción: la multiplicación de los números seleccionados debe ser igual al objetivo
        model.scalar(numerosSeleccionados, conjuntoNumeros, "=", targetNumber).post();
        
        Solution solution = model.getSolver().findSolution();
        
        if (solution != null) {
            System.out.println("Números seleccionados: ");
            for (int i = 0; i < conjuntoNumeros.length; i++) {
                if (solution.getIntVal(numerosSeleccionados[i]) == 1) {
                    System.out.println(conjuntoNumeros[i]);
                }
            }
        } else {
            System.out.println("No se encontró solución.");
        }
    }
}

