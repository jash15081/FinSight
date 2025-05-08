package com.FinSight.email_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // Lombok annotation (getters/setters)
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
    private Long id;
    private Double score;
    public Double getScore(){
        return this.score;
    }
    public Long getId(){
        return this.id;
    }
    public void setScore(Double score){
        this.score = score;
    }
    public void setId(Long id){
        this.id = id;
    }
}
