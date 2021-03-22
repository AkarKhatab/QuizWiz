/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizwiz.io;


import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author behrozkeyvannia
 */
@Stateless
public class HighscoreRegistry extends AbstractDAO<Highscore, Long> { 
    @PersistenceContext
    private EntityManager em;

    public HighscoreRegistry() {
        super(Highscore.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
