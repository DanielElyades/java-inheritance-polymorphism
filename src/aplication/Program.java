package aplication;

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
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner tc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList();
		
		System.out.println("Enter the number of product: ");
		int n = tc.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			System.out.println("Product #" + (i+1) + " data");
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = tc.next().charAt(0);
			
			System.out.print("Name: ");
			tc.nextLine();
			String name = tc.next();
			
			System.out.print("Price: ");
			Double price = tc.nextDouble();
			
			if (type == 'c') {
				list.add(new Product(name, price));
			}
			else if (type == 'u') {
				System.out.print("Manufctured date (DD/MM/YYYY): ");
				Date date = sdf.parse(tc.next());
				list.add(new UsedProduct(name, price, date));
			}
			else {
				System.out.print("Customs fee: ");
				double customsFee = tc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			
		}
		System.out.println();
		System.out.println("PRICE  TAGS");
		
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		tc.close();

	}

}
