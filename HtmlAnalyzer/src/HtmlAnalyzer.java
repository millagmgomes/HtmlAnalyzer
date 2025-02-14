import java.io.*;
import java.net.*;

public class HtmlAnalyzer {


    public static String getHTMLContent(String urlString) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            return "URL connection error";
        }
        return content.toString();
    }


    public static String getDeepestText(String html) {

        StringBuilder text = new StringBuilder();
        int depth = 0;
        int maxDepth = 0;
        String deepestText = "";


        boolean inTag = false;
        boolean inText = false;
        StringBuilder currentText = new StringBuilder();


        for (int i = 0; i < html.length(); i++) {
            char c = html.charAt(i);


            if (c == '<') {
                inTag = true;
                if (inText) {

                    if (depth > maxDepth) {
                        maxDepth = depth;
                        deepestText = currentText.toString().trim();
                    }
                    currentText.setLength(0);
                    inText = false;
                }
            }

            else if (c == '>') {
                inTag = false;
                if (!inText) {
                    inText = true;
                    depth++;
                }
            }

            else if (!inTag) {
                currentText.append(c);
            }
        }


        if (depth > maxDepth) {
            deepestText = currentText.toString().trim();
        }

        return deepestText.isEmpty() ? "malformed HTML" : deepestText;
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please provide a URL.");
            return;
        }

        String urlString = args[0];
        String htmlContent = getHTMLContent(urlString);

        if (htmlContent.equals("URL connection error")) {
            System.out.println("URL connection error");
        } else {
            String deepestText = getDeepestText(htmlContent);
            System.out.println("Deepest Text: " + deepestText);
        }
    }
}
