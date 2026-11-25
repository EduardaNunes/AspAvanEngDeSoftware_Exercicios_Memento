package org.example.memento;

public class EditorEstadoVazio implements EditorEstado {

    private EditorEstadoVazio() {};
    private static EditorEstadoVazio instance = new EditorEstadoVazio();
    public static EditorEstadoVazio getInstance() {
        return instance;
    }

    public String getNomeEstado() {
        return "Vazio";
    }

}
