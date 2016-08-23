
package com.epam.composite;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    private static String START_MESSAGE = "You can use next command:\n" +
            "add,'full_name new Epamer','title new Epamer',Name_supervisor - for add new Epamer\n" +
            "remove,Full_name_Epamer for delete this user with all sub hiearchy\n" +
            "show,Ful_name - for show data about this Epamer\n" +
            "showhierarchy,Ful_name - for show data about this Epamer and all sub hiearchy";
    private static final String USER_NOT_FOUND = "Epamer not found";
    private static final String SUPERVISOR_NOT_FOUND = "Supervisor not found, You can't add new Epamer";
    private static final String ADDED = "Epamer added";
    private static final String REMOVED = "Epamer removed";
    private static final String CANT_REMOVED = "You cant remove ";
    private static final String INCORRECT_COUNT = "Incorrect count of params";
    private static final String INCORRECT_PARAM = "You entered incorrect param";
    private static final String CURRENT_STRUCTURE = "Current structure:";
    private static final String DELIMETR = ",";
    private static final String UNKNOWN_COMMAND = "Unknown command";
    private static final String START_HIERARCHY = "";
    public static final String REGEX_FORMAT = "[A-Z,a-z,-,_,/.,0-9]{1,}";
    public static final String ADD = "add";
    public static final String REMOVE = "remove";
    public static final String SHOW = "show";
    public static final String SHOWHIERARCHY = "showhierarchy";

    public static void main(String[] args) {
        Epamer epamer = EpamKazakhstanStruture.getEpamKazakhstanStructure();
        Pattern pattern = Pattern.compile(REGEX_FORMAT);


        Scanner sc = new Scanner(System.in);
        System.out.println(CURRENT_STRUCTURE);
        epamer.showHierachy(START_HIERARCHY);
        System.out.println(START_MESSAGE);
        boolean isCorrectParam = true;
        try {
            while (sc.hasNext()) {
                String[] values = sc.nextLine().trim().split(DELIMETR);
                for (String val : values) {
                    Matcher nameMatcher = pattern.matcher(val.trim());
                    if (!nameMatcher.matches()) {
                        isCorrectParam = false;
                        break;
                    }
                }
                if (isCorrectParam) {
                    switch (values[0].toLowerCase()) {
                        case ADD:
                            addNewEpamer(values[1].trim(), values[2].trim(), values[3].trim(), epamer);
                            break;
                        case REMOVE:
                            removeEpamer(values[1].trim(), epamer);
                            break;
                        case SHOW:
                            showEpamer(values[1].trim(), epamer);
                            break;
                        case SHOWHIERARCHY:
                            showHierarchyEpamer(values[1].trim(), epamer);
                            break;
                        default:
                            System.out.println(UNKNOWN_COMMAND);
                    }
                    System.out.println(START_MESSAGE);

                } else {
                    System.out.println(INCORRECT_PARAM);
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(INCORRECT_COUNT);
        }
    }

    private static void showHierarchyEpamer(String nameOfUser, Epamer epamer) {
        Epamer currentEpamer = epamer.searchByFullName(nameOfUser);
        if (currentEpamer != null) {
            currentEpamer.showHierachy(START_HIERARCHY);
        } else {
            System.out.println(USER_NOT_FOUND);
        }
    }

    private static void showEpamer(String nameOfUser, Epamer epamer) {
        Epamer currentEpamer = epamer.searchByFullName(nameOfUser);
        if (currentEpamer != null) {
            System.out.println(currentEpamer);
        } else {
            System.out.println(USER_NOT_FOUND);
        }
    }

    private static void removeEpamer(String nameOfUser, Epamer epamer) {
        Epamer currentEpamer = epamer.searchByFullName(nameOfUser);
        boolean remove = epamer.remove(currentEpamer);
        if (remove) {
            System.out.println(REMOVED);
        } else if (epamer.equals(currentEpamer)) {
            System.out.println(CANT_REMOVED + currentEpamer.getFullName());
        } else {

            System.out.println(USER_NOT_FOUND);
        }
    }

    private static void addNewEpamer(String nameNewEpamer, String tittle, String nameForOldEpamer, Epamer epamer) {
        Epamer currentEpamer = epamer.searchByFullName(nameForOldEpamer);
        if (currentEpamer == null) {
            System.out.println(SUPERVISOR_NOT_FOUND);
        } else {

            if (epamer.searchByFullName(nameNewEpamer) == null) {
                epamer.addEpamer(currentEpamer, new Epamer(nameNewEpamer, tittle));
            } else {
                int i = 1;
                while (epamer.searchByFullName(nameNewEpamer + i) != null) {
                    i++;
                }
                epamer.addEpamer(currentEpamer, new Epamer(nameNewEpamer + i, tittle));
            }
            System.out.println(ADDED);
        }
    }
}
