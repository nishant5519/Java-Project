package com.companies.onlinetest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PartsAvatarWareHouse {

	public static void main(String[] args) {

	}

	public Map<Warehouse, Map<String, Integer>> getInventoryAllocation(
			Map<String, Integer> shoppingCart, Address addressOfCustomer) {

		List<Warehouse> sortedListOfNearestWarehouses = getNearestWarehouses(addressOfCustomer);

		Map<Warehouse, Map<String, Integer>> finalInventoryAllocation = new HashMap<Warehouse, Map<String, Integer>>();

		for (Map.Entry<String, Integer> product : shoppingCart.entrySet()) {
			System.out.println("Product ID = " + product.getKey()
					+ ", Product Quantity = " + product.getValue());

			Map<Warehouse, Integer> warehouseAndProductmapping = getInventory(product
					.getKey());
			int minIndex = 0;
			for (Map.Entry<Warehouse, Integer> warehouseAndProduct : warehouseAndProductmapping
					.entrySet()) {
				System.out.println("Warehouse ID= "
						+ warehouseAndProduct.getKey()
						+ ", Product Quantity = "
						+ warehouseAndProduct.getValue());

				if (product.getValue() <= warehouseAndProduct.getValue()) {
					for (int i = 0; i < sortedListOfNearestWarehouses.size(); i++) {
						if (warehouseAndProduct.getKey() == sortedListOfNearestWarehouses
								.get(i)) {
							if (minIndex >= i)
								minIndex = i;
						}

					}

				} else {
					for (int i = 0; i < sortedListOfNearestWarehouses.size(); i++) {
						if (warehouseAndProduct.getKey() == sortedListOfNearestWarehouses
								.get(i)) {
							if (minIndex >= i)
								minIndex = i;
						}

					}

				}
				
				finalInventoryAllocation.put(sortedListOfNearestWarehouses
								.get(minIndex), (Map<String, Integer>) product);

			}
		}
		return null;

	}

	// A List of Warehouse sorted by distance from the inputted Address
	public List<Warehouse> getNearestWarehouses(Address addressOfCustomer) {
		return null;

	}

	public Map<Warehouse, Integer> getInventory(String product) {
		return null;

	}

}

enum Warehouse {
	EDMONTON, MONTREAL, TORONTO, VANCOUVER
}

class Address {

}
