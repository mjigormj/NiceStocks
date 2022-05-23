package Model;

import org.jsoup.nodes.Document;

public class StockValidate {

    public boolean stockValidate(Document doc) {
        String priceClass = doc.getElementsByClass("YMlKec fxKbKc").text().replace("R$", "");
        if (priceClass != null && Double.parseDouble(priceClass) > 0) {
            return true;
        }
        return false;
    }
}
