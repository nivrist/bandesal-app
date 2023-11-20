/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import com.bandesal.entities.BandesalBlogsReaders;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author irvin
 */
@Stateless
public class BandesalBlogsReadersFacade extends AbstractFacade<BandesalBlogsReaders> implements BandesalBlogsReadersFacadeLocal {

    @PersistenceContext(unitName = "PunitBandesal")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BandesalBlogsReadersFacade() {
        super(BandesalBlogsReaders.class);
    }
    
}
