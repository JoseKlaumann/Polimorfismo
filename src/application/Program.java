package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> product = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine(); //Necessario colocar este nextLine, se nao ele nao adiciona os nomes na lista
			System.out.print("Name: ");
			String name1 = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
			    Date manufactureDate = sdf.parse(sc.next());
			    
			    product.add(new UsedProduct(name1, price, manufactureDate));
			}
			else if (ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				
				product.add(new ImportedProduct(name1, price, customsFee));
			}
			else {
				product.add(new Product(name1, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product pro : product) {
			System.out.println(pro.priceTag());
		}
		
		sc.close();
	}

}
