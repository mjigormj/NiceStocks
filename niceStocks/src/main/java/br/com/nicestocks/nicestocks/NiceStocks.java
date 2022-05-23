package br.com.nicestocks.nicestocks;

import Model.Stock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NiceStocks {

    public static void main(String[] args) throws IOException {

        List<Stock> stocks = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            try {
                Stock stock = new Stock();
                System.out.println("Digite qual titulo devo adicionar a carteira: ");
                String stockName = sc.next();
                stock.criarStock(stockName);
                stocks.add(stock);
                
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida");
                i--;

            }
        }

        for (Stock stock : stocks) {
            stock.infoStock();
        }
        // System.out.println("Titulo adicionado");

        sc.close();
    }
}
