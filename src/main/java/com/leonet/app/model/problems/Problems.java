package com.leonet.app.model.problems;

import com.leonet.app.model.databaseConection.QueriesSQL;
import com.leonet.app.model.problems.itemsListProblem.ItemList;
import com.leonet.app.model.problems.itemsListProblem.ProblemList;
import com.leonet.app.view.shared.Patron;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.swing.*;
import java.util.ArrayList;

public class Problems extends QueriesSQL {

    private ProblemList problemList;

    public Problems(BasicDataSource basicDataSource) {
        super(basicDataSource);
    }

    public ProblemList initProblemList() {
        String context = "<h4 style=\"text-align: center;\"><span style=\"color: #4C5604FF;\">&ldquo;Algoritmos 1&rdquo; (Algoritmos - Que son).</span></h4>\n" +
                "<p><span style=\"color: #4C5604FF;\">Un algoritmo es una secuencia l&oacute;gica y finita de pasos que permite solucionar un problema o cumplir con un objetivo.<em> <a style=\"color: #4C5604FF;\" href=\"http://aprende.colombiaaprende.edu.co/sites/default/files/naspublic/curriculos_ex/n1g10_fproy/nivel1/programacion/unidad1/leccion1.html\">Aprende TIC</a>.</em></span></p>";

        ImageIcon icono = new ImageIcon(Patron.resUrlBase+"problemsImages/p1.png");

        String example = "<p><span style=\"color: #4c5604ff;\"><span style=\"font-weight: 400;\">Leonet viaj&oacute; de vacaciones a su pueblito de procedencia, y su mejor amigo lo espera en la capital. &Eacute;l </span><em><span style=\"font-weight: 400;\">quiere escribir una carta</span></em><span style=\"font-weight: 400;\"> a su amigo, para contarle todo lo que ha aprendido y jugado en sus vacaciones. Para esto, </span><em><span style=\"font-weight: 400;\">utiliza Word</span></em><span style=\"font-weight: 400;\">, una herramienta ofim&aacute;tica muy popular.</span></span></p>\n" +
                "<h4 style=\"text-align: left;\">" +
                "<span style=\"color: #4c5604ff;\">" +
                "<span style=\"font-weight: 400;\">Ayuda a Leonet a </span><em><span style=\"font-weight: 400;\">escribir la carta</span></em><span style=\"font-weight: 400;\">:</span></span></h4>\n" +
                "<p><span style=\"color: #4c5604ff;\">" +
                "<span style=\"font-weight: 400;\">" +
                "<img src=\"" + Patron.resUrlBase+"problemsImages/p1.png" +"\"/>" +
                "</span></span></p>";
        String defProblem = "<p><span style=\"font-weight: 400; color: #4c5604ff;\">En sus vacaciones, un d&iacute;a normal de Leonet se puede resumir como sigue: tiene permitido levantarse a las 9:00 a.m., ya que no tiene clases en la universidad. Al levantarse, tiende su cama, se dirige al ba&ntilde;o y se cepilla la boca y lava las manos. Sale de su habitaci&oacute;n y saluda a su familia.&nbsp;</span></p>\n" +
                "<p><span style=\"font-weight: 400; color: #4c5604ff;\">A las 10:00 a.m. desayuna. al terminar, normalmente decide tomar un ba&ntilde;o, y arreglarse para salir donde sus amigos. A la 1:30 p.m., va a almorzar donde su abuela.&nbsp;</span></p>\n" +
                "<p><span style=\"font-weight: 400; color: #4c5604ff;\">Leonet se inscribi&oacute; en un curso vacacional, lo que le toma toda la tarde de su d&iacute;a. En la noche, antes de acostarse, hace videollamada con su amigo de la capital. Al terminar, le desea las buenas noches a su familia, y se acuesta. Y as&iacute;, da paso a un nuevo d&iacute;a.</span></p>\n" +
                "<p><span style=\"font-weight: 400; color: #4c5604ff;\">&iquest;C&oacute;mo crees que luce el d&iacute;a de Leonet, en forma de algoritmo?</span></p>";
        int pointEarned = 10;
        int lineContext = 140;
        int lineExample = 200;
        int lineDefProblem = 330;

        ArrayList<ItemList> itemListsArray = new ArrayList<>();
        ItemList a = new ItemList(0,  "Inicio");
        ItemList b = new ItemList(1,  "Leonet se levanta a la 9:00 pm");
        ItemList c = new ItemList(2,  "Tienda la cama");
        ItemList d = new ItemList(3,  "Se dirige al baño y se cepilla la boca y lava las manos   ");
        ItemList e = new ItemList(4,  "Se baña y se arregla");
        ItemList f = new ItemList(5,  "Sale y juega con sus amigos");
        ItemList g = new ItemList(6,  "A la 1:30pm almuerza donde su abuela");
        ItemList h = new ItemList(7,  "En la tarde estudia");
        ItemList i = new ItemList(8,  "Hace videollamada con su amigo de la capital");
        ItemList j = new ItemList(9, "Se acuesta");
        ItemList k = new ItemList(10, "Fin");

        itemListsArray.add(b);
        itemListsArray.add(a);
        itemListsArray.add(c);
        itemListsArray.add(d);
        itemListsArray.add(e);
        itemListsArray.add(f);
        itemListsArray.add(g);
        itemListsArray.add(h);
        itemListsArray.add(i);
        itemListsArray.add(j);
        itemListsArray.add(k);

        problemList = new ProblemList(context, example, defProblem,
                pointEarned, lineContext, lineExample, lineDefProblem, itemListsArray);
        return problemList;
    }

    public ProblemList getProblemList() {
        return problemList;
    }
}
