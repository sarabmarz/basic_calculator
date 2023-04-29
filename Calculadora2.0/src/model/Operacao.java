package model;

public enum Operacao {
    SOMA("+"), SUBTRACAO("-"), MULTIPLICACAO("x"), DIVISAO("/"), IGUAL("=");

    private String simbolo;

    Operacao(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getValue() {
        return simbolo;
    }
}

