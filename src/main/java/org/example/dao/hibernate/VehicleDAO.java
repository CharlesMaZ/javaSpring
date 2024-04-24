package org.example.dao.hibernate;


import org.example.dao.IVehicleRepository;
import org.example.model.User;
import org.example.model.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collection;


public class VehicleDAO implements IVehicleRepository {
    SessionFactory sessionFactory;

    public VehicleDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean rentVehicle(String plate, String login) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            User user = session.get(User.class, login);
            Vehicle vehicle = session.get(Vehicle.class, plate);

            if (user != null && vehicle != null && user.getVehicle() == null) {
                vehicle.setUser(user);
                vehicle.setRent(true);
                user.setVehicle(vehicle);

                session.saveOrUpdate(user);
                session.saveOrUpdate(vehicle);

                transaction.commit();
                return true;
            } else {
                if (transaction != null) {
                    transaction.rollback();
                }
                return false;
            }
        } catch (RuntimeException e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }


    @Override
    public boolean addVehicle(Vehicle vehicle) {
        Session session = null;
        Transaction transaction = null;
        boolean success=false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
            success = true;
        }catch (RuntimeException e){
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
        return success;
    }
    @Override
    public boolean removeVehicle(String plate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Vehicle vehicle = session.get(Vehicle.class, plate);
            if (vehicle != null && vehicle.getUser() == null){
                session.remove(vehicle);
                transaction.commit();
                return true;
            }else {
                if(transaction != null){
                    transaction.rollback();
                }
                return false;
            }
        }catch (RuntimeException e){
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        //return false;
    }

    @Override
    public Vehicle getVehicle(String plate) {
        Session session = sessionFactory.openSession();
        try {
            Vehicle vehicle = session.get(Vehicle.class, plate);
            return vehicle;
        } finally {
            session.close();
        }
    }

    //Must implement old interface. Plate is no longer needed when User has Vehicle.
    public boolean returnVehicle(String plate,String login) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            User user = session.get(User.class, login);
            if (user.getVehicle() == null){
                return false;
            }
            Vehicle vehicle = user.getVehicle();

            user.setVehicle(null);
            vehicle.setUser(null);

            vehicle.setRent(false);

            session.update(user);
            session.update(vehicle);
            transaction.commit();
            return true;
        }catch (RuntimeException e){
            if (transaction != null){
                transaction.rollback();

            }
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
        //TODO: add returnVehicle
        //return false;

    }

    @Override
    public Collection<Vehicle> getVehicles() {
        Session session = sessionFactory.openSession();
        try {
            return null;
        } finally {
            session.close();
        }
    }
}
