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


        String t1url = "https://image.hm.com/assets/006/c3/71/c371d4e343de6706a4474487c3a6aca657283800.jpg?imwidth=2160";
        // Categories
        Category tops = new Category(1L,"Shirts");
        Category pants = new Category(2L,"Pants");
        Category shoes = new Category(3L, "Shoes");

        categories.put(tops.getId(), tops);
        categories.put(pants.getId(), pants);
        categories.put(shoes.getId(), shoes);

        // Images url for tops:

        String t2url = "https://image.hm.com/assets/hm/89/91/8991e3b225e222c17d9d0e1703d8e765af4885fa.jpg?imwidth=1536";
        String t3url =   "https://image.hm.com/assets/hm/88/66/8866cf858916a009287778c867d5b178453d0d64.jpg?imwidth=1536";
        String t4url = "https://image.hm.com/assets/006/ff/e0/ffe06bbe6a0a7e5af11522564c6703f5c083b3c7.jpg?imwidth=2160";
        String t5url = "https://image.hm.com/assets/hm/81/69/8169a165a42b23a507f9a3285205f61f8874362a.jpg?imwidth=1536";
        String t6url = "https://image.hm.com/assets/hm/9c/ba/9cba9022214faa499dfb38d0eecefad02119cd35.jpg?imwidth=1536";
        String t7url = "https://image.hm.com/assets/hm/a1/3a/a13a2d63c7ac7d8356a6f7a8dde2f7f989024e7b.jpg?imwidth=1536";
        String t8url = "https://image.hm.com/assets/hm/0a/11/0a11415d425a0f392d6fec669790b7181e53d24f.jpg?imwidth=1536";

        // images url for pants:
        String p1url = "https://image.hm.com/assets/006/66/42/66423a279eae387f4f1304f790f21d2696641960.jpg?imwidth=1536";
        String p2url = "https://image.hm.com/assets/006/c8/26/c82642fd79a9f258d0bef1125b4296e32f2ac1d9.jpg?imwidth=1536";
        String p3url= "https://image.hm.com/assets/hm/a6/8e/a68ec98cb51671d4450194b72e6148018aba0775.jpg?imwidth=2160";
        String p4url = "https://image.hm.com/assets/006/e7/64/e764745ee689bed755a34e1036b93a0798d69b47.jpg?imwidth=1536";
        String p5url = "https://image.hm.com/assets/hm/3b/c0/3bc0c8ff7e99160e8866b8679fb35eb5743dfcc5.jpg?imwidth=1536";
        String p6url = "https://image.hm.com/assets/hm/17/97/1797411d400368050ed60d46c2e32ed26c0efd90.jpg?imwidth=1536";
        String p7url = "https://image.hm.com/assets/hm/79/29/792968ed031040afc9d80bfcb08e4d60fc44e2bd.jpg?imwidth=1536";
        String p8url = "https://image.hm.com/assets/hm/ae/17/ae17a17aa80fae1527577161e92ef0072a3888d6.jpg?imwidth=1536";

        // Images url for shoes:
        String s1url = "https://image.hm.com/assets/hm/5c/b1/5cb1f60c8f4775452f7207a114dcfd4c768d0101.jpg?imwidth=1536";
        String s2url = "https://image.hm.com/assets/hm/b7/1e/b71e2afc636977e6c3302c6f88d0dbbe5ad2e105.jpg?imwidth=1536";
        String s3url = "https://image.hm.com/assets/hm/27/ae/27ae25276c9e618f8cabd9dc395d5e1584c000be.jpg?imwidth=1536";
        String s4url = "https://image.hm.com/assets/hm/e8/61/e861ca2817692a6e1aae9c7f34006479e810208a.jpg?imwidth=1536";
        String s5url = "https://image.hm.com/assets/hm/3c/b2/3cb2763c59c34881ff013a6d984c37d3e269f38a.jpg?imwidth=1536";
        String s6url = "https://image.hm.com/assets/hm/ac/a4/aca424c94d6cb29579fd99d576838d00a2d3025d.jpg?imwidth=1536";
        String s7url = "https://image.hm.com/assets/hm/d0/c6/d0c6ebaabb0d67dd5d8852222a5c91a1d22d6e95.jpg?imwidth=1536";
        String s8url = "https://image.hm.com/assets/hm/64/e3/64e3db8cb3257f26bec07c2b2267db21abecf827.jpg?imwidth=1536";


        
        // Tops
        products.put(101L, new Product(101L, "Blue Sweater", 499, false, t1url, tops));
        products.put(102L, new Product(102L, "Black Shirt", 199, false, t2url, tops));
        products.put(103L, new Product(103L,"White Shirt",199, true, t3url,tops));
        products.put(104L, new Product(104L,"Green Sweater", 399, false, t4url,tops ));
        products.put(105L, new Product(105L,"Checkered Shirt", 499, true, t5url, tops));
        products.put(106L, new Product(106L, "Grey Hoodie", 399, false, t6url, tops));
        products.put(107L,new Product(107L,"Black T-Shirt", 199, false, t7url, tops));
        products.put(108L, new Product(108L, "Black Hoodie",399, false, t8url, tops ));

        
        // Pants
        products.put(201L, new Product(201L, "Blue Jeans",699, false, p1url,pants));
        products.put(202L, new Product(202L,"Black Chinos", 499, true, p2url,pants ));
        products.put(203L, new Product(203L,"Black Slacks", 799, true, p3url, pants));
        products.put(204L, new Product(204L,"Black Jeans", 699, false, p4url,pants ));
        products.put(205L, new Product(205L,"Training shorts", 249,  true, p5url, pants));
        products.put(206L,new Product(206L, "White Linen Pants", 599, false, p6url, pants));
        products.put(207L, new Product(207L, "Grey Slacks",699, false, p7url, pants));
        products.put(208L, new Product(208L, "Washed Jeans", 499, false, p8url, pants));

        products.put(301L, new Product(301L,"White Sneakers", 399, false, s1url,shoes));
        products.put(302L, new Product(302L,"Green Sneakers", 599, true, s2url,shoes));
        products.put(303L, new Product(303L,"Black Dress Shoe", 999, false, s3url,shoes));
        products.put(304L, new Product(304L,"Brown Sandals", 299, true, s4url,shoes));
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
