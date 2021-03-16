public class Test {
    public static void main(String[] args) {
        URIcheck urIcheck1 = new URIcheck("shema://user:pass@www.host:8888/path/jdfhj/fdf?query=rer=val#fragment");
        urIcheck1.check();
        System.out.print(urIcheck1.getSchema() + " " + urIcheck1.getUser() + " " + urIcheck1.port + "\n");
        urIcheck1.typeURI();

        URIcheck urIcheck2 = new URIcheck("//user:pass@www.host:8888/path/jdfhj/fdf?query=rer=val#fragment");
        urIcheck2.check();
        System.out.print(urIcheck2.getSchema() + " " + urIcheck2.getUser() + " " + urIcheck2.port + "\n");
        urIcheck2.typeURI();

        URIcheck urIcheck3 = new URIcheck("/resource.txt#frag01");
        urIcheck3.check();
        System.out.print(urIcheck3.getPath() + " " + urIcheck3.getFragment() + "\n");
        urIcheck3.typeURI();

        URIcheck urIcheck4 = new URIcheck("resrce.txt#frag01");
        urIcheck4.check();
        System.out.print( urIcheck4.getPath() + " " + urIcheck4.getFragment() + "\n");
        urIcheck4.typeURI();

    }
}
