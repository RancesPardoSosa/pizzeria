package com.proyecto.pizzeria.service;

import com.proyecto.pizzeria.persitence.entity.PizzaEntity;
import com.proyecto.pizzeria.persitence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    /**
     * funcion busca todas las pizzas que existen
     * @return una lista de pizzas
     */
    public List<PizzaEntity> getAll(){
        return this.pizzaRepository.findAll();
    }

    /**
     * funcion buscar una pizza por su id
     * @param id id de la pizza a buscar
     * @return un objeto PizzaEntity
     */
    public PizzaEntity get(int id){
        return this.pizzaRepository.findById(id).orElse(null);
    }

    /**
     * funcion para agregar una pizza
     * @param pizza objeto pizza a agregar
     * @return el objeto pizza creado
     */
    public PizzaEntity save(PizzaEntity pizza){
        return this.pizzaRepository.save(pizza);
    }

    /**
     * funcion que sirve para saber si existe una pizza
     * @param id id de la pizza a buscar
     * @return booleano que comprueba si existe la pizza
     */
    public boolean exists(int id){
        return this.pizzaRepository.existsById(id);
    }

    /**
     * funcion para eliminar una pizza
     * @param id id de la pizza a eliminar
     */
    public void delete(int id){
        this.pizzaRepository.deleteById(id);
    }

    /**
     * funcion que busca las pizzas con stock
     * @return lista de pizzas con stock
     */
    public List<PizzaEntity> getAvailable(){
        return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    /**
     * funcion que busca una pizza por el nombre
     * @param name nombre de la pizza a buscar
     * @return una pizza con el nombre indicado
     */
    public PizzaEntity getName(String name){
        return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name)
                .orElseThrow(()-> new RuntimeException("La pizza no existe"));
    }

    /**
     * funcion que busca pizzas que contengan el ingrediente pasado por el parametro
     * @param ingredient ingrediente que quieres que contenga la pizza
     * @return lista de pizzas que contengan el ingrediente solicitado
     */
    public List<PizzaEntity> getWith(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }

    /**
     * funcion que busca pizzas que no contengan el ingrediente pasado por el parametro
     * @param ingredient ingrediente que no quieras que contenga la pizza
     * @return lista de pizzas que no contenga el ingrediente solicitado
     */
    public List<PizzaEntity> getWithout(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }

    /**
     * funcion que busca las 3 pizzas de menor o igual precio del parametro pasado
     * @param price valor para buscar pizzas de menor o igual precio
     * @return lista de 3 pizzas de igual o menor precio
     */
    public List<PizzaEntity> getCheapest(double price){
        return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }


}
