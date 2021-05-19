package com.sebastiaofortes.jpa.jpa_hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        EntityManagerFactory entityManagerFactory 
        = Persistence.createEntityManagerFactory("Clientes-PU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
 
    
    // Para as CRUD's funcionarem é necessário que exista pelo menos
    // 3 registros na tabela clientes
    
    Cliente cliente = new Cliente();
    cliente.setNome("Armazém Feliz");
    
    Cliente cliente2 = entityManager.find(Cliente.class, 1);
    System.out.println(cliente2.getNome());
 
    Cliente cliente3 = entityManager.find(Cliente.class, 2);
    
    Cliente cliente4 = entityManager.find(Cliente.class, 1);
    
    Cliente cliente5 = new Cliente();
    cliente5.setId(3);
    cliente5.setNome("Autopeças Rua");
    
    Cliente cliente6 = new Cliente();
    cliente6.setNome("Eletrônica Almeida");
    
    entityManager.getTransaction().begin();
    entityManager.persist(cliente); // INSERT
//  entityManager.remove(cliente3);  // DELETE // só funciona se o registro de id=2 estiver no BD
    cliente4.setNome("Autopeças Rodovia"); // UPDATE
    entityManager.merge(cliente5); // UPDATE merge
    entityManager.merge(cliente6); // INSERT merge
    entityManager.getTransaction().commit();
    
    entityManager.close();
    entityManagerFactory.close();
        
    }
}
