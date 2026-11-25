package org.example.memento;

import java.util.ArrayList;
import java.util.List;

public class Editor {

    private EditorEstado estado;
    private List<EditorEstado> memento = new ArrayList<EditorEstado>();

    public EditorEstado getEstado() {
        return this.estado;
    }

    public void setEstado(EditorEstado estado) {
        this.estado = estado;
        this.memento.add(this.estado);
    }

    public void restauraEstado(int indice) {
        if (indice < 0 || indice > this.memento.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.estado = this.memento.get(indice);
    }

    // Ctrl + Z: volta para o estado anterior ao atual
    public void desfazer() {
        this.restauraEstado(this.memento.size() - 2);
    }

    public List<EditorEstado> getEstados() {
        return this.memento;
    }
}
