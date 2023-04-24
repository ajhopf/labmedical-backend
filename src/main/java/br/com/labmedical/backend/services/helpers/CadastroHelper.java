package br.com.labmedical.backend.services.helpers;

public class CadastroHelper {
    public static boolean contemInformacao(String requestString) {
        boolean notNull = requestString != null;
        if (notNull) {
            return requestString.length() > 0;
        }
        return false;
    }

    public static String formataCpf(String cpf) {
        if (!cpf.contains(".")) {
            String primeraParte = cpf.substring(0,3);
            String segundaParte = cpf.substring(3, 6);
            String terceiraParte = cpf.substring(6,9);
            String quartaParte;
            if(cpf.contains("-")){
                quartaParte = cpf.substring(10);
            } else {
                quartaParte = cpf.substring(9);
            }
            return primeraParte + "." + segundaParte + "." + terceiraParte + "-" + quartaParte;
        }
        return cpf;
    }

    public static String formataTelefone(String telefone) {
        if (!telefone.contains("-")) {
            Integer quatroUltimosDigitosIndexInicio = telefone.length() - 4;
            String telefoneInicio = telefone.substring(0, quatroUltimosDigitosIndexInicio);
            telefone = telefoneInicio + "-" + telefone.substring(quatroUltimosDigitosIndexInicio);
        }

        return telefone;
    }
}
