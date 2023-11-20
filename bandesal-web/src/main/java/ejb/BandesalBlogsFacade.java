/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import com.bandesal.entities.BandesalBlogs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author irvin
 */
@Stateless
public class BandesalBlogsFacade extends AbstractFacade<BandesalBlogs> implements BandesalBlogsFacadeLocal {

    @PersistenceContext(unitName = "PunitBandesal")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BandesalBlogsFacade() {
        super(BandesalBlogs.class);
    }
    
}
