package org.example.memento;

public class EditorEstadoFormatado implements EditorEstado {

    private EditorEstadoFormatado() {};
    private static EditorEstadoFormatado instance = new EditorEstadoFormatado();
    public static EditorEstadoFormatado getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Formatado";
    }

}
