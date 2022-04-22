package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

public class program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Insira a quantidade de produtos: ");
		int n = sc.nextInt();

		while (n <= 0) {
			System.out.print("Qunaitdade incorreta. Digite algo maior que 0: ");
			n = sc.nextInt();
		}

		List<Product> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.println("Dados do produto #" + (i + 1) + ":");
			System.out.println();

			System.out.print("Comum, usado ou importado? (c/u/i) ");
			char tipo = sc.next().charAt(0);

			while (tipo != 'c' && tipo != 'u' && tipo != 'i') {
				System.out.print("Opção indisponível. Digite novamente: ");
				tipo = sc.next().charAt(0);
			}

			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Preço: ");
			float price = sc.nextFloat();

			if (tipo == 'i') {
				System.out.print("Valor alfandegário: ");
				float customsFee = sc.nextFloat();

				// Product tipoI = new ImportedProduct(name, price, customsFee);
				list.add(new ImportedProduct(name, price, customsFee));
			}

			if (tipo == 'u') {
				System.out.println("Data de fabricação (DD/MM/YYYY): ");
				Date date = dmy.parse(sc.next());
				
				Product tipoU = new UsedProduct(name, price, date);
				list.add(tipoU);
			}
			
			if (tipo == 'c'){
				Product tipoC = new Product(name, price);
				list.add(tipoC);
			}

		}
		System.out.println();
		System.out.println("Lista de preços: ");
		System.out.println();
		
		for (Product x : list) {
			System.out.println(x.priceTag());
		}
		

		sc.close();

	}

}
