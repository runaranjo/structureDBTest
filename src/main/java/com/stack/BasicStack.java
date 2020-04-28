/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stack;

/**
 *
 * @author runaranjo
 */
public class BasicStack<X>    //Se crea un metodo generico con el tipo X
{
    private X [] data;   //Se crea un arreglo privado de datos de tipo X - Privado para evitar manipulacion de otras clases
    private int stackPointer;
    
    
    public BasicStack() 
    {
        data = (X[]) new Object[1000];
        stackPointer = 0;
        
    }
    
    public void push(X newItem){
        
        data[stackPointer++] = newItem;
        
        
    }

    
    public X pop(){
        if(stackPointer == 0){
            throw new IllegalStateException("No more items on the stack");
        }
        
        return data[--stackPointer];
        
    }
    
    public boolean contains(X item){   //Retorna true or false dependiendo si el item esta en el stack
        boolean found = false;
        
        for(int i = 0; i <stackPointer; i++){
            if(data[i].equals(item)){
                found = true;
                break;
            }
            
            
        }
        
        return found;
        
    }
    
    public X access(X item){ //Retorna el item
     
        
        while(stackPointer > 0){
            X tmpItem = pop();
            if(item.equals(tmpItem)){
                return tmpItem;
            }
        }
        //If we didn't find the item in the stack throw an exception
        throw new IllegalArgumentException("Could not find item on the stack: "+ item);
    }
    
    public int size(){
        return stackPointer;
    }
    
}
