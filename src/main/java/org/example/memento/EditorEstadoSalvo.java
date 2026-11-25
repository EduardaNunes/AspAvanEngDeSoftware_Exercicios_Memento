package org.example.memento;

public class EditorEstadoSalvo implements EditorEstado {

    private EditorEstadoSalvo() {};
    private static EditorEstadoSalvo instance = new EditorEstadoSalvo();
    public static EditorEstadoSalvo getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Salvo";
    }

}
