import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URIcheck {
    protected String uri;
    protected  String schema,user,pass,host,port,path,query,fragment;
    private String absolute_networkLink = "[\\s]*(([a-zA-Z\\d\\.]+):)?\\/\\/(([^\\.\\[\\]\\@:\\s\\/?#!\\$\\'\\(\\)\\*\\+]*)(((\\.)|(\\:))([^\\[\\]\\@\\:\\s\\/\\?\\#\\!\\$\\'\\(\\)\\*\\+]*))*@|([^\\[\\]\\@\\:\\s\\/\\?\\#\\!\\$\\'\\(\\)\\*\\+]*))([^\\:\\s\\/?#]*)?(:([\\d]{0,5}))*(\\/([^\\s?#]*))*(\\?([^\\s\\#]*))?(#(.*))?";
    private String absolute_relativePathLink = "(\\/)?([^\\s?#]+)(\\?([^\\s\\#]*))?(#(.*))?";
    private boolean flag =false;
    private String slashFlag;


    public URIcheck(String str){ uri = str; }

    public void check() throws IllegalArgumentException{
        Pattern pattern = Pattern.compile(absolute_networkLink);
        Matcher matcher = pattern.matcher(this.uri);

        while(matcher.find()){
            schema = matcher.group(2);
            user = matcher.group(4);
            pass = matcher.group(9);
            host= matcher.group(11);
            port = matcher.group(13);
            path = matcher.group(14);
            query = matcher.group(17);
            fragment = matcher.group(19);
        }

        if (schema == null && user == null){
            Pattern pattern1 = Pattern.compile(absolute_relativePathLink);
            Matcher matcher1 = pattern1.matcher(this.uri);

            while(matcher1.find()){
                slashFlag = matcher1.group(1);
                path = matcher1.group(2);
                query = matcher1.group(4);
                fragment = matcher1.group(6);
            }
        }
        flag = true;
    }


    public void typeURI(){
        if (flag == false){
            System.out.println("Use the method 'check()' first\n");
        }
        else {
            if (schema != null){
                System.out.println("This is absolute link\n");
            }
            else if (pass != null || host != null || port != null ){
                System.out.println("This is link network path\n");
            }
            else if (slashFlag != null){
                System.out.println("This is link the absolute path\n");
            }
            else if (path != null || query != null || fragment != null){
                System.out.println("This is link the relative path\n");
            }
            else System.out.print("Incorrectly URI\n");
        }
    }

    public String getSchema() { return schema; }

    public String getUser() { return user; }

    public String getPass() { return pass; }

    public String getHost() { return host; }

    public String getPort() { return port; }

    public String getPath() { return path; }

    public String getQuery() { return query; }

    public String getFragment() { return fragment; }
}
