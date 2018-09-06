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
public class UserData {

    private int qtn_cartelas;
    static final List<Integer> numeros = new ArrayList<>();

    private static int geraNumeros() {
        for (int i = 1; i < 61; i++) { //Sequencia da mega sena
            numeros.add(i);
        }
        //Embaralhamos os números:
        Collections.shuffle(numeros);

        return numeros.get((int) (Math.random() * 60));
    }

    private static final ArrayList<Cartela> employees = new ArrayList<Cartela>(Arrays.asList(
            new Cartela("retirar", geraNumeros(), geraNumeros(), geraNumeros(), geraNumeros(), geraNumeros(), geraNumeros())
    ));

    public ArrayList<Cartela> getEmployees() {
        return employees;
    }

    public String addEmployee() {
        employees.clear();
        for (int i = 1; i <= qtn_cartelas; i++) {
            Cartela cartela = new Cartela("Cartela " + i, geraNumeros(), geraNumeros(), geraNumeros(), geraNumeros(), geraNumeros(), geraNumeros());
            employees.add(cartela);
        }
        return "home";
    }

    public int getQtn_cartelas() {
        return qtn_cartelas;
    }

    public void setQtn_cartelas(int qtn_cartelas) {
        this.qtn_cartelas = qtn_cartelas;
    }   
}
