package FindWord;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

class FindWord {
    public static void main(String[] args) {
        String link1 = "http://www.espn.com/";
        String link2 = "https://theathletic.com/";

        findWords(link1);
        findWords(link2);

        String[] exludedWords = {"NBA", "NFL", "MLB"};

        filterWords(exludedWords);
    }


    private static void findWords(String link) {
        Connection connect = Jsoup.connect(link);
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            try {
                FileWriter out = new FileWriter("words.txt", true);
                for (Element elem : links) {
                    StringTokenizer sToken = new StringTokenizer(elem.text().toLowerCase(), " ,.\"?!:;[]-'");
                    while (sToken.hasMoreTokens()) {
                        out.append(sToken.nextToken() + " ");
                    }
                }
                out.close();
            } catch (IOException ex) {
                System.out.println("Can't write to file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void filterWords(String[] excludedWodrs) {
        File file = new File("words.txt");
        String line = "";
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                line = scan.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Missing File.");
        }

        StringBuilder filteredWords = new StringBuilder();
        StringTokenizer strToken = new StringTokenizer(line);
        while (strToken.hasMoreTokens()) {
            String word = strToken.nextToken();
            if (word.length() < 3)
                continue;
            boolean isExcluded = false;
            for (int i = 0; i < excludedWodrs.length; i++) {
                if (excludedWodrs[i].equals(word)) {
                    isExcluded = true;
                    break;
                }
            }
            if (!isExcluded)
                filteredWords.append(word + " ");
        }
        try {
            FileWriter out = new FileWriter("filtered_words.txt", false);
            out.append(filteredWords.toString());
            out.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file.");
        }
    }
}
