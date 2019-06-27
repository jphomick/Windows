package com.company;

public class FormatHelper {
    public static String getTabs(String word, int startingTabs) {
        int tabsToRemove = word.length() / 4;
        int tabs = startingTabs - tabsToRemove;
        String tabReturn = "";
        for (int i = 0; i < tabs; i++) {
            tabReturn += "\t";
        }
        return tabReturn;
    }
}
