package  Ejercicio_12;

public class Fecha {
    private int dia;
    private int mes;
    private int ano;

    public Fecha(int dia, int mes, int ano) {
        validarFecha(dia, mes, ano);
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        validarFecha(dia, this.mes, this.ano);
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        validarFecha(this.dia, mes, this.ano);
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        validarFecha(this.dia, this.mes, ano);
        this.ano = ano;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    private void validarFecha(int dia, int mes, int ano) {
        if (ano < 0) {
            throw new IllegalArgumentException("Año no válido: " + ano);
        }
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mes no válido: " + mes);
        }
        int diasMes = mes == 2 ? (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0) ? 29 : 28) : (mes == 4 || mes == 6 || mes == 9 || mes == 11 ? 30 : 31);
        if (dia < 1 || dia > diasMes) {
            throw new IllegalArgumentException("Día no válido: " + dia);
        }
    }
}