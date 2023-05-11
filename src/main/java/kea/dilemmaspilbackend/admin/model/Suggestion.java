package kea.dilemmaspilbackend.admin.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Suggestion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String data;

    public Suggestion(String data){
        this.data = data;
    }

}
