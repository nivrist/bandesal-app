/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejb;

import com.bandesal.entities.BandesalReaders;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author irvin
 */
@Local
public interface BandesalReadersFacadeLocal {

    void create(BandesalReaders bandesalReaders);

    void edit(BandesalReaders bandesalReaders);

    void remove(BandesalReaders bandesalReaders);

    BandesalReaders find(Object id);

    List<BandesalReaders> findAll();

    List<BandesalReaders> findRange(int[] range);

    int count();
    
}
