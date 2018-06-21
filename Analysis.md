# SalesTaxes

## Sales Taxes Analysis

Considering the Product properties (description, price, type ) I decided to represent it using an abstract class with a field for each property plus the fields *grossAmount* and *taxRate*. 

For the type I decide to use a java enum keeping the corresponding tax rate, based on its category. The choice was made so that if new types will be added with different rating it will be enough to add the into the enum (ProductType). 

To distinguish imported products from local I added 2 concrete classes, extending Product which will implement the abstract methods *computeFinalTax* and *computeGrossAmount*. 
As the purpose of the program is to compute the applied tax, in case some new classes will extend Product they will be delegated to implement those 2 methods keeping the data consistent. 

Using the factory pattern is possible to obtain the Product without relying on concrete classes extending it. 

Products can be added to a ShoppingCart that uses a **LinkedHashMap** which is mapping each product to its quantity, keeping the insertion order and two fields to keep taxes and price total amount. 
In order to understand if 2 products are the same *equals() and hashcode()* of Product class have been overridden, and I chose to base the comparison on description, netAmount and grossAmount that are enough to understand whether a product is imported or not and if the applied tax is the same. 

Finally the Bill class can be built from the ShoppingCart, and will manage to show the receipt in Console as well as in a TXT file. 

Used to operate on amounts in the financial industry I chose the BigDecimal representation for them, to have a better precision. 

## Complexity Analysis

Time complexity of the Shopping Cart Insertion is **O(1)** in the medium case, can reach **O(N)** if there are a lot of collisions in the HashMap, while checking if the element is already existing. 

The time complexity of the bill generation is **O(N)** as it has to iterate on the whole LinkedHashMap. 

The space complexity is **O(2N) ≃ O(N)** as the LinkedHashMap uses also a LinkedList to keep the insertion order.
