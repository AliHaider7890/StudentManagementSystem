package com.example.studentManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Role {

    @Id
    int id;

    private String name;

   public void setRoleId(int setRoleId){
        this.id = setRoleId;
    }

    public int getRoleId(){
       return this.id;
    }

    public void setName(String setName){
       this.name = setName;
    }

    public String getName(){
       return this.name;
    }

}
