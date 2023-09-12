/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

/**
 *
 * @author user
 */
public class calendario {

    public static void main(String[] args) {
        calendario cal = new calendario();
        //cal.unLevel();
        cal.mochila();
    }

    public void unLevel() {
        int numMeses = 4;
        int numTemas = 25;
        int numSemanasPorMes = 4;
        int maxTemasPorSemana = 4;
        int numNiveles = 5;

        Model model = new Model("AsignaturaScheduler");

        // Variables
        IntVar[][] asignaturasPorMes = new IntVar[numMeses][numSemanasPorMes];

        // Inicializar variables y establecer restricciones
        for (int mes = 0; mes < numMeses; mes++) {
            for (int semana = 0; semana < numSemanasPorMes; semana++) {
                asignaturasPorMes[mes][semana] = model.intVar("mes_" + mes + "_semana_" + semana, 0, numTemas - 1);
            }
            model.allDifferent(asignaturasPorMes[mes]).post(); // Restricción de temas diferentes por semana en un mes
        }

        // Restricciones de cambiar el tema cada mes
        for (int mes = 0; mes < numMeses - 1; mes++) {
            model.arithm(asignaturasPorMes[mes][0], "!=", asignaturasPorMes[mes + 1][0]).post();
        }

        // Restricciones de máximo de temas por semana
//        for (int mes = 0; mes < numMeses; mes++) {
//            for (int semana = 0; semana < numSemanasPorMes; semana++) {
//                IntVar[] temasPorSemana = new IntVar[maxTemasPorSemana];
//                for (int i = 0; i < maxTemasPorSemana; i++) {
//                    temasPorSemana[i] = asignaturasPorMes[mes][semana];
//                }
//                model.allDifferent(temasPorSemana).post(); // Restricción de temas diferentes por semana
//            }
//        }
        Solver solver = model.getSolver();
        solver.solve();

        // Print results
        for (int mes = 0; mes < numMeses; mes++) {
            System.out.println("Mes " + mes + ":");
            for (int semana = 0; semana < numSemanasPorMes; semana++) {
                int tema = asignaturasPorMes[mes][semana].getValue();
                System.out.println("  Semana " + semana + ": Tema " + tema);
            }
        }
    }

    public void fullLevel() {
        int numNiveles = 5;
        int numMeses = 4;
        int numTemas = 25;
        int numSemanasPorMes = 4;
        int maxTemasPorSemana = 4;

        Model model = new Model("AsignaturaScheduler");

        // Variables
        IntVar[][][][] asignaturasPorNivelMes = new IntVar[numNiveles][numMeses][numSemanasPorMes][maxTemasPorSemana];

        // Inicializar variables y establecer restricciones
        for (int nivel = 0; nivel < numNiveles; nivel++) {
            for (int mes = 0; mes < numMeses; mes++) {
                for (int semana = 0; semana < numSemanasPorMes; semana++) {
                    IntVar[] temasPorSemana = new IntVar[maxTemasPorSemana];
                    for (int i = 0; i < maxTemasPorSemana; i++) {
                        asignaturasPorNivelMes[nivel][mes][semana][i] = model.intVar("nivel_" + nivel + "_mes_" + mes + "_semana_" + semana + "_tema_" + i, 0, numTemas - 1);
                        temasPorSemana[i] = asignaturasPorNivelMes[nivel][mes][semana][i];
                    }
                    model.allDifferent(temasPorSemana).post(); // Restricción de temas diferentes por semana en nivel y mes
                }
            }
        }

         // Restricciones de cambiar el tema cada mes
        for (int nivel = 0; nivel < numNiveles; nivel++) {
            for (int mes = 0; mes < numMeses - 1; mes++) {
                model.arithm(asignaturasPorNivelMes[nivel][mes][0][0], "!=", asignaturasPorNivelMes[nivel][mes + 1][0][0]).post();
            }
        }
//        
//        for (int tema = 0; tema < numTemas; tema++) {
//            IntVar[] temaEnSemestre = new IntVar[numNiveles * numMeses * numSemanasPorMes * maxTemasPorSemana];
//            int idx = 0;
//            for (int nivel = 0; nivel < numNiveles; nivel++) {
//                for (int mes = 0; mes < numMeses; mes++) {
//                    for (int semana = 0; semana < numSemanasPorMes; semana++) {
//                        for (int i = 0; i < maxTemasPorSemana; i++) {
//                            temaEnSemestre[idx++] = asignaturasPorNivelMes[nivel][mes][semana][i];
//                        }
//                    }
//                }
//            }
//            model.sum(temaEnSemestre, "=", 1).post(); // Cada tema se cubre al menos una vez
//        }
        
        IntVar[] temasEnSemestre = new IntVar[numNiveles * numMeses * numSemanasPorMes * maxTemasPorSemana];
        for (int nivel = 0; nivel < numNiveles; nivel++) {
            for (int mes = 0; mes < numMeses; mes++) {
                for (int semana = 0; semana < numSemanasPorMes; semana++) {
                    for (int i = 0; i < maxTemasPorSemana; i++) {
                        temasEnSemestre[nivel * numMeses * numSemanasPorMes * maxTemasPorSemana +
                                       mes * numSemanasPorMes * maxTemasPorSemana +
                                       semana * maxTemasPorSemana + i] = asignaturasPorNivelMes[nivel][mes][semana][i];
                    }
                }
            }
        }
        model.sum(temasEnSemestre, ">=", numTemas).post(); // Cada tema se cubre al menos una vez en el semestre

        
        // Restricciones de máximo de temas por semana...
        Solver solver = model.getSolver();
        solver.solve();

        // Print results
        for (int nivel = 0; nivel < numNiveles; nivel++) {
            System.out.println("Nivel " + nivel + ":");
            for (int mes = 0; mes < numMeses; mes++) {
                System.out.println("  Mes " + mes + ":");
                for (int semana = 0; semana < numSemanasPorMes; semana++) {
                    System.out.print("    Semana " + semana + ": Temas ");
                    for (int i = 0; i < maxTemasPorSemana; i++) {
                        int tema = asignaturasPorNivelMes[nivel][mes][semana][i].getValue();
                        System.out.print(tema + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
    
    public void mochila(){
        // Crear un modelo
        Model model = new Model("KnapsackProblem");
        // Crear las variables
        IntVar[] items = model.intVarArray("items", 5, 0, 1);
        IntVar weight = model.intVar("weight", 1, 15);
        // Crear las restricciones
        model.sum(items, "<=", weight);
        // Crear el objetivo
        //model.max(model.sum(items));
        model.setObjective(Model.MAXIMIZE, weight);
        // Crear el solucionador
        Solver solver = model.getSolver();
        // Resolver el modelo
        solver.solve();
        // Imprimir la solución
        for (int i = 0; i < items.length; i++) {
            System.out.println("Item " + (i + 1) + ": " + items[i].getValue());
        }
        System.out.println("Weight: " + weight.getValue());
    }
}
