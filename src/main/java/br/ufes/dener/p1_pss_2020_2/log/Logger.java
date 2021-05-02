package br.ufes.dener.p1_pss_2020_2.log;

import br.ufes.dener.p1_pss_2020_2.model.Funcionario;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.json.JSONObject;
import org.json.XML;

public class Logger {

    public static void salvarLog(Funcionario funcionario, String tipo) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("TIPO_LOG:", tipo);
        jsonObject.put("id", funcionario.getId());
        jsonObject.put("cargo", funcionario.getCargo());
        jsonObject.put("nome", funcionario.getNome());
        jsonObject.put("idade", funcionario.getIdade());
        jsonObject.put("bonus", funcionario.getBonus());
        jsonObject.put("salario", funcionario.getSalario());
        jsonObject.put("faltas", funcionario.getFaltas());
        jsonObject.put("funcionarioDoMes", funcionario.getFuncionarioDoMes());
        jsonObject.put("admissao", funcionario.getAdmissao());
        String xml = XML.toString(jsonObject);

        LogConfig.getJsonArray().put(jsonObject);
        LogConfig.getXmlArray().append("<log>").append(xml).append("</log>");
        LogConfig.getTxtArray().add(xml);

        try {
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();

            FileWriter fileJson = new FileWriter(s + "/src/main/java/br/ufes/dener/p1_pss_2020_2/log/storage/log.json");
            fileJson.write(LogConfig.getJsonArray().toString());
            fileJson.close();

            FileWriter fileXml = new FileWriter(s + "/src/main/java/br/ufes/dener/p1_pss_2020_2/log/storage/log.xml");
            fileXml.write(LogConfig.getXmlArray().toString());
            fileXml.close();

            FileWriter fileTxt = new FileWriter(s + "/src/main/java/br/ufes/dener/p1_pss_2020_2/log/storage/log.txt");
            fileTxt.write(LogConfig.getTxtArray().toString());
            fileTxt.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
