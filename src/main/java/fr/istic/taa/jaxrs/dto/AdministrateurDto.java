package fr.istic.taa.jaxrs.dto;

import java.util.List;

public class AdministrateurDto extends PersonneDto {
    //private long id;
    private List<EvenementDto> evenement; 

    public AdministrateurDto() {
        super();
    }

   
    public AdministrateurDto(long id,String nom, String prenom, String email, String password, List<EvenementDto> evenement) {
        super(id, nom, prenom, email, password);
        this.evenement = evenement;
    }

    

    public List<EvenementDto> getEvenement() { 
        return evenement;
    }
    

    public void setEvenement(List<EvenementDto> evenement) {
         this.evenement = evenement;
     }
}

