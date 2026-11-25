package org.example.memento;

public class EditorEstadoDigitado implements EditorEstado {

    private EditorEstadoDigitado() {};
    private static EditorEstadoDigitado instance = new EditorEstadoDigitado();
    public static EditorEstadoDigitado getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Digitado";
    }

}
