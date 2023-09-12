/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmoremoney;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class AsignaturaScheduler {

    public static void main(String[] args) {

        int numDocentes = 5;
        int numNiveles = 5;
        int numAsignaturasPorNivel = 5;
        int numSemanas = 16;
        int numBloquesPorSemana = 2;
        int maxAsignaturasPorBloquePorDocente = 2;
        int maxHorasPorDiaPorBloquePorDocente = 12;
        int minHorasPorAsignatura = 4;
        int maxHorasPorAsignatura = 6;

        Model model = new Model("AutomaticScheduleGenerator");

        // Variables para representar el calendario
        IntVar[][][][][] calendario = new IntVar[numDocentes][numNiveles][numAsignaturasPorNivel][numSemanas][numBloquesPorSemana];


        // Variables
        IntVar[][][] asignaturas = new IntVar[numNiveles][numSemanas][numBloquesPorSemana];
        IntVar[] horasPorProfesor = new IntVar[numNiveles * numSemanas * numBloquesPorSemana];

        for (int nivel = 0; nivel < numNiveles; nivel++) {
            for (int semana = 0; semana < numSemanas; semana++) {
                for (int bloque = 0; bloque < numBloquesPorSemana; bloque++) {
                    asignaturas[nivel][semana][bloque] = model.intVar("asignatura_" + nivel + "_" + semana + "_" + bloque, 0, 1);
                    horasPorProfesor[nivel * numSemanas * numBloquesPorSemana + semana * numBloquesPorSemana + bloque] 
                            = model.intVar("horas_" + nivel + "_" + semana + "_" + bloque, 0, maxHorasPorDiaPorBloquePorDocente);
                }
            }
        }

        // Restricciones...
        for (int nivel = 0; nivel < numNiveles; nivel++) {
            for (int semana = 0; semana < numSemanas; semana++) {
                for (int bloque = 0; bloque < numBloquesPorSemana; bloque++) {
                    IntVar[] asignaturasEnBloque = new IntVar[maxAsignaturasPorBloquePorDocente];
                    for (int i = 0; i < maxAsignaturasPorBloquePorDocente; i++) {
                        asignaturasEnBloque[i] = asignaturas[nivel][semana][bloque];
                    }
                    model.sum(asignaturasEnBloque, "<=", maxAsignaturasPorBloquePorDocente).post();
                }
            }
        }
        
        IntVar[] horasPorDocente = new IntVar[numNiveles * numSemanas * numBloquesPorSemana];
        for (int nivel = 0; nivel < numNiveles; nivel++) {
            for (int semana = 0; semana < numSemanas; semana++) {
                for (int bloque = 0; bloque < numBloquesPorSemana; bloque++) {
                    horasPorDocente[nivel * numSemanas * numBloquesPorSemana + semana * numBloquesPorSemana + bloque] = 
                            model.intVar("horas_docente_" + nivel + "_" + semana + "_" + bloque, 0, maxHorasPorDiaPorBloquePorDocente);
                }
            }
        }
        // Constraints

        Solver solver = model.getSolver();
        solver.solve();

        solver.showStatistics();
        solver.showSolutions();

        // Print results
        int totalHoras = 0;
        for (int nivel = 0; nivel < numNiveles; nivel++) {
            for (int semana = 0; semana < numSemanas; semana++) {
                for (int bloque = 0; bloque < numBloquesPorSemana; bloque++) {
                    int asignaturaHoras = horasPorProfesor[nivel * numSemanas * numBloquesPorSemana + semana * numBloquesPorSemana + bloque].getValue();
                    totalHoras += asignaturaHoras;
                    System.out.println("Nivel " + nivel + ", Semana " + semana + ", Bloque " + bloque + ": " + asignaturaHoras + " horas");
                }
            }
        }

        System.out.println("Total horas: " + totalHoras);
    }
}
