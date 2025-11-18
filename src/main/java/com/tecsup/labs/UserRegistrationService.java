package com.tecsup.labs;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de registro de usuarios con varios problemas de calidad
 * corregidos para el laboratorio.
 */
public class UserRegistrationService {

    // El campo de error es privado.
    private String lastErrorMessage = "";

    // Uso de Genéricos (<String>) para la lista, eliminando el warning de "raw types".
    private final List<String> users = new ArrayList<>();

    // Uso correcto del número mágico como constante.
    private static final int MIN_PASSWORD_LENGTH = 8;

    // Constructor limpio
    public UserRegistrationService() {
        // Eliminada lógica de inicialización redundante.
        System.out.println("UserRegistrationService inicializado");
    }

    /**
     * Registra un nuevo usuario.
     * Retorna true si se registra, false en caso contrario.
     */
    public boolean registerUser(String username, String password, String email) {
        // Validación de nulidad y vacío al inicio (evita NullPointerException).
        if (username == null || username.trim().isEmpty()) {
            lastErrorMessage = "El nombre de usuario está vacío o es nulo.";
            return false;
        }

        if (password == null) {
            lastErrorMessage = "La contraseña es nula.";
            return false;
        }

        // Simplificación de la validación de longitud de contraseña y eliminación del código duplicado.
        if (password.length() < MIN_PASSWORD_LENGTH) {
            lastErrorMessage = String.format("La contraseña es muy corta (Mínimo %d caracteres).", MIN_PASSWORD_LENGTH);
            System.out.println("Advertencia: contraseña corta."); // Se mantiene el mensaje de advertencia
            return false;
        }

        // Mejora mínima: mejor validación de correo.
        if (!email.contains("@") || !email.contains(".")) {
            lastErrorMessage = "El correo electrónico no parece válido. Debe contener '@' y '.'";
            return false;
        }

        // Manejo de excepciones mejorado
        try {
            // Simulación de acceso a base de datos
            saveUser(username, password, email);
        } catch (DatabaseAccessException e) { // Captura una excepción específica
            // Se registra la excepción (mejor que ignorarla)
            System.err.println("Error al guardar el usuario: " + e.getMessage());
            lastErrorMessage = "Error de acceso a datos al guardar el usuario.";
            return false;
        }

        System.out.println("Usuario registrado: " + username);
        return true;
    }

    // Clase de excepción específica para errores de datos.
    private static class DatabaseAccessException extends Exception {
        public DatabaseAccessException(String message) {
            super(message);
        }
    }

    // El método ahora lanza la excepción específica
    private void saveUser(String username, String password, String email) throws DatabaseAccessException {
        users.add(username);
        if (username.equals("error")) {
            // Lanza la excepción específica
            throw new DatabaseAccessException("Nombre de usuario no permitido.");
        }
    }

    /**
     * Método de prueba que retorna la longitud del String de entrada.
     * @param s El String a procesar.
     * @return La longitud del String, o -1 si el String es nulo.
     */
    public int getStringLength(String s) { // Renombre del método de 'x' a 'getStringLength'
        if (s == null) {
            return -1;
        }

        // Eliminación del uso ineficiente de String (que causaba un warning)
        return s.length();
    }
}