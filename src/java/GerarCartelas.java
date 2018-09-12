/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Alexandre
 */
@ManagedBean
@SessionScoped
public class GerarCartelas {
    private static int cont=0;
    private int qtn_cartelas;
    static final List<Integer> numeros = new ArrayList<>();

    private static Cartela geraCartela() {
        for (int i = 1; i < 61; i++) { //Sequencia da mega sena
            numeros.add(i);
        }
        //Embaralhamos os números:
        Collections.shuffle(numeros);

        Cartela cartela = new Cartela("Cartela " + cont, numeros.get(1), numeros.get(2), 
                numeros.get(3), numeros.get(4), numeros.get(5), numeros.get(6));
        
        return cartela;
    }

    private static final ArrayList<Cartela> employees = new ArrayList<Cartela>(Arrays.asList(
            new Cartela("retirar", 0, 0, 0, 0, 0, 0)
    ));

    public ArrayList<Cartela> getEmployees() {
        return employees;
    }

    public String addEmployee() {
        employees.clear();
        for (int i = 1; i <= qtn_cartelas; i++) {
            cont = i;
            employees.add(geraCartela());
        }
        return "cartelas";
    }

    public int getQtn_cartelas() {
        return qtn_cartelas;
    }

    public void setQtn_cartelas(int qtn_cartelas) {
        this.qtn_cartelas = qtn_cartelas;
    }   
}
