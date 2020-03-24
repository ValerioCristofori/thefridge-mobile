package it.valeriocristofori.thefridgemobile.model.utility;

public class ListAllFood {
    private static String[] list = {"Achacha","Agave-Syrup","Agave-Syrup","Alfalfa","Almond-oil","Albacore-Tuna",
            "Annatto-seed","Apple-Juice-Concentrate","Apples-Braeburn","Apples-Granny-Smith","Apples-Red-Delicious",
            "Apples-Royal-Gala","Arborio-rice","Arugula","Asian-Noodles","Avocado","Avocado-Spread","Bacon",
            "Balmain-Bug","Banana","Barley-Pearl","Barramundi","Basmati-rice","Bean-Sprouts","Beans-Green",
            "Beef-Organic","Berries","Beurre-Bosc-Pears","Black-Rice","Blood-oranges","Blue-Swimmer-Crab",
            "Bok-Choy","Bran","Bread-Rice","Bread-Spelt","Bread-Wholemeal","Broccolini","Brussels-Sprouts","Bulghur",
            "Butter","Butternut-lettuce","Cacao","Camellia-Tea-Oil","Candle-Nut","Cantaloupe","Capsicum-red",
            "Cardamom","Cashews","Aniseed","Celery","Cherries","Chestnut","Chickory","Chilli-Pepper-Fresh",
            "Chinese-Cabbage","Chocolate-Dark","Choy-Sum","Clams","Coconut","Coconut-water","Coriander-Leaves",
            "Corn-Syrup","Cornmeal","Bush-Tomato","Cottage-Cheese","Cream","Cucumber","Currants","Custard-Apples",
            "Dashi","Devil","Dragonfruit","Edam","Eggs","English-Spinach","Feijoa","Fenugreek","File-Powder",
            "Fish-Sauce","Flaxseed-Oil"	,"Flour-Buckwheat","Fennel-Seeds","Flour-Tapioca","Flour-Potato","Fromage-Blanc",
            "Fruit-salad","Garlic","Ginger","Goji-Berry","Grapefruit","Green-Chicken-Curry","Green-Tea-noodles",
            "Guava","Ham","Hazelnut","Hokkien-Noodles","Horseradish","Iceberg-lettuce","Jarrahdale-pumpkin",
            "Jerusalem-Artichoke","John-Dory","Kaffir-Lime-Leaves","Kangaroo","Kidney-Beans","Kiwi-Fruit","Kokam",
            "Kudzu","Koshihikari-rice","Lecithin","Lemon-Myrtle","Lentils","Ling","Longan","Lotus-Root","Macadamia-oil"
            ,"Mackerel-Tinned","Malt-vinegar","Mangosteens","Marigold","Mastic","Melon","Mesclun","Mint","Miso",
            "Morwong","Muesli","Mullet","Mushroom-Flat","Mushrooms-Enoki","Mussels","Nashi-Pear","Nectarines",
            "Nigella-seed","Nutmeg","Oatmeal","Oca","Okra","Omega-Spread","Onion-Red","orange-blood","Oyster-Sauce",
            "Pandanus-leaves","Papaw","Paradise-Pears","Parsley","Pasta-Dried","Peaches","Pears","Pecorino",
            "Pepperberry","Peppermint","Pineapple","Plums","Pomegrante-molasses","Pork","Prawns","Preserved-lemon",
            "Prunes","Pumpkin-Seed","Quail","Quinoa","Radish","Red-cabbage","Red-papaya","Redfish","Rice-Noodles",
            "Rocket","Rockmelon","Rye","Sage","Salmon","Sausages","Semolina","Sesame-seed","Shoyu","Slivered-Almonds",
            "Snowpea-sprouts","Sorrel","Soy-Milk","Soy-Sprouts","Spearmint","Spring-Onions","Star-Anise","Stock-Beef",
            "Stock-Vegetable","Sugar","Sumac","Sunflower-Seeds","Sweet-Potato","Swiss-Chard","Tabasco","Tamari",
            "Tapioca","Tea-Oil","Thyme","Tomato","Triticale","Tuna","Turmeric","Vanilla-Beans","Vegetable-spaghetti",
            "Vinegar","Warehou","Watercress","Wheat","White-wine-vinegar","William-Pear","Witlof","Wine-White",
            "Yoghurt","Zucchini","Apple-juice","Apples-Bonza","Apples-Golden-Delicious","Apples-Jonathan",
            "Apples-Sundowner","Arame","Artichoke","Asian-Greens","Aubergine","Avocado-Oil","Baby-mum","Baking-Soda",
            "Bamboo-Shoots","Barley","Barley-Malt","Basil-fresh","Bean-Shoots","Beans-Broad","Beans-Snake",
            "Beetroot-powder","Beurre-Bosc-Pear","Black-limes","Blackberries","Blue-Eye-Trevalla","Bocconcini",
            "Borlotti-Beans","Bread","Bread-Sour-Dough","Bread-Wholegrain","Broccoli","Brown-rice-vinegar",
            "Buttermilk","Cabbage","Calamari","Camomile","Canola-Oil","Capsicum","Caraway-Seed","Carrot",
            "Cauliflower","Celeriac","Cheddar","Chervil","Chicken-Free-Range","Chicory","Chinese-Broccoli",
            "Chives","Chocolate-coated-strawberries","Cipollini-onions","Cocoa-powder","Coconut-Oil",
            "Corella-Pear","Corn-Oil","Cornichons","Cous-Cous","Cranberry","Cumquat","Curry-Powder",
            "Dandelion","Devil","Dill","Duck","Eggplant","Endive","Farmed-Prawns","Figs","Fioretto",
            "Flaxseed","Flour-Besan","Flour-Wholewheat","Gem","Grape-Seed-Oil","Grapes-red-seedless","Gruyere",
            "Haloumi","Harissa","Hiramasa-Kingfish","Honeydew-melon","Hummus","Jackfruit","Jelly","Jicama",
            "Juniper-Berries","Kalettes","Kenchur","Kimchi","Kohlrabi","Lamb","Leatherjacket","Lemon","Limes",
            "Lobster","Macadamia-Nut","Mackerel","Mahlab","Mango","Margarine","Mascarpone","Mirror-Dory",
            "Monkfish","Mozzarella","Mushrooms-Common-Cultivated","Mushrooms-Shiitake","Mustard-Seed","Nasturtium",
            "Nicole","Oat-milk","Oats-Rolled","Octopus","Olives","Orange-Roughy","Oregano","Packham-Pear","Panetonne",
            "Paprika","Parrotfish","Passionfruit","Pear-Juice-Concentrate","Pecan-Nut","Pepper","Pine-Nut",
            "Pistachio-Nut","Pomegranate","Porcini-mushrooms","Purple-Rice","Quince","Radicchio-Castelfranco",
            "Raspberry","Red-Wine-Vinegar","Rice-milk","Rice-Syrup","Rosemary","Saffron","Salad","Sea-Salt",
            "Shark","Silverbeet","Snapper","Soba","Soy-Beans","Spatchcock","Spinach","Squid","Stevia",
            "Stock-Fish","Strudel","Sultanas","Sunflower-Oil","Sweet-Chilli-Sauce","Taleggio-cheese","Tangelo",
            "Tea","Threadfin-Bream","Tom-Yum","Tomatoes-Roma","Turkey","Umeboshi","Vegetable-Oil",
            "Vermicelli-Noodles","Walnut","Water","Wattleseed","White-rice","Wild-Rice","Adzuki-Beans",
            "Ajowan-Seed","Agar-Agar","Almonds","Anchovies","Apple-Cider-Vinegar","Apples","Allspice",
            "Apples-Jazz","Apples-Red-Fuji","Apricots","Arrowroot","Asafoetida","Asparagus","Avocado-Reed",
            "Baba-ghanoush","Baking-Powder","Balsamic-Vinegar","Barberry","Barley-Rolled","Basil-dried",
            "Bay-Leaves","Beans","Beans-Runner","Beetroot","Beurre-Bosc-Pear","Black-Eyed-Beans","Black-tahini",
            "Blue-Cheese","Blueberries","Bonito-Flakes","Brazil-Nut","Bread-Rye","Bread-White","Brie",
            "Brown-Rice","Buckwheat","Amaranth","Butter-Beans","Butternut-pumpkin","Cake","Camembert",
            "Cannellini-Beans","Capers","Carambola","Carob","Cassia-bark","Cayenne","Celery-Seed","Cherry-Plum",
            "Chia-seeds","Chickpea","Chillies-dried","Chinese-Five-Spice","Chocolate-Milk","Cinnamon",
            "Cloves","Coconut-Cream","Coffee","Coriander-Seed","Corn-Tortilla","Cos-lettuce","Courgette",
            "Crabs","Cream-Cheese","Cumin","Curry-Leaves","Daikon","Dates","Dijon-mustard","Dried-Apricots",
            "Edamame","Elderberry","Extra-virgin-olive-oil","Fennel","Feta","Fingerlime","Flathead","Flounder",
            "Flour-Oat","Flour-Rice","Flour-Unbleached","Freekeh","Flour-Soy","Galangal","Garlic-Chives",
            "French-eschallots","Good-mood-food","Grapes","Garam-Masala","Green-Tea","Gula-Melaka","Haricot-Beans",
            "Hijiki","Honey","Hot-smoked-salmon","Incaberries","Jasmine-rice","Jewfish","juicer","Kale",
            "Kecap-Manis","Kidneys","Kiwiberries","Kombu","Kumera","Lavender-Flowers","Leeks","Lemongrass",
            "Licorice","Liver","Loquats","Lychees","Mace","Mahi-mahi","Mandarins","Maple-Syrup","Marjoram",
            "Melon-Piel-de-Sapo","Merchant-stock","Millet","Mirin","Molasses","Mountain-Bread","Mulberries",
            "Mung-Beans","Mushrooms-Brown","Mushrooms-Oyster","Mustard","Nasturtium","Nectarines-white","Nori",
            "Nuts","Oats-Coarse","Ocean-Perch","Olive-Oil","Onion-Brown","Onion-White","Oranges","Oysters",
            "Pandoro","Papaya","Parmesan-cheese","Parsnip","Pasta-dried-wholegrain","Peanuts","Peas","Pepitas",
            "Peppercorns","Persimmon","Pinto-Beans","Polenta","Poppy-Seed","Potatoes","Provolone","Prickly-Pear",
            "Pumpkin","Purple-carrot","Quark","Radicchio","Raisin","Red-Lentils","Red-Pepper","Rhubarb",
            "Rice-paper","Ricotta","Rose-Water","Safflower-Oil","Sake","Sardines","Scallops","Sesame-Oil",
            "Shallots","Silver-Trevally","Smoked-Trout","Snowpeas","Soupmaker","Soy-Sauce","Spanner-Crab",
            "Spelt","Squash","Star-Fruit","Stock-Chicken","Strawberries","Sugarsnap-peas","Sun-dried-tomatoes",
            "Swede","Sweetcorn","Swordfish","Tahini","Tamarillo","Tarragon","Tempeh","Tofu","Tomato-Truss","Trout",
            "Tuna-tinned","Turnips","Veal","Verjuice","Wakame","Wasabi","Watermelon","Wheatgrass-juice","Whiting",
            "Wine-Red","Wolfberry","Yellowtail-Kingfish","Yeast","Zatar"};

    //non deve essere istanziata
    private ListAllFood() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @return the listAllFood
     */
    public static String[] getListAllFood() {
        return list;
    }
}
