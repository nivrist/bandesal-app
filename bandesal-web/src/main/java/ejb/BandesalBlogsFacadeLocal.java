/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejb;

import com.bandesal.entities.BandesalBlogs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author irvin
 */
@Local
public interface BandesalBlogsFacadeLocal {

    void create(BandesalBlogs bandesalBlogs);

    void edit(BandesalBlogs bandesalBlogs);

    void remove(BandesalBlogs bandesalBlogs);

    BandesalBlogs find(Object id);

    List<BandesalBlogs> findAll();

    List<BandesalBlogs> findRange(int[] range);

    int count();
    
}
