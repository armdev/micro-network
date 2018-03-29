/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.web.handlers;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Data
@Setter
@Getter
public class FlightModel implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private Long id;
    
    private Integer year;
    
    private Integer quarter;
  
    private Integer month;
  
    private Integer dayofmonth;
  
    private Integer dayofweek;
   
    private Date flightdate;
   
    private String uniquecarrier;
   
    private Integer airlineid;
   
    private String carrier;
    
    private String tailnum;
   
    private Integer flightnum;
    
    private Integer originairportid;
   
    private Integer originairportseqid;
    
    private Integer origincitymarketid;
   
    private String origin;
   
    private String origincityname;
    
    private String originstate;
   
    private Integer originstatefips;
    
    private String originstatename;
    
    private Integer originwac;
    
    private Integer destairportid;
   
    private Integer destairportseqid;
   
    private Integer destcitymarketid;
  
    private String dest;
    
    private String destcityname;
   
    private String deststate;
   
    private Integer deststatefips;
   
    private String deststatename;

    
    
}
