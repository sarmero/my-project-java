/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallerreinasajedrez;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.variables.IntVar;

/**
 *
 * @author user
 */
public class HorsePlacement {

    public static void main(String[] args) {
        int boardSize = 8;
        int numHorses = 10;

        Model model = new Model("Horse Placement");

        // Variables
        IntVar[] horses = model.intVarArray(numHorses, 1, boardSize * boardSize);

        // Constraints: Horses must not attack each other using arc constraint
        Constraint arcConstraint;
        for (int i = 0; i < numHorses; i++) {
            for (int j = i + 1; j < numHorses; j++) {
                arcConstraint = createArcConstraint(horses[j], horses[i]);
                model.post(arcConstraint);
            }
        }

        String vec[];
        // Solver
        Solver solver = model.getSolver();
        solver.solve();
        int n;

        // Print solutions
        while (solver.solve()) {
            vec = new String[65];
            n = 1;

            for (int i = 0; i < 65; i++) {
                vec[i] = "-";
            }

            for (IntVar horse : horses) {
                System.out.println("Horse at position: " + horse.getValue());
                vec[horse.getValue()] = "c";
            }
            //System.out.println();

            for (int i = 1; i < 65; i++) {
                //System.out.print(vec[i] + " ");
                n++;
                if (n % 9 == 0) {
//                    System.out.println();
                    n = 1;
                }
            }
            System.out.println("------");
        }
    }
    
     private static Constraint createArcConstraint(IntVar horse1, IntVar horse2) {
        Model model = horse1.getModel();
        IntVar dx = model.intVar(-2, 2);
        IntVar dy = model.intVar(-2, 2);

        // Compute horizontal and vertical distances
        model.arithm(dx, "=", horse2.div(8).sub(horse1.div(8)).intVar()).post();
        model.arithm(dy, "=", horse2.mod(8).sub(horse1.mod(8)).intVar()).post();

        // Constraint: Arc constraint for horse placement
        return model.or(
                model.and(model.arithm(dx, "!=", 1), model.arithm(dy, "!=", 2)),
                model.and(model.arithm(dx, "!=", 2), model.arithm(dy, "!=", 1))
                
        );
    }
}
