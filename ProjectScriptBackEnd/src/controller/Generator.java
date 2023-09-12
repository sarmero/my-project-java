/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Models;

/**
 *
 * @author user
 */
public class Generator {

    ArrayList<Models> modelsList;
    ArrayList<String> fileList;

    public Generator() {
        modelsList = new ArrayList<>();
        fileList = new ArrayList<>();
    }

    public void addModels(Models models) {
        modelsList.add(models);
    }

    public void addFileList(String file) {
        fileList.add(file);
    }

    public ArrayList<Models> getModelsList() {
        return modelsList;
    }

    public void setModelsList(ArrayList<Models> modelsList) {
        this.modelsList = modelsList;
    }

    public ArrayList<String> getFileList() {
        return fileList;
    }

    public void setFileList(ArrayList<String> fileList) {
        this.fileList = fileList;
    }

    public void addHasMany() {
        String hasMany;
        String model;

        for (int i = 0; i < modelsList.size(); i++) {
            for (int j = 0; j < modelsList.get(i).foreignKey().size(); j++) {
                for (int k = 0; k < modelsList.size(); k++) {

                    model = modelsList.get(k).getName() + "_model";
                    if (modelsList.get(i).foreignKey().get(j)[1].equals(model)) {
                        hasMany = "\t" + modelsList.get(k).getModels()
                                + ".hasMany(models." + modelsList.get(i).getName() + "_model, {\n"
                                + "      foreignKey: '" + modelsList.get(i).foreignKey().get(j)[0] + "'\n"
                                + "    });\n\n";

                        modelsList.get(k).addHasMany(hasMany);
                    }
                }
            }
        }
    }

    public void createModels() {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;

        for (int i = 0; i < modelsList.size(); i++) {

            try {
                fileWriter = new FileWriter(modelsList.get(i).getRuta());
                bufferedWriter = new BufferedWriter(fileWriter);

                String line = modelsList.get(i).associate();

                bufferedWriter.write(line);
                bufferedWriter.close();

            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        }
    }

    public void creteController(String ruta) {
        for (int i = 0; i < modelsList.size(); i++) {
            String fileName;
            String content;

            fileName = ruta + "controllers\\" + modelsList.get(i).getName() + "Controller.js"; // Nombre del archivo con índice
            content = contentController(modelsList.get(i));
            createFile(fileName, content);
        }
    }

    public void addLine(String ruta) {
        String name;
        String controller = "";
        String controller2 = "";
        String appx = "";
        String app2 = "";
        String c = ",";

        for (int i = 0; i < modelsList.size(); i++) {
            if (i + 1 == modelsList.size()) {
                c = "";
            }
            name = modelsList.get(i).getName();
            controller += "\t" + name + "Controller" + c + "\n";
            controller2 += "const " + name + "Controller = require('./" + name + "Controller.js');\n";
            appx += "var " + name + "Router = require('./routes/" + name + "');\n";
            app2 += "app.use('/" + name + "', " + name + "Router);\n";

        }

        String mod = "module.exports = {\n";
        String index = controller2 + "\n" + mod + controller + "\n};";

        createFile(ruta + "controllers\\index.js", index);

        String app = "var createError = require('http-errors');\n"
                + "var express = require('express');\n"
                + "var path = require('path');\n"
                + "var cookieParser = require('cookie-parser');\n"
                + "var logger = require('morgan');\n"
                + "var cors = require('cors');\n\n"
                + appx + "\n"
                + "var app = express();\n"
                + "app.use(cors());\n\n"
                + "\n"
                + "// view engine setup\n"
                + "app.set('views', path.join(__dirname, 'views'));\n"
                + "app.set('view engine', 'ejs');\n"
                + "\n"
                + "app.use(logger('dev'));\n"
                + "app.use(express.json());\n"
                + "app.use(express.urlencoded({ extended: false }));\n"
                + "app.use(cookieParser());\n"
                + "app.use(express.static(path.join(__dirname, 'public')));\n\n"
                + app2 + "\n"
                + "// catch 404 and forward to error handler\n"
                + "app.use(function (req, res, next) {\n"
                + "  next(createError(404));\n"
                + "});\n"
                + "\n"
                + "// error handler\n"
                + "app.use(function (err, req, res, next) {\n"
                + "  // set locals, only providing error in development\n"
                + "  res.locals.message = err.message;\n"
                + "  res.locals.error = req.app.get('env') === 'development' ? err : {};\n"
                + "\n"
                + "  // render the error page\n"
                + "  res.status(err.status || 500);\n"
                + "  res.render('error');\n"
                + "});\n"
                + "\n"
                + "module.exports = app;";

        createFile(ruta + "app.js", app);
    }

    public void addOpciones(String opcion) {
        for (int i = 0; i < modelsList.size(); i++) {
            modelsList.get(i).addLineaOpcion(opcion);
        }
    }

    private void createFile(String fileName, String content) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(content);

            bufferedWriter.close();
            //System.out.println("Archivo creado exitosamente: " + fileName);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo " + fileName + ": " + e.getMessage());
        }
    }

    public void createRoutes(String ruta) {
        for (int i = 0; i < modelsList.size(); i++) {
            String fileName;
            String content;

            fileName = ruta + "routes\\" + modelsList.get(i).getName() + ".js"; // Nombre del archivo con índice
            content = contentRouter(modelsList.get(i).getName());
            createFile(fileName, content);
        }
    }

    private String contentRouter(String name) {
        String content = "var express = require('express');\n"
                + "var router = express.Router();\n"
                + "\n"
                + "const " + name + "xController = require('../controllers')." + name + "Controller;\n"
                + "\n"
                + "router.get('/list', " + name + "xController.listFull);\n"
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

    private String contentController(Models model) {

        String name = model.getName();
        String textAdd = "";
        String textUpdate = "";
        String att;
        String c = ",";

        for (int i = 0; i < model.getAttributes().size(); i++) {
            if (i + 1 == model.getAttributes().size()) {
                c = "";
            }
            att = model.getAttributes().get(i)[0];
            textAdd += "            " + att + ": req.body." + att + c + "\n";
            textUpdate += "                        " + att + ": req.body." + att + " || project." + att + c + "\n";

        }

        String content = "const " + name + " = require('../models')." + name + "_model;\n"
                + "const db = require('../models');\n\n"
                + "module.exports = {\n\n"
                + "  listFull(req, res) {"
                + "     return " + name + " "
                + "     .findAll({ })"
                + "\n"
                + "     .then((project) => res.status(200).send(project))\n "
                + "     .catch((error) => { res.status(400).send(error); "
                + "     }); "
                + "},\n"
                + "\n"
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
                + textAdd
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
                + textUpdate
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

}
