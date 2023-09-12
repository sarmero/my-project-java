package view;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArrayToFile {

    public String[] dataArray = {"calendar",
        "curriculum", "day_week", "department", "department_chat", "department_messages",
        "evaluation", "event", "faculty", "formation", "inscription", "material", "note", "observation", "offer",
        "plan_study", "profession", "programming", "publications", "publication_comment",
        "publication_like", "region", "rolle", "semester", "states", "state_offer", "student", "subject",
        "teacher", "theme", "timetable", "title_biography", "type_evaluation", "type_event",
        "type_material", "type_teacher"};

    public void createArchivo(int number) {
        for (int i = 0; i < dataArray.length; i++) {
            String fileName;
            String content;

            switch (number) {
                case 1:
                    fileName = dataArray[i] + "Controller.js"; // Nombre del archivo con índice
                    content = contentController(dataArray[i]);
                    break;
                default:
                    fileName = dataArray[i] + ".js"; // Nombre del archivo con índice
                    content = contentRouter(dataArray[i]);
                    break;
            }

            try {
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(content);

                bufferedWriter.close();
                System.out.println("Archivo creado exitosamente: " + fileName);
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo " + fileName + ": " + e.getMessage());
            }
        }

    }
    
    public void createIndexRouter(){
        for (int i = 0; i < dataArray.length; i++){
            System.out.println( "const "+dataArray[i]+"Controller = require('./"+dataArray[i]+"Controller.js');");
        }
    }
    
    public void createApp(){
        for (int i = 0; i < dataArray.length; i++){
            System.out.println( "var "+dataArray[i]+"Router = require('./routes/"+dataArray[i]+"');");
        }
        
        System.out.println("------------------------------------------------------------------");
        
        for (int i = 0; i < dataArray.length; i++){
            System.out.println( "app.use('/"+dataArray[i]+"', "+dataArray[i]+"Router);");
        }
        
        System.out.println("------------------------------------------------------------------");
        
        for (int i = 0; i < dataArray.length; i++){
            System.out.println( dataArray[i]+"Controller,");
        }
    }
    
    public void parametro(String[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println( array[i]+": req.body."+array[i]+",");
        }
        
        System.out.println("------------------------------------------------------------------");
        
        for (int i = 0; i < array.length; i++){
            System.out.println( array[i]+": req.body."+array[i]+"|| project."+array[i]+",");
        }
    }

    public String contentRouter(String name) {
        String content = "var express = require('express');\n"
                + "var router = express.Router();\n"
                + "\n"
                + "const " + name + "xController = require('../controllers')." + name + "Controller;\n"
                + "\n"
                + "router.get('/sql', " + name + "xController.getSQL);\n"
                + "router.get('/:id', " + name + "xController.getById);\n"
                + "router.post('/', " + name + "xController.add);\n"
                + "router.put('/:id', " + name + "xController.update);\n"
                + "router.delete('/:id', " + name + "xController.delete);\n"
                + "\n"
                + "\n"
                + "module.exports = router;";

        return content;
    }

    public String contentController(String name) {
        String content = "const " + name + " = require('../models')." + name + "_model;\n"
                + "const db = require('../models');\n"
                + "\n"
                + "module.exports = {\n"
                + "    getById(req, res) {\n"
                + "        console.log(req.params.id);\n"
                + "        return " + name + "\n"
                + "            .findByPk(req.params.id)\n"
                + "            .then((project) => {\n"
                + "                console.log(project);\n"
                + "                if (!project) {\n"
                + "                    return res.status(400).send({\n"
                + "                        message: '" + name + " Not Found',\n"
                + "                    });\n"
                + "                }\n"
                + "                return res.status(200).send(project);\n"
                + "            }).catch((error) =>\n"
                + "                res.status(400).send(error));\n"
                + "    },\n"
                + "\n"
                + "    add(req, res) {\n"
                + "        console.log(req);\n"
                + "        return " + name + ".create({\n"
                + "            user_id: req.body.user_id,\n"
                + "            department_id: req.body.department_id\n"
                + "        })\n"
                + "            .then((project) => res.status(201).send(project))\n"
                + "            .catch((error) => res.status(500).send(error));\n"
                + "    },\n"
                + "\n"
                + "    update(req, res) {\n"
                + "    \n"
                + "        return " + name + "\n"
                + "            .findByPk(req.params.id).then(project => {\n"
                + "                if (!project) {\n"
                + "                    return res.status(404).send({\n"
                + "                        message: '" + name + " Not Found',\n"
                + "                    });\n"
                + "                }\n"
                + "                return project\n"
                + "                    .update({\n"
                + "                        user_id: req.body.user_id || project.user_id,\n"
                + "                        department_id: req.body.department_id || project.department_id\n"
                + "                    })\n"
                + "                    .then(() => res.status(200).send(project))\n"
                + "                    .catch((error) => res.status(400).send(error));\n"
                + "            })\n"
                + "            .catch((error) => res.status(400).send(error));\n"
                + "    },\n"
                + "\n"
                + "    delete(req, res) {\n"
                + "        return " + name + "\n"
                + "            .findByPk(req.params.id)\n"
                + "            .then(project => {\n"
                + "                if (!project) {\n"
                + "                    return res.status(400).send({\n"
                + "                        message: '" + name + " Not Found',\n"
                + "                    });\n"
                + "                }\n"
                + "                return project\n"
                + "                    .destroy()\n"
                + "                    .then(() => res.status(204).send())\n"
                + "                    .catch((error) => res.status(400).send(error));\n"
                + "            }).catch((error) => res.status(400).send(error));\n"
                + "    },\n"
                + "\n"
                + "    getSQL(req, res) {\n"
                + "        return db.sequelize.query(\"SELECT * FROM " + name + "\")\n"
                + "            .then((result) => {\n"
                + "                console.log(result); if (!result) {\n"
                + "                    return res.status(404).send({\n"
                + "                        message: 'result Not Found',\n"
                + "                    });\n"
                + "                } return res.status(200).send(result[0]);\n"
                + "            })\n"
                + "            .catch((error) => res.status(400).send(error));\n"
                + "    },\n"
                + "};";

        return content;
    }

    public static void main(String[] args) {
        ArrayToFile list = new ArrayToFile();
        //list.createArchivo(2);
        //list.createIndexRouter();
        //list.createApp();
        
        String[] array = {"material","teacher_id","link_material","subject_id","end_time"};
 
        list.parametro(array);
    }
    

}
