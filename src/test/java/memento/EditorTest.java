package memento;

import org.example.memento.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditorTest {

    @Test
    void deveArmazenarEstados() {
        Editor editor = new Editor();
        editor.setEstado(EditorEstadoVazio.getInstance());
        editor.setEstado(EditorEstadoDigitado.getInstance());
        assertEquals(2, editor.getEstados().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        Editor editor = new Editor();
        editor.setEstado(EditorEstadoVazio.getInstance());
        editor.setEstado(EditorEstadoDigitado.getInstance());
        editor.restauraEstado(0);
        assertEquals(EditorEstadoVazio.getInstance(), editor.getEstado());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        Editor editor = new Editor();
        editor.setEstado(EditorEstadoVazio.getInstance());
        editor.setEstado(EditorEstadoDigitado.getInstance());
        editor.setEstado(EditorEstadoVazio.getInstance());
        editor.setEstado(EditorEstadoSalvo.getInstance());
        editor.restauraEstado(2);
        assertEquals(EditorEstadoVazio.getInstance(), editor.getEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            Editor editor = new Editor();
            editor.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

    @Test
    void deveDesfazerUltimaAlteracao() {
        Editor editor = new Editor();
        editor.setEstado(EditorEstadoVazio.getInstance());
        editor.setEstado(EditorEstadoDigitado.getInstance());
        editor.setEstado(EditorEstadoFormatado.getInstance());
        editor.desfazer();
        assertEquals(EditorEstadoDigitado.getInstance(), editor.getEstado());
    }

    @Test
    void deveRetornarExcecaoDesfazerSemHistorico() {
        try {
            Editor editor = new Editor();
            editor.setEstado(EditorEstadoVazio.getInstance());
            editor.desfazer();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

}
