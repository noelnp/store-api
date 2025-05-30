package com.store_api.demo.service;

import com.store_api.demo.model.Category;
import com.store_api.demo.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final Map<Long, Product> products = new HashMap<>();
    private final Map<Long, Category> categories = new HashMap<>();
    
    @PostConstruct
    public void initResources() {


        String t1url = "https://i.postimg.cc/yxQ9SzWX/warm-beige-sw-eat.png";
        // Categories
        Category tops = new Category(1L,"Shirts");
        Category pants = new Category(2L,"Pants");
        Category shoes = new Category(3L, "Shoes");

        categories.put(tops.getId(), tops);
        categories.put(pants.getId(), pants);
        categories.put(shoes.getId(), shoes);

        // Images url for tops:

        String t2url = "https://i.postimg.cc/1RkbZtx0/lighthray.png";
        String t3url =   "https://i.postimg.cc/nLY3j6kC/blackzip.png";
        String t4url = "https://i.postimg.cc/NFV3JWZQ/sw-eater-gray.png";
        String t5url = "https://i.postimg.cc/SNp9vDbG/blac-hood.png";
        String t6url = "https://i.postimg.cc/CKNN7XQX/navy-sw-eat.png";
        String t7url = "https://i.postimg.cc/sXMT2KTL/black-shirt.png";
        String t8url = "https://i.postimg.cc/HLgmXcq3/white-shirt.png";

        // images url for pants:
        String p1url = "https://i.postimg.cc/Bnnbfs1g/lightblue-jeans.png";
        String p2url = "https://i.postimg.cc/cHCPXFkx/image2.png";
        String p3url= "https://i.postimg.cc/x8sdmXyT/black-slacks.png";
        String p4url = "https://i.postimg.cc/LXTS4Cwp/grea-jeans.png";
        String p5url = "https://i.postimg.cc/85hR7WmD/beige-pants.png";
        String p6url = "https://i.postimg.cc/L61GD4BW/black-jeans.png";
        String p7url = "https://i.postimg.cc/fTgTtffN/greysw-eatpants.png";
        String p8url = "https://i.postimg.cc/j5dSngmR/track-pants.png";

        // Images url for shoes:
        String s1url = "https://i.postimg.cc/X710vjHL/white-sneaks.png";
        String s2url = "https://i.postimg.cc/Fz97hrWm/green-streat.png";
        String s3url = "https://i.postimg.cc/k4vq7Lpd/mocka-sko-svart.png";
        String s4url = "https://i.postimg.cc/66VVrTCW/brows-loafs.png";
        String s5url = "https://i.postimg.cc/0yqjD668/blue-loafers.png";
        String s6url = "https://i.postimg.cc/jdVRV9Y8/leopard-sneakers.png";
        String s7url = "https://i.postimg.cc/yYMxPPPR/AKLN-red.png";
        String s8url = "https://i.postimg.cc/Bnvdy9nP/black-heels.png";


        
        // Tops
        products.put(101L, new Product(101L, "Beige Sweater", 499, false, t1url, tops));
        products.put(102L, new Product(102L, "White Sweater", 199, false, t2url, tops));
        products.put(103L, new Product(103L,"Black Sweater",199, true, t3url,tops));
        products.put(104L, new Product(104L,"Gray Sweater", 399, false, t4url,tops ));
        products.put(105L, new Product(105L,"Black Hoodie", 499, true, t5url, tops));
        products.put(106L, new Product(106L, "Blue Sweater", 399, false, t6url, tops));
        products.put(107L,new Product(107L,"Black Shirt", 199, false, t7url, tops));
        products.put(108L, new Product(108L, "White Shirt",399, false, t8url, tops ));

        
        // Pants
        products.put(201L, new Product(201L, "Blue Jeans",699, false, p1url,pants));
        products.put(202L, new Product(202L,"Gray Chinos", 499, true, p2url,pants ));
        products.put(203L, new Product(203L,"Black Slacks", 799, true, p3url, pants));
        products.put(204L, new Product(204L,"Gray Jeans", 699, false, p4url,pants ));
        products.put(205L, new Product(205L,"Linen Pants", 249,  true, p5url, pants));
        products.put(206L,new Product(206L, "Black Jeans", 599, false, p6url, pants));
        products.put(207L, new Product(207L, "Gray Sweatpants",699, false, p7url, pants));
        products.put(208L, new Product(208L, "Black Sweatpants", 499, false, p8url, pants));

        products.put(301L, new Product(301L,"White Sneakers", 399, false, s1url,shoes));
        products.put(302L, new Product(302L,"Green Sneakers", 599, true, s2url,shoes));
        products.put(303L, new Product(303L,"Black Sneakers", 999, false, s3url,shoes));
        products.put(304L, new Product(304L,"Brown Loafers", 299, true, s4url,shoes));
        products.put(305L, new Product(305L,"Blue Loafers", 499, true, s5url,shoes));
        products.put(306L, new Product(306L, "Leopard Sneakers",399, false, s6url,shoes));
        products.put(307L, new Product(307L,"Red Sneakers", 399, false, s7url,shoes));
        products.put(308L, new Product(308L,"Black Heels",499, false, s8url,shoes));
    }
    
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public List<Product> getFeaturedProducts() {
        return products.values().stream()
                .filter(Product::isFeatured)
                .collect(Collectors.toList());
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>(categories.values());
    }

    public List<Product> getProductsByCategoryId(Long categoryId) {
        return products.values().stream()
                .filter(p -> p.getCategory().getId().equals(categoryId))
                .collect(Collectors.toList());
    }
}
