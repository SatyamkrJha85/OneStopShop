package com.one.stop.shop.dao;

import com.one.stop.shop.entities.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OraclePreparedStatement;

public class ProductsDao {

    private OracleConnection oconn;
    private OraclePreparedStatement ops;

    //    Constructor
    public ProductsDao(OracleConnection oconn) {
        this.oconn = oconn;
    }

    //Get mens product
    public List<Men> getMen() {
        List<Men> men = new ArrayList<Men>();
        try {
            String query = "SELECT * FROM men";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                Men row = new Men();

                row.setpID(set.getString("p_id"));
                row.setCatID(set.getInt("category_id"));
                row.setpName(set.getString("p_name"));
                row.setpDetails(set.getString("p_details"));
                row.setPrice(set.getInt("p_price"));
                row.setSleeve(set.getString("sleeve"));
                row.setFit(set.getString("fit"));
                row.setType(set.getString("type"));
                row.setFabric(set.getString("fabric"));
                row.setImage(set.getString("image"));

                men.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return men;
    }

//    Get women products
    public List<Women> getWomen() {
        List<Women> women = new ArrayList<Women>();
        try {
            String query = "SELECT * FROM women";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                Women row = new Women();

                row.setpID(set.getString("p_id"));
                row.setCatID(set.getInt("category_id"));
                row.setpName(set.getString("p_name"));
                row.setpDetails(set.getString("p_details"));
                row.setPrice(set.getInt("p_price"));
                row.setPattern(set.getString("pattern"));
                row.setFit(set.getString("fit"));
                row.setType(set.getString("type"));
                row.setFabric(set.getString("fabric"));
                row.setImage(set.getString("image"));

                women.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return women;
    }

//    Get footwear products
    public List<Footwear> getFootwear() {
        List<Footwear> footwear = new ArrayList<Footwear>();
        try {
            String query = "SELECT * FROM footwear";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                Footwear row = new Footwear();

                row.setpID(set.getString("p_id"));
                row.setCatID(set.getInt("category_id"));
                row.setpName(set.getString("p_name"));
                row.setpDetails(set.getString("p_details"));
                row.setPrice(set.getInt("p_price"));
                row.setOuterMaterial(set.getString("outer_material"));
                row.setpFor(set.getString("p_for"));
                row.setType(set.getString("type"));
                row.setOccasion(set.getString("occasion"));
                row.setImage(set.getString("image"));

                footwear.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return footwear;
    }

    //    Get jewellery products
    public List<Jewellery> getJewellery() {
        List<Jewellery> jewellery = new ArrayList<Jewellery>();
        try {
            String query = "SELECT * FROM jewellery";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                Jewellery row = new Jewellery();

                row.setpID(set.getString("p_id"));
                row.setCatID(set.getInt("category_id"));
                row.setpName(set.getString("p_name"));
                row.setpDetails(set.getString("p_details"));
                row.setPrice(set.getInt("p_price"));
                row.setClaspType(set.getString("clasp_type"));
                row.setMaterialType(set.getString("material_type"));
                row.setMetalType(set.getString("metal_type"));
                row.setGemType(set.getString("gem_type"));
                row.setImage(set.getString("image"));

                jewellery.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jewellery;
    }

    //    Get home and living products
    public List<HomeAndLiving> getHomeAndLiving() {
        List<HomeAndLiving> homeandliving = new ArrayList<HomeAndLiving>();
        try {
            String query = "SELECT * FROM homeandliving";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                HomeAndLiving row = new HomeAndLiving();

                row.setpID(set.getString("p_id"));
                row.setCatID(set.getInt("category_id"));
                row.setpName(set.getString("p_name"));
                row.setpDetails(set.getString("p_details"));
                row.setPrice(set.getInt("p_price"));
                row.setColor(set.getString("color"));
                row.setMaterial(set.getString("material"));
                row.setUse(set.getString("use"));
                row.setCountryOrigin(set.getString("country_origin"));
                row.setImage(set.getString("image"));

                homeandliving.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return homeandliving;
    }

    //    Get electronics products
    public List<Electronics> getElectronics() {
        List<Electronics> electronics = new ArrayList<Electronics>();
        try {
            String query = "SELECT * FROM electronics";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                Electronics row = new Electronics();

                row.setpID(set.getString("p_id"));
                row.setCatID(set.getInt("category_id"));
                row.setpName(set.getString("p_name"));
                row.setpDetails(set.getString("p_details"));
                row.setPrice(set.getInt("p_price"));
                row.setColor(set.getString("color"));
                row.setWeight(set.getString("weight"));
                row.setWarranty(set.getString("warranty"));
                row.setCountryOrigin(set.getString("country_origin"));
                row.setImage(set.getString("image"));

                electronics.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return electronics;
    }

    //    Get latest products
    public List<LatestProducts> getLatestProducts() {
        List<LatestProducts> latestProducts = new ArrayList<LatestProducts>();
        try {
            String query = "SELECT * FROM latestproducts";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                LatestProducts row = new LatestProducts();

                row.setpID(set.getString("p_id"));
                row.setCatID(set.getInt("category_id"));
                row.setpName(set.getString("p_name"));
                row.setpDetails(set.getString("p_details"));
                row.setPrice(set.getInt("p_price"));
                row.setColor(set.getString("color"));
                row.setManufacturer(set.getString("manufacturer"));
                row.setBrand(set.getString("brand"));
                row.setCountryOrigin(set.getString("country_origin"));
                row.setImage(set.getString("image"));

                latestProducts.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return latestProducts;
    }

    //    Get featured products
    public List<FeaturedProducts> getFeaturedProducts() {
        List<FeaturedProducts> featuredProducts = new ArrayList<FeaturedProducts>();
        try {
            String query = "SELECT * FROM featuredproducts";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                FeaturedProducts row = new FeaturedProducts();

                row.setpID(set.getString("p_id"));
                row.setCatID(set.getInt("category_id"));
                row.setpName(set.getString("p_name"));
                row.setpDetails(set.getString("p_details"));
                row.setPrice(set.getInt("p_price"));
                row.setColor(set.getString("color"));
                row.setManufacturer(set.getString("manufacturer"));
                row.setBrand(set.getString("brand"));
                row.setCountryOrigin(set.getString("country_origin"));
                row.setImage(set.getString("image"));

                featuredProducts.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return featuredProducts;
    }

//    Get product by ID for women
    public Women getWomenProducts(String id) throws SQLException {
        Women item = new Women();
        try {
            String query = "SELECT * FROM women WHERE p_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, id);

            ResultSet set = ops.executeQuery();

            if (set.next()) {

                item.setpID(set.getString("p_id"));
                item.setCatID(set.getInt("category_id"));
                item.setpName(set.getString("p_name"));
                item.setpDetails(set.getString("p_details"));
                item.setPrice(set.getInt("p_price"));
                item.setPattern(set.getString("pattern"));
                item.setFit(set.getString("fit"));
                item.setType(set.getString("type"));
                item.setFabric(set.getString("fabric"));
                item.setImage(set.getString("image"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    //    Get product by ID for men
    public Men getMenProducts(String id) throws SQLException {
        Men item = new Men();
        try {
            String query = "SELECT * FROM men WHERE p_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, id);

            ResultSet set = ops.executeQuery();

            if (set.next()) {

                item.setpID(set.getString("p_id"));
                item.setCatID(set.getInt("category_id"));
                item.setpName(set.getString("p_name"));
                item.setpDetails(set.getString("p_details"));
                item.setPrice(set.getInt("p_price"));
                item.setSleeve(set.getString("sleeve"));
                item.setFit(set.getString("fit"));
                item.setType(set.getString("type"));
                item.setFabric(set.getString("fabric"));
                item.setImage(set.getString("image"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    //    Get product by ID for jewellery
    public Jewellery getJewelleryProducts(String id) throws SQLException {
        Jewellery item = new Jewellery();
        try {
            String query = "SELECT * FROM jewellery WHERE p_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, id);

            ResultSet set = ops.executeQuery();

            if (set.next()) {

                item.setpID(set.getString("p_id"));
                item.setCatID(set.getInt("category_id"));
                item.setpName(set.getString("p_name"));
                item.setpDetails(set.getString("p_details"));
                item.setPrice(set.getInt("p_price"));
                item.setClaspType(set.getString("clasp_type"));
                item.setGemType(set.getString("gem_type"));
                item.setMaterialType(set.getString("material_type"));
                item.setMetalType(set.getString("metal_type"));
                item.setImage(set.getString("image"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    //    Get product by ID for Home and Living
    public HomeAndLiving getHomeAndLivingProducts(String id) throws SQLException {
        HomeAndLiving item = new HomeAndLiving();
        try {
            String query = "SELECT * FROM homeandliving WHERE p_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, id);

            ResultSet set = ops.executeQuery();

            if (set.next()) {

                item.setpID(set.getString("p_id"));
                item.setCatID(set.getInt("category_id"));
                item.setpName(set.getString("p_name"));
                item.setpDetails(set.getString("p_details"));
                item.setPrice(set.getInt("p_price"));
                item.setColor(set.getString("color"));
                item.setCountryOrigin(set.getString("country_origin"));
                item.setMaterial(set.getString("material"));
                item.setUse(set.getString("use"));
                item.setImage(set.getString("image"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    //    Get product by ID for electronics
    public Electronics getElectronicProducts(String id) throws SQLException {
        Electronics item = new Electronics();
        try {
            String query = "SELECT * FROM electronics WHERE p_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, id);

            ResultSet set = ops.executeQuery();

            if (set.next()) {

                item.setpID(set.getString("p_id"));
                item.setCatID(set.getInt("category_id"));
                item.setpName(set.getString("p_name"));
                item.setpDetails(set.getString("p_details"));
                item.setPrice(set.getInt("p_price"));
                item.setColor(set.getString("color"));
                item.setCountryOrigin(set.getString("country_origin"));
                item.setWarranty(set.getString("warranty"));
                item.setWeight(set.getString("weight"));
                item.setImage(set.getString("image"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    //    Get product by ID for footwear
    public Footwear getFootwearProducts(String id) throws SQLException {
        Footwear item = new Footwear();
        try {
            String query = "SELECT * FROM footwear WHERE p_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, id);

            ResultSet set = ops.executeQuery();

            if (set.next()) {

                item.setpID(set.getString("p_id"));
                item.setCatID(set.getInt("category_id"));
                item.setpName(set.getString("p_name"));
                item.setpDetails(set.getString("p_details"));
                item.setPrice(set.getInt("p_price"));
                item.setOccasion(set.getString("occasion"));
                item.setOuterMaterial(set.getString("outer_material"));
                item.setType(set.getString("type"));
                item.setpFor(set.getString("p_for"));
                item.setImage(set.getString("image"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    //    Get product by ID for featuredproduct
    public FeaturedProducts getFeaturedProducts(String id) throws SQLException {
        FeaturedProducts item = new FeaturedProducts();
        try {
            String query = "SELECT * FROM featuredproducts WHERE p_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, id);

            ResultSet set = ops.executeQuery();

            if (set.next()) {

                item.setpID(set.getString("p_id"));
                item.setCatID(set.getInt("category_id"));
                item.setpName(set.getString("p_name"));
                item.setpDetails(set.getString("p_details"));
                item.setPrice(set.getInt("p_price"));
                item.setBrand(set.getString("brand"));
                item.setColor(set.getString("color"));
                item.setCountryOrigin(set.getString("country_origin"));
                item.setManufacturer(set.getString("manufacturer"));
                item.setImage(set.getString("image"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    //    Get product by ID for featuredproduct
    public LatestProducts getLatestProducts(String id) throws SQLException {
        LatestProducts item = new LatestProducts();
        try {
            String query = "SELECT * FROM latestproducts WHERE p_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ops.setString(1, id);

            ResultSet set = ops.executeQuery();

            if (set.next()) {

                item.setpID(set.getString("p_id"));
                item.setCatID(set.getInt("category_id"));
                item.setpName(set.getString("p_name"));
                item.setpDetails(set.getString("p_details"));
                item.setPrice(set.getInt("p_price"));
                item.setBrand(set.getString("brand"));
                item.setColor(set.getString("color"));
                item.setCountryOrigin(set.getString("country_origin"));
                item.setManufacturer(set.getString("manufacturer"));
                item.setImage(set.getString("image"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    //    Get total products users
    public int countTotalProducts() {
        try {
            String query = "SELECT SUM(product_count) AS total_count "
                    + "FROM ("
                    + "    SELECT COUNT(*) AS product_count FROM men "
                    + "    UNION ALL "
                    + "    SELECT COUNT(*) AS product_count FROM women "
                    + "    UNION ALL "
                    + "    SELECT COUNT(*) AS product_count FROM homeandliving "
                    + "    UNION ALL "
                    + "    SELECT COUNT(*) AS product_count FROM electronics "
                    + "    UNION ALL "
                    + "    SELECT COUNT(*) AS product_count FROM footwear "
                    + "    UNION ALL "
                    + "    SELECT COUNT(*) AS product_count FROM jewellery "
                    + "    UNION ALL "
                    + "    SELECT COUNT(*) AS product_count FROM featuredproducts "
                    + "    UNION ALL "
                    + "    SELECT COUNT(*) AS product_count FROM latestproducts "
                    + ")";
            ops = (OraclePreparedStatement) oconn.prepareCall(query);
            ResultSet set = ops.executeQuery();

            if (set.next()) {
                return set.getInt(1); // Retrieve the result directly without using column name
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    
    // Inside ProductsDao class
    public List<Product> searchProducts(String query) {
        List<Product> searchResults = new ArrayList<>();
        try {
            String searchQuery = "SELECT * FROM all_products WHERE p_name LIKE ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(searchQuery);
            ops.setString(1, "%" + query + "%");

            ResultSet set = ops.executeQuery();

            while (set.next()) {
                Product row = new Product();

                row.setId(set.getString("p_id"));
                row.setName(set.getString("p_name"));
                row.setDetails(set.getString("p_details"));
                row.setPrice(set.getInt("p_price"));
                row.setImage(set.getString("image"));

                searchResults.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchResults;
    }
    
    //Get image name from product id
    public String productImage(String pid){
        String image = null;
        try {
            String searchQuery = "SELECT image FROM all_products WHERE p_id = ?";
            ops = (OraclePreparedStatement) oconn.prepareCall(searchQuery);
            ops.setString(1, pid);

            ResultSet set = ops.executeQuery();
            
            if(set.next()){
                image = set.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }
}
