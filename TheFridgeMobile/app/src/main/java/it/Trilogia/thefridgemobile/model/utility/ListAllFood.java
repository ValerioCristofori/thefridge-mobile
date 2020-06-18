package it.Trilogia.thefridgemobile.model.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAllFood {

    private static final String[] CATEGORY_FRUIT = {"Achacha","Apples-Braeburn","Apples-Granny-Smith","Apples-Red-Delicious", "Apples-Royal-Gala","Avocado","Banana",
            "Berries","Beurre-Bosc-Pears","Blood-oranges", "Cantaloupe", "Cashews","Cherries","Chestnut", "Coconut","Cucumber","Currants","Custard-Apples",
            "Dragonfruit","Grapefruit","Kiwi-Fruit","Jackfruit","Passionfruit","Star-Fruit","Goji-Berry","Cranberry","Raspberry","Elderberry","Wolfberry","Watermelon",
            "Pineapple","Plums","Corella-Pear","Honeydew-melon","Apples-Bonza","Apples-Golden-Delicious","Apples-Jonathan","Papaya","Lychees","Kiwiberries", "Pistachio-Nut",
            "Feijoa","Guava","Hazelnut","Kaffir-Lime-Leaves","Longan","Strawberries","Raisin","Oranges","Nuts","Nectarines-white","Macadamia-Nut","Mulberries","Mandarins","Mace",
            "Loquats","Incaberries","Grapes", "Fingerlime","Dried-Apricots","Dates","Cherry-Plum","Carob","Carambola","Blueberries","Brazil-Nut","Beurre-Bosc-Pear","Packham-Pear",
            "Apples-Jazz","Apples-Red-Fuji","Apricots","Apples","Apples-Sundowner","William-Pear","Pears",
            "Peaches","Paradise-Pears","Nashi-Pear","Nectarines","Olives","Avocado-Reed","Almonds","Walnut","Umeboshi","Tangelo","Sultanas",
            "Quince","Pomegranate","Pecan-Nut","Pine-Nut","Mango","Lemon","Limes","Juniper-Berries","Grapes-red-seedless","Figs",
            "Cumquat","Blackberries","Black-limes","Slivered-Almonds","Rockmelon","Melon","Orange-blood","Prunes","Preserved-lemon","Papaw","Red-papaya"};

    private static final String[] CATEGORY_VEGETABLE = {"Alfalfa","Arugula","Bean-Sprouts","Broccolini","Brussels-Sprouts","Butternut-lettuce","Celery","Capsicum-red","Chilli-Pepper-Fresh","Chicory",
            "Chinese-Cabbage","Choy-Sum","Cauliflower","Bush-Tomato","Onion-Red","Capsicum","Carrot","Garlic","Jarrahdale-pumpkin","Jerusalem-Artichoke",
            "Horseradish","Lotus-Root","Pumpkin","Purple-carrot","Radicchio","Turnips","Tamarillo","Tomato-Truss",
            "Sun-dried-tomatoes","Shallots","Red-Pepper","Potatoes","Persimmon","Parsnip","Onion-White","Onion-Brown",
            "Leeks","Fennel","Daikon","Courgette","Chillies-dried","Cayenne","Butternut-pumpkin","Beetroot","Asparagus","Pepper",
            "Tomatoes-Roma","Radicchio-Castelfranco","Cornichons","Cipollini-onions","Celeriac","Artichoke","Zucchini","Tomato",
            "Sweet-Potato","Spring-Onions","Eggplant","Radish","English-Spinach","Salad","Cabbage","Iceberg-lettuce",
            "Wakame","Squash","Rhubarb","Nori","Kale","Hijiki","Edamame","Cos-lettuce","Spinach","Silverbeet","Gem","Endive",
            "Bamboo-Shoots","Asian-Greens","Arame","Rocket","Okra","Red-cabbage"};

    private static final String[] CATEGORY_MEAT_EGG = { "Bacon","Beef-Organic","Sausages","Eggs","Ham","Liver","Kangaroo","Veal","Stock-Chicken","Kidneys","Turkey",
            "Spatchcock","Lamb","Duck","Chicken-Free-Range","Stock-Beef","Oca","Pork","Quail"};

    private static final String[] CATEGORY_PASTA_BREAD_RISE = {"Arborio-rice","Asian-Noodles","Barley-Pearl","Basmati-rice","Black-Rice","Bread-Rice","Bread-Spelt","Bread-Wholemeal","Bulghur",
            "Cornmeal","Quinoa","Purple-Rice","Cous-Cous","Bread","Green-Tea-noodles","Hokkien-Noodles","Koshihikari-rice","Polenta","Mountain-Bread","Jasmine-rice",
            "Brown-Rice","Bread-Rye","Bread-White","White-rice","Wild-Rice","Bread-Sour-Dough","Bread-Wholegrain","Pasta-Dried","Rice-Noodles"};

    private static final String[] CATEGORY_SPICES = {"Cacao","Cardamom","Aniseed","Coriander-Leaves","Zatar","Green-Chicken-Curry","Ginger","Lemon-Myrtle","Oregano","Curry-Powder","Paprika",
            "File-Powder","Tarragon","Peppercorns","Marjoram","Licorice","Lemongrass","Lavender-Flowers","Garam-Masala","Garlic-Chives","Galangal",
            "Curry-Leaves","Cumin","Coriander-Seed","Cloves","Cinnamon","Chinese-Five-Spice","Cassia-bark","Bay-Leaves","Spearmint","Asafoetida","Stevia","Saffron",
            "Rosemary","Dill","Dandelion","Chervil","Basil-fresh","Turmeric","Thyme","Sumac","Star-Anise","Sage","Mint","Nutmeg","Parsley","Peppermint"};

    private static final String[] CATEGORY_FISH = {"Albacore-Tuna","Barramundi","Blue-Swimmer-Crab", "Clams","Yellowtail-Kingfish","John-Dory","Tuna-tinned","Redfish","Hiramasa-Kingfish",
            "Monkfish","Parrotfish","Stock-Fish","Jewfish","Swordfish","Tuna","Shark","Octopus","Lobster","Calamari","Mackerel-Tinned","Whiting","Sardines",
            "Scallops","Trout","Spanner-Crab","Smoked-Trout","Silver-Trevally","Oysters","Ocean-Perch","Mahi-mahi","Hot-smoked-salmon","Flounder","Flathead","Crabs","Bonito-Flakes",
            "Orange-Roughy","Anchovies","Threadfin-Bream","Squid","Snapper","Mirror-Dory","Mackerel","Leatherjacket","Farmed-Prawns","Blue-Eye-Trevalla",
            "Warehou","Salmon","Morwong","Mullet","Mussels","Prawns"};

    private static final String[] CATEGORY_DAIRY_PRODUCT = {"Butter","Cottage-Cheese","Taleggio-cheese","Blue-Cheese","Cream-Cheese","Parmesan-cheese","Rice-milk","Oat-milk", "Buttermilk","Soy-Milk",
            "Feta","Yoghurt","Mozzarella","Cheddar","Edam","Fromage-Blanc","Ricotta","Quark","Provolone","Camembert","Brie","Pecorino","Mascarpone","Margarine","Haloumi","Gruyere"};

    private static final String[] CATEGORY_DESSERT = {"Chocolate-Dark","Corn-Syrup","Agave-Syrup","Cream","Strudel","Vanilla-Beans","Maple-Syrup","Honey",
            "Cake","Rice-Syrup","Jelly","Cocoa-powder","Barley-Malt"};

    private static final String[] CATEGORY_SAUCES = {"Avocado-Spread","Wasabi","Omega-Spread","Fish-Sauce","Soy-Sauce","Mustard","Molasses","Mirin","Kecap-Manis","Dijon-mustard",
            "Balsamic-Vinegar","Baba-ghanoush","Apple-Cider-Vinegar","Sweet-Chilli-Sauce","Red-Wine-Vinegar","Hummus",
            "Harissa","Brown-rice-vinegar","White-wine-vinegar","Vinegar","Tamari","Tabasco","Malt-vinegar","Oyster-Sauce"};

    private static final String[] CATEGORY_BEVERAGES = {"Apple-Juice-Concentrate","Coconut-water","Wine-Red","Verjuice","Pear-Juice-Concentrate","Apple-juice",
            "Wheatgrass-juice","Sake","Water", "Tea","Green-Tea","Coffee","Camomile","Wine-White"};

    private static final String[] CATEGORY_LEGUMES = {"Beans-Green","Kidney-Beans","Beans-Broad","Beans-Snake","Borlotti-Beans","Soy-Beans","Adzuki-Beans","Beans",
            "Beans-Runner","Black-Eyed-Beans","Butter-Beans","Cannellini-Beans","Haricot-Beans","Mung-Beans","Pinto-Beans",
            "Lentils","Red-Lentils","Sugarsnap-peas","Snowpeas","Peas","Chickpea","Bean-Shoots","Chinese-Broccoli","Broccoli"};

    private static final String[] CATEGORY_VEGAN = {"Tofu","Tempeh", "Miso", "Quorn", "Chia Seeds", "Ajowan-Seed","Wattleseed","Mustard-Seed","Flaxseed","Caraway-Seed",
            "Sunflower-Seeds","Sesame-seed","Pumpkin-Seed","Nigella-seed","Fennel-seeds","Celery-seed", "Poppy-seed", "Coriander-seed"};

    private static final String[] CATEGORY_FLOUR_CEREALS = {"Flour-Tapioca","Flour-Potato","Sweetcorn","Spelt","Oats-Coarse","Flour-Oat","Flour-Rice","Flour-Unbleached","Freekeh","Flour-Soy",
            "Amaranth","Buckwheat","Barley-Rolled","Baking-Powder","Oats-Rolled","Flour-Besan","Flour-Wholewheat","Barley","Wheat","Triticale","Semolina","Rye","Muesli"};

    private static final String[] CATEGORY_OILS = {"Almond-oil","Camellia-Tea-Oil","Macadamia-oil","Tea-Oil","Avocado-Oil","Canola-Oil","Coconut-Oil","Corn-Oil","Grape-Seed-Oil",
            "Sunflower-Oil","Vegetable-Oil","Extra-virgin-olive-oil","Olive-Oil","Safflower-Oil","Sesame-Oil","Flaxseed-Oil"};

    private static final String[] CATEGORY_MUSHROOMS = {"Mushrooms-Oyster","Mushrooms-Brown","Porcini-mushrooms","Mushrooms-Shiitake","Mushrooms-Common-Cultivated","Mushrooms-Enoki","Mushroom-Flat"};

    private static final String[] ALL_FOOD = { "Achacha","Apples-Braeburn","Apples-Granny-Smith","Apples-Red-Delicious", "Apples-Royal-Gala","Avocado","Banana",
            "Berries","Beurre-Bosc-Pears","Blood-oranges", "Cantaloupe", "Cashews","Cherries","Chestnut", "Coconut","Cucumber","Currants","Custard-Apples",
            "Dragonfruit","Grapefruit","Kiwi-Fruit","Jackfruit","Passionfruit","Star-Fruit","Goji-Berry","Cranberry","Raspberry","Elderberry","Wolfberry","Watermelon",
            "Pineapple","Plums","Corella-Pear","Honeydew-melon","Apples-Bonza","Apples-Golden-Delicious","Apples-Jonathan","Papaya","Lychees","Kiwiberries", "Pistachio-Nut",
            "Feijoa","Guava","Hazelnut","Kaffir-Lime-Leaves","Longan","Strawberries","Raisin","Oranges","Nuts","Nectarines-white","Macadamia-Nut","Mulberries","Mandarins","Mace",
            "Loquats","Incaberries","Grapes", "Fingerlime","Dried-Apricots","Dates","Cherry-Plum","Carob","Carambola","Blueberries","Brazil-Nut","Beurre-Bosc-Pear","Packham-Pear",
            "Apples-Jazz","Apples-Red-Fuji","Apricots","Apples","Apples-Sundowner","William-Pear","Pears",
            "Peaches","Paradise-Pears","Nashi-Pear","Nectarines","Olives","Avocado-Reed","Almonds","Walnut","Umeboshi","Tangelo","Sultanas",
            "Quince","Pomegranate","Pecan-Nut","Pine-Nut","Mango","Lemon","Limes","Juniper-Berries","Grapes-red-seedless","Figs",
            "Cumquat","Blackberries","Black-limes","Slivered-Almonds","Rockmelon","Melon","Orange-blood","Prunes","Preserved-lemon","Papaw","Red-papaya", "Alfalfa","Arugula","Bean-Sprouts","Broccolini","Brussels-Sprouts","Butternut-lettuce","Celery","Capsicum-red","Chilli-Pepper-Fresh","Chicory",
            "Chinese-Cabbage","Choy-Sum","Cauliflower","Bush-Tomato","Onion-Red","Capsicum","Carrot","Garlic","Jarrahdale-pumpkin","Jerusalem-Artichoke",
            "Horseradish","Lotus-Root","Pumpkin","Purple-carrot","Radicchio","Turnips","Tamarillo","Tomato-Truss",
            "Sun-dried-tomatoes","Shallots","Red-Pepper","Potatoes","Persimmon","Parsnip","Onion-White","Onion-Brown",
            "Leeks","Fennel","Daikon","Courgette","Chillies-dried","Cayenne","Butternut-pumpkin","Beetroot","Asparagus","Pepper",
            "Tomatoes-Roma","Radicchio-Castelfranco","Cornichons","Cipollini-onions","Celeriac","Artichoke","Zucchini","Tomato",
            "Sweet-Potato","Spring-Onions","Eggplant","Radish","English-Spinach","Salad","Cabbage","Iceberg-lettuce",
            "Wakame","Squash","Rhubarb","Nori","Kale","Hijiki","Edamame","Cos-lettuce","Spinach","Silverbeet","Gem","Endive",
            "Bamboo-Shoots","Asian-Greens","Arame","Rocket","Okra","Red-cabbage", "Bacon","Beef-Organic","Sausages","Eggs","Ham","Liver","Kangaroo","Veal","Stock-Chicken","Kidneys","Turkey",
            "Spatchcock","Lamb","Duck","Chicken-Free-Range","Stock-Beef","Oca","Pork","Quail", "Arborio-rice","Asian-Noodles","Barley-Pearl","Basmati-rice","Black-Rice","Bread-Rice","Bread-Spelt","Bread-Wholemeal","Bulghur",
            "Cornmeal","Quinoa","Purple-Rice","Cous-Cous","Bread","Green-Tea-noodles","Hokkien-Noodles","Koshihikari-rice","Polenta","Mountain-Bread","Jasmine-rice",
            "Brown-Rice","Bread-Rye","Bread-White","White-rice","Wild-Rice","Bread-Sour-Dough","Bread-Wholegrain","Pasta-Dried","Rice-Noodles", "Cacao","Cardamom","Aniseed","Coriander-Leaves","Zatar","Green-Chicken-Curry","Ginger","Lemon-Myrtle","Oregano","Curry-Powder","Paprika",
            "File-Powder","Tarragon","Peppercorns","Marjoram","Licorice","Lemongrass","Lavender-Flowers","Garam-Masala","Garlic-Chives","Galangal",
            "Curry-Leaves","Cumin","Coriander-Seed","Cloves","Cinnamon","Chinese-Five-Spice","Cassia-bark","Bay-Leaves","Spearmint","Asafoetida","Stevia","Saffron",
            "Rosemary","Dill","Dandelion","Chervil","Basil-fresh","Turmeric","Thyme","Sumac","Star-Anise","Sage","Mint","Nutmeg","Parsley","Peppermint","Albacore-Tuna","Barramundi","Blue-Swimmer-Crab", "Clams","Yellowtail-Kingfish","John-Dory","Tuna-tinned","Redfish","Hiramasa-Kingfish",
            "Monkfish","Parrotfish","Stock-Fish","Jewfish","Swordfish","Tuna","Shark","Octopus","Lobster","Calamari","Mackerel-Tinned","Whiting","Sardines",
            "Scallops","Trout","Spanner-Crab","Smoked-Trout","Silver-Trevally","Oysters","Ocean-Perch","Mahi-mahi","Hot-smoked-salmon","Flounder","Flathead","Crabs","Bonito-Flakes",
            "Orange-Roughy","Anchovies","Threadfin-Bream","Squid","Snapper","Mirror-Dory","Mackerel","Leatherjacket","Farmed-Prawns","Blue-Eye-Trevalla",
            "Warehou","Salmon","Morwong","Mullet","Mussels","Prawns", "Butter","Cottage-Cheese","Taleggio-cheese","Blue-Cheese","Cream-Cheese","Parmesan-cheese","Rice-milk","Oat-milk", "Buttermilk","Soy-Milk",
            "Feta","Yoghurt","Mozzarella","Cheddar","Edam","Fromage-Blanc","Ricotta","Quark","Provolone","Camembert","Brie","Pecorino","Mascarpone","Margarine","Haloumi","Gruyere", "Chocolate-Dark","Corn-Syrup","Agave-Syrup","Cream","Strudel","Vanilla-Beans","Maple-Syrup","Honey",
            "Cake","Rice-Syrup","Jelly","Cocoa-powder","Barley-Malt", "Avocado-Spread","Wasabi","Omega-Spread","Fish-Sauce","Soy-Sauce","Mustard","Molasses","Mirin","Kecap-Manis","Dijon-mustard",
            "Balsamic-Vinegar","Baba-ghanoush","Apple-Cider-Vinegar","Sweet-Chilli-Sauce","Red-Wine-Vinegar","Hummus",
            "Harissa","Brown-rice-vinegar","White-wine-vinegar","Vinegar","Tamari","Tabasco","Malt-vinegar","Oyster-Sauce", "Apple-Juice-Concentrate","Coconut-water","Wine-Red","Verjuice","Pear-Juice-Concentrate","Apple-juice",
            "Wheatgrass-juice","Sake","Water", "Tea","Green-Tea","Coffee","Camomile","Wine-White", "Beans-Green","Kidney-Beans","Beans-Broad","Beans-Snake","Borlotti-Beans","Soy-Beans","Adzuki-Beans","Beans",
            "Beans-Runner","Black-Eyed-Beans","Butter-Beans","Cannellini-Beans","Haricot-Beans","Mung-Beans","Pinto-Beans",
            "Lentils","Red-Lentils","Sugarsnap-peas","Snowpeas","Peas","Chickpea","Bean-Shoots","Chinese-Broccoli","Broccoli", "Tofu","Tempeh", "Miso", "Quorn", "Chia Seeds", "Ajowan-Seed","Wattleseed","Mustard-Seed","Flaxseed","Caraway-Seed",
            "Sunflower-Seeds","Sesame-seed","Pumpkin-Seed","Nigella-seed","Fennel-seeds","Celery-seed", "Poppy-seed", "Coriander-seed", "Flour-Tapioca","Flour-Potato","Sweetcorn","Spelt","Oats-Coarse","Flour-Oat","Flour-Rice","Flour-Unbleached","Freekeh","Flour-Soy",
            "Amaranth","Buckwheat","Barley-Rolled","Baking-Powder","Oats-Rolled","Flour-Besan","Flour-Wholewheat","Barley","Wheat","Triticale","Semolina","Rye","Muesli", "Almond-oil","Camellia-Tea-Oil","Macadamia-oil","Tea-Oil","Avocado-Oil","Canola-Oil","Coconut-Oil","Corn-Oil","Grape-Seed-Oil",
            "Sunflower-Oil","Vegetable-Oil","Extra-virgin-olive-oil","Olive-Oil","Safflower-Oil","Sesame-Oil","Flaxseed-Oil", "Mushrooms-Oyster","Mushrooms-Brown","Porcini-mushrooms","Mushrooms-Shiitake","Mushrooms-Common-Cultivated","Mushrooms-Enoki","Mushroom-Flat"};

    //non deve essere istanziata
    private ListAllFood() {
        throw new IllegalStateException("Utility class");
    }

    public static String[] getCategoryFruit() {
        return CATEGORY_FRUIT;
    }

    public static String[] getCategoryVegetable() {
        return CATEGORY_VEGETABLE;
    }

    public static String[] getCategoryMeatEgg() {
        return CATEGORY_MEAT_EGG;
    }

    public static String[] getCategoryPastaBreadRise() {
        return CATEGORY_PASTA_BREAD_RISE;
    }

    public static String[] getCategorySpices() {
        return CATEGORY_SPICES;
    }

    public static String[] getCategoryFish() {
        return CATEGORY_FISH;
    }

    public static String[] getCategoryDessert() {
        return CATEGORY_DESSERT;
    }

    public static String[] getCategorySauces() {
        return CATEGORY_SAUCES;
    }

    public static String[] getCategoryBeverages() {
        return CATEGORY_BEVERAGES;
    }

    public static String[] getCategoryLegumes() {
        return CATEGORY_LEGUMES;
    }

    public static String[] getCategoryVegan() {
        return CATEGORY_VEGAN;
    }

    public static String[] getCategoryFlourCereals() {
        return CATEGORY_FLOUR_CEREALS;
    }

    public static String[] getCategoryOils() {
        return CATEGORY_OILS;
    }

    public static String[] getCategoryMushrooms() {
        return CATEGORY_MUSHROOMS;
    }

    public static String[] getCategoryDairyProduct() { return CATEGORY_DAIRY_PRODUCT; }

    public static String[] getAllFood() { return ALL_FOOD; }

    public static List<String> getCategory(String cat){
        switch(cat){
            case "Fruit": return new ArrayList<>(Arrays.asList(getCategoryFruit()));
            case "Vegetable": return new ArrayList<>(Arrays.asList(getCategoryVegetable()));
            case "Meat": return new ArrayList<>(Arrays.asList(getCategoryMeatEgg()));
            case "Fish": return new ArrayList<>(Arrays.asList(getCategoryFish()));
            case "Cereals and Flour": return new ArrayList<>(Arrays.asList(getCategoryFlourCereals()));
            case "Bread and Pasta": return new ArrayList<>(Arrays.asList(getCategoryPastaBreadRise()));
            case "Legumes": return new ArrayList<>(Arrays.asList(getCategoryLegumes()));
            case "Mushroom": return new ArrayList<>(Arrays.asList(getCategoryMushrooms()));
            case "Dairy Product": return new ArrayList<>(Arrays.asList(getCategoryDairyProduct()));
            case "Dessert": return new ArrayList<>(Arrays.asList(getCategoryDessert()));
            case "Spices": return new ArrayList<>(Arrays.asList(getCategorySpices()));
            case "Sauces": return new ArrayList<>(Arrays.asList(getCategorySauces()));
            case "Beverages": return new ArrayList<>(Arrays.asList(getCategoryBeverages()));
            case "Vegan": return new ArrayList<>(Arrays.asList(getCategoryVegan()));
            case "Oils": return new ArrayList<>(Arrays.asList(getCategoryOils()));
            default: return null;
        }
    }

}
