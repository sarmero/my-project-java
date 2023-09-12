package model;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Models {

    String name;
    String models;
    String ruta;
    String content;
    ArrayList<String[]> attributes;
    ArrayList<String> hasMany;

    public Models() {
        name = "";
        models = "";
        attributes = new ArrayList<>();
        hasMany = new ArrayList<>();
        ruta = "";
        content = "";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public ArrayList<String[]> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<String[]> attributes) {
        this.attributes = attributes;
    }

    public ArrayList<String> getHasMany() {
        return hasMany;
    }

    public void setHasMany(ArrayList<String> hasMany) {
        this.hasMany = hasMany;
    }

    public ArrayList<String[]> foreignKey() {
        ArrayList<String[]> att = new ArrayList<>();

        for (int i = 0; i < attributes.size(); i++) {
            if (!"".equals(attributes.get(i)[1])) {
                att.add(attributes.get(i));
            }
        }

        return att;
    }

    public String associate() {
        String ass = models + ".associate = function (models) {\n";
        ArrayList<String[]> att = foreignKey();

        for (int i = 0; i < att.size(); i++) {
            ass += "\t" + models + ".belongsTo(models." + att.get(i)[1] + ", {\n"
                    + "      foreignKey:'" + att.get(i)[0] + "'\n"
                    + "    });\n\n";
        }

        for (int i = 0; i < hasMany.size(); i++) {
            ass += hasMany.get(i);
        }

        ass += "};\n";

        int x = content.indexOf("return");
        String subtex = content.substring(0, x) + "\n" + ass + "\n";

        subtex += content.substring(x);

        return subtex;
    }

    public void addHasMany(String has) {
        hasMany.add(has);
    }

    public void addLineaOpcion(String opcion) {
        String subText = content;
        int x, y, z;

        x = subText.indexOf("const options = {");
        subText = subText.substring(x);
        y = subText.indexOf(": []");
        subText = subText.substring(y);
        z = x + y + 4;

        content = content.substring(0, z) + ",\n" + opcion + content.substring(z);
    }

}
