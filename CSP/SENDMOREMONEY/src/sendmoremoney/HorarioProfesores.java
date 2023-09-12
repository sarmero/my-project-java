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
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.IntVar;

public class HorarioProfesores {

    public static void main(String[] args) {
        int NumSemana = 4; // Cambia este valor según la cantidad de profesores
        int numMeses = 4;
        int bloque = 4;
        int numProfesor = 5;
        int numMaterias = 4;

        Model model = new Model("HorarioProfesores");

        // Variables
        IntVar[][][][] horario = new IntVar[NumSemana][bloque][numMeses][numProfesor * numMaterias];

        for (int p = 0; p < NumSemana; p++) {
            for (int b = 0; b < bloque; b++) {
                for (int m = 0; m < numMeses; m++) {
                    for (int s = 0; s < numProfesor * numMaterias; s++) {
                        horario[p][b][m][s] = model.intVar("Profesor_" + p + "_blo_" + b + "_Mes_" + m + "_Slot_" + s, 0, 1);
                    }
                }
            }
        }

        // Restricciones
        for (int p = 0; p < NumSemana; p++) {
            for (int b = 0; b < bloque; b++) {
                for (int m = 0; m < numMeses; m++) {
                    IntVar[] slots = new IntVar[numProfesor * numMaterias];
                    for (int s = 0; s < numProfesor * numMaterias; s++) {
                        slots[s] = horario[p][b][m][s];
                    }
                    model.sum(slots, "=", 1).post(); // Un bloque por semana para cada profesor
                }
            }
        }
        // Solución
        Solution solution = model.getSolver().findSolution();
        if (solution != null) {
            for (int p = 0; p < NumSemana; p++) {
                for (int b = 0; b < bloque; b++) {
                    for (int m = 0; m < numMeses; m++) {
                        System.out.print("Semana " + (p + 1)+ ", bloq " + (b + 1) + ", Mes " + (m + 1) + ": ");
                        for (int s = 0; s < numProfesor * numMaterias; s++) {
                            if (solution.getIntVal(horario[p][b][m][s]) == 1) {
                                System.out.print("Profesores " + (s / numMaterias + 1) + ", Materia " + (s % numMaterias + 1) + " | ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("");
                }
                System.out.println("---------------------------------------------------------");
            }
        } else {
            System.out.println("No se encontró solución.");
        }
    }
}
