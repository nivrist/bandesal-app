/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejb;

import com.bandesal.entities.BandesalBlogsReaders;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author irvin
 */
@Local
public interface BandesalBlogsReadersFacadeLocal {

    void create(BandesalBlogsReaders bandesalBlogsReaders);

    void edit(BandesalBlogsReaders bandesalBlogsReaders);

    void remove(BandesalBlogsReaders bandesalBlogsReaders);

    BandesalBlogsReaders find(Object id);

    List<BandesalBlogsReaders> findAll();

    List<BandesalBlogsReaders> findRange(int[] range);

    int count();
    
}
