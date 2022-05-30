package Model;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Stock {

    String name;
    Double marcketValue = 0.0;
    //Double avgPrice;
    Double avgCust = 0.0;
    Double totalPrice = 0.0;
    Double moneyEarned = 0.0;
    int stockQtd = 0;
    Document doc;

    public void criarStock(String name) throws IOException {

        this.setName(name);
        this.setDoc(Jsoup.connect("https://www.google.com/finance/quote/" + this.getName() + ":BVMF").get());
        //this.setStockQtd(stockQTD);
        this.setMarcketValue(getDoc());
        //this.setTotalPrice(this.getMarcketValue(), this.getStockQtd());

    }
    
    public String dayRange() {
        return getDoc().getElementsByClass("P6K39c").get(1).text();
    }
    
    public String percentVariance() {
        return getDoc().getElementsByClass("JwB6zf").get(17).text();
    }

    public void infoStock() {
        System.out.println("\t-----" + this.getName() + "-----");
        System.out.println("Quantidade \t\t" + this.getStockQtd());
        System.out.println("Custo Médio \t\tR$ " + this.getAvgCust());
        System.out.println("Preço de mercado \tR$ " + this.getMarcketValue());
        System.out.println("Valor Total \t\tR$ " + this.getTotalPrice());
        System.out.println("Ganho/Perda \t\tR$ " + this.getMoneyEarned());

    }

    // Metodos especiais
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) throws IOException {
        this.doc = doc;
    }

    /*public Double getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(Double marcketValue, int stockQtd) {
		this.avgPrice = marcketValue/stockQtd;
	}*/
    public Double getAvgCust() {
        return avgCust;
    }

    public void setAvgCust(Double avgCust) {
        this.avgCust = avgCust;
    }

    public int getStockQtd() {
        return stockQtd;
    }

    public void setStockQtd(int stockQtd) {
        this.stockQtd = stockQtd;
    }

    public Double getMarcketValue() {
        return marcketValue;
    }

    public void setMarcketValue(Document doc) {
        this.marcketValue = Double.parseDouble(doc.getElementsByClass("YMlKec fxKbKc").text().replace("R$", ""));
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double marcketValue, int stockQtd) {
        this.totalPrice = marcketValue * stockQtd;
    }

    public Double getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(Double moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

}
