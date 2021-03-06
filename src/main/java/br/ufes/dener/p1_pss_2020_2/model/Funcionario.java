package br.ufes.dener.p1_pss_2020_2.model;

import java.time.LocalDate;

public class Funcionario {

    private int id;
    private String nome;
    private int idade;
    private double salario;
    private String cargo;
    private String bonus;
    private int faltas;
    private Boolean funcionarioDoMes;
    private LocalDate admissao;
    private double salarioFinal;
    private double valorBonus;
    private LocalDate dataBonus;

    public Funcionario() {

    }

    public Funcionario(int id, String nome, int idade, double salario, String cargo, String bonus, int faltas, Boolean funcionarioDoMes, LocalDate admissao, double salarioFinal, double valorBonus, LocalDate dataBonus) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.cargo = cargo;
        this.bonus = bonus;
        this.faltas = faltas;
        this.funcionarioDoMes = funcionarioDoMes;
        this.admissao = admissao;
        this.salarioFinal = salarioFinal;
        this.valorBonus = valorBonus;
        this.dataBonus = dataBonus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public Boolean getFuncionarioDoMes() {
        return funcionarioDoMes;
    }

    public void setFuncionarioDoMes(Boolean funcionarioDoMes) {
        this.funcionarioDoMes = funcionarioDoMes;
    }

    public LocalDate getAdmissao() {
        return admissao;
    }

    public void setAdmissao(LocalDate admissao) {
        this.admissao = admissao;
    }

    public double getSalarioFinal() {
        return salarioFinal;
    }

    public void setSalarioFinal(double salarioFinal) {
        this.salarioFinal = salarioFinal;
    }

    public double getValorBonus() {
        return valorBonus;
    }

    public void setValorBonus(double valorBonus) {
        this.valorBonus = valorBonus;
    }

    public LocalDate getDataBonus() {
        return this.getAdmissao();
    }

    public void setDataBonus(LocalDate dataBonus) {
        this.dataBonus = dataBonus;
    }
}
