package br.com.labmedical.backend.services.helpers;

public class CadastroHelper {

    public static boolean contemInformacao(String requestString) {
        boolean notNull = requestString != null;
        if (notNull) {
            return requestString.length() > 0;
        }
        return false;
    }

}
