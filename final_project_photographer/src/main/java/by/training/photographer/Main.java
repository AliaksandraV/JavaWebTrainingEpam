package by.training.photographer;

import by.training.photographer.dao.AlbumDaoImpl;
import by.training.photographer.entity.AlbumEntity;
import by.training.photographer.entity.PhotoCategoryEntity;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        AlbumEntity album = new AlbumEntity();
        Calendar calendar = Calendar.getInstance();// new GregorianCalendar(2018, 12, 12);
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 7);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        album.setDate(calendar);

//        LocalizedTextEntity text = new LocalizedTextEntity();
//        text.setRussian("Test test");
//        album.setDescriptionEntity(text);
//        LocalizedTextEntity text1 = new LocalizedTextEntity();
//        text1.setRussian("Neimushka");
//        album.setNameEntity(text);

        PhotoCategoryEntity category = new PhotoCategoryEntity();
        category.setId(1);
        album.setPhotoCategory(category);

//        album.setId(11);
        AlbumDaoImpl dao = new AlbumDaoImpl();
//        dao.create(album);
//        dao.update(album);
//        dao.delete(8);
//        List<AlbumEntity> albums = dao.findAll();
//        for (AlbumEntity a : albums) {
//            System.out.println(a);
//        }

        AlbumEntity album1 = new AlbumEntity();
        album1 = dao.findById(1);
        System.out.println(album1);


//        String url = "jdbc:mysql://localhost:3306/photographer";
//        Properties prop = new Properties();
//        prop.put("user", "root");
//        prop.put("password", "root");
//        prop.put("autoReconnect", "true");
//        prop.put("characterEncoding", "UTF-8");
//        prop.put("useUnicode", "true");
//        Connection cn = null;
//
//        try {
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//            cn = DriverManager.getConnection(url, prop);
//            Statement st = null;
//            try {
//                st = cn.createStatement();
//                ResultSet rs = null;
//                try {
//                    rs = st.executeQuery("SELECT * FROM user");
//                    List<UserEntity> lst = new ArrayList<>();
//                    while (rs.next()) {
//                        int id = rs.getInt(1);
//                        String email = rs.getString(2);
//                        String password = rs.getString(3);
//                        String name = rs.getString(4);
//                        String phone = rs.getString(5);
//                        int role = rs.getInt(6);
//                        lst.add(new UserEntity(id, email, password, name, phone, role));
//                    }
//                    if (lst.size() > 0) {
//                        System.out.println(lst);
//                    } else {
//                        System.out.println("Not found");
//                    }
//
//                } finally {
//                    if (rs != null) { // был ли создан ResultSet
//                         rs.close();
//                    } else {
//                        System.err.println("ошибка во время чтения из БД");
//                    }
//                }
//            } finally {
//                if (st != null) {
//                    st.close();
//                } else {
//                    System.err.println("Statement не создан");
//                }
//            }
//        } catch (SQLException e) { // для 1-го блока try
//            System.err.println("DB connection error: " + e);
//        } finally {
//            if (cn != null) {
//                try {
//                    cn.close();
//                } catch (SQLException e) {
//                    System.err.println("Сonnection close error: " + e);
//                }
//            }
//        }
    }
}
