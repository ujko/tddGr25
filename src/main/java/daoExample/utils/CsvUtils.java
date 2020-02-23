package daoExample.utils;


import daoExample.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CsvUtils {

    private static String ioFilePath = getFilePath();


    public static Map<Integer, Person> loadCsvFileToMap() throws IOException {
        List<String> listWithPerson = Files.lines(Paths.get(ioFilePath))
                .collect(Collectors.toList());
        Map<Integer, Person> result = new HashMap<>();
        String pattern = "([\\d]+),([A-Za-z\\s\\-\\']+)," +
                "([A-Za-z\\-\\'\\s]+),([A-Za-z_0-9]+@[A-Za-z_0-9\\.\\-]+),(Female|Male),([\\d\\.]+)";
        Pattern regexPattern = Pattern.compile(pattern);
        for (String line : listWithPerson) {
            Matcher matcher = regexPattern.matcher(line);
            if (matcher.matches()) {
                Person p = new Person();
                p.setId(Integer.parseInt(matcher.group(1)))
                        .setFirstName(matcher.group(2))
                        .setLastName(matcher.group(3))
                        .setEmail(matcher.group(4))
                        .setGender(matcher.group(5))
                        .setIpAddress(matcher.group(6));
                result.put(p.getId(), p);
            } else {
                System.out.println("Line was not added: " + line);
            }
        }
        return result;
    }

    public static void saveToFile(List<Person> list) {
        List<String> listTmp = list.stream().map(Person::getPersonInCsvFormat).collect(Collectors.toList());
        listTmp.add(0,"id,first_name,last_name,email,gender,ip_address");
        try {
            Files.write(Paths.get(ioFilePath),listTmp);
        } catch (IOException e) {
            System.out.println("Unable to save to file");;
        }
    }

    private static String getFilePath() {
        return FileUtils.pobierzProperty();
    }
}
