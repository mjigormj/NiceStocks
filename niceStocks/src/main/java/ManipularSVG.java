
import Model.Stock;
import java.io.IOException;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ManipularSVG {
    public static void main(String[] args) throws IOException {
        Stock stk = new Stock();
        stk.criarStock("CPTS11");
        Document doc = stk.getDoc();
        Element divPrincipalSvg = doc.getElementsByClass("ushogf").first();
               
        List<Element> listaPath = divPrincipalSvg.getElementsByClass("gJBfM");
        System.out.println(listaPath);
        //System.out.println(doc);
}
}
