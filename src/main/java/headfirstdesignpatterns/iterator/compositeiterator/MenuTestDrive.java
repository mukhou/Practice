package headfirstdesignpatterns.iterator.compositeiterator;

public class MenuTestDrive {

    public static void main(String[] args){
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "Dinner");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Lunch");


        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        //addCharacter menu items here
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert!");
        //dessert menu item
        dessertMenu.add(new MenuItem(
                "Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla icecream",
                true,
                1.59));
        dinerMenu.add(dessertMenu);
        



        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();

    }
}
